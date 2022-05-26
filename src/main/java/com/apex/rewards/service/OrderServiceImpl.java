package com.apex.rewards.service;


import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.summingInt;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apex.rewards.dao.OrderDao;
import com.apex.rewards.data.MonthlyPoints;
import com.apex.rewards.data.RewardsData;
import com.apex.rewards.order.Order;

@Component
public class OrderServiceImpl implements OrderService {
	private static final double LOWER_TARGET_VALUE = 50d;
	private static final double HIGHER_TARGET_VALUE = 100d;
	private static final int LOWER_REWARD_POINTS = 50;
	private static final int HIGHER_REWARD_POINTS = 2;
	
	@Autowired
	OrderDao orderDao;
	
	private Predicate<Order> eligibleForPoints = order -> (order.getPrice() >= LOWER_TARGET_VALUE);
	
	/**
	 * Returns rewards data in the following format for the last 3 months
	 * 
	 * {
  	 *	"rewardPoints": [
     *    {
     *      "month": "MARCH",
     *      "points": 520
     *    },
     *    {
     *      "month": "APRIL",
     *      "points": 470
     *    },
     *    {
     *      "month": "MAY",
     *      "points": 420
     *    }
  	 *	],
     *  "totalPoints": 1410
     * }
     *
	 */
	@Override		
	public RewardsData getRewardsData() {
		List<Order> orders = orderDao.getOrders();
		
		Stream<Order> ordersEligibleForPoints = orders.stream().filter(eligibleForPoints);
		
		Map<Month, Integer> pointsByMonth = ordersEligibleForPoints.collect(groupingBy(order -> order.getDate().getMonth(),
				collectingAndThen(toList(), list -> list.stream().collect(summingInt(this::pointsForOrder)))));
		
		int totalPoints = pointsByMonth.values().stream().reduce(0,Integer::sum);
		
		RewardsData result = new RewardsData(monthlyPointsForResponse(pointsByMonth),totalPoints);
		return result;
	}
	
	/**
	 * Calculates points based on the price of the order
	 * 
	 * @param order - the order for which points need to be calculated
	 * @return int - points for the order
	 */
	private int pointsForOrder(Order order) {
		int points = 0;
		if(order.getPrice() >= HIGHER_TARGET_VALUE) {
			points = LOWER_REWARD_POINTS + Double.valueOf(order.getPrice() - HIGHER_TARGET_VALUE).intValue() * HIGHER_REWARD_POINTS;
		} else if(order.getPrice() >= LOWER_TARGET_VALUE) {
			points = Double.valueOf(order.getPrice() - LOWER_TARGET_VALUE).intValue();
		}
		return points;
	}
	
	/**
	 * Returns list of MonthlyPoints for clients
	 * 
	 * @param pointsByMonth - Map of Month and points
	 * @return List<MonthlyPoints> - List of MonthlyPoints objects
	 */
	private List<MonthlyPoints> monthlyPointsForResponse(Map<Month, Integer> pointsByMonth) {
		return pointsByMonth.entrySet().stream().map(entry -> new MonthlyPoints(entry.getKey(),entry.getValue())).collect(toList()); 
	}
}

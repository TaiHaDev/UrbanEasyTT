package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Review;

public class ReviewerUltilities {

	public static List<Double> averageRating(List<Review> reviewsList) {
		List<Integer[]> groupedRatings = reviewsList.stream().map(elem -> new Integer[] {elem.getCleanliness(), elem.getCommunication(), elem.getCheckin(), elem.getAccuracy(), elem.getLocation(), elem.getValue()}).collect(Collectors.toList());
		List<Double> averageRatings = new ArrayList<>();
		averageRatings.add(groupedRatings.stream().map(elem -> elem[0]).mapToInt(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[1]).mapToInt(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[2]).mapToInt(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[3]).mapToInt(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[4]).mapToInt(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[5]).mapToInt(e -> e).average().orElse(0));
		return averageRatings.stream().map(e -> Math.round(e * 100) / 100.0).collect(Collectors.toList());
	}
	public static List<Integer> aggregateToPercent(List<Double> averageRating) {
		return averageRating.stream().map(elem -> (int) (elem / 5 * 100)).collect(Collectors.toList());
	}
	
}
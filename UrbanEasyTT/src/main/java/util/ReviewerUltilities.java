package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Review;

public class ReviewerUltilities {

	public static List<Double> averageRating(List<Review> reviewsList) {
		List<Double[]> groupedRatings = reviewsList.stream().map(elem -> new Double[] { elem.getCleanliness(),
				elem.getCommunication(), elem.getCheckin(), elem.getAccuracy(), elem.getLocation(), elem.getValue() })
				.collect(Collectors.toList());
		List<Double> averageRatings = new ArrayList<>();
		averageRatings.add(groupedRatings.stream().map(elem -> elem[0]).mapToDouble(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[1]).mapToDouble(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[2]).mapToDouble(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[3]).mapToDouble(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[4]).mapToDouble(e -> e).average().orElse(0));
		averageRatings.add(groupedRatings.stream().map(elem -> elem[5]).mapToDouble(e -> e).average().orElse(0));
		return averageRatings.stream().map(e -> Math.round(e * 100) / 100.0).collect(Collectors.toList());
	}

	public static List<Integer> aggregateToPercent(List<Double> averageRating) {
		return averageRating.stream().map(elem -> (int) (elem / 5 * 100)).collect(Collectors.toList());
	}

}
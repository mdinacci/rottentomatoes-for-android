package com.marcodinacci.social.rottentomatoes.data;

public interface MovieReviewsList {

	int getTotal();

	MovieReview getFirst();

	MovieReview get(int index);

}

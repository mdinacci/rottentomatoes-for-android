package com.marcodinacci.social.rottentomatoes.data.impl;

import java.util.Iterator;
import java.util.List;

import com.marcodinacci.social.rottentomatoes.data.Movie;
import com.marcodinacci.social.rottentomatoes.data.MovieReview;
import com.marcodinacci.social.rottentomatoes.data.MovieReviewsList;

public class RottenTomatoesMovieReviewList implements MovieReviewsList {
	
	private int total;
	private List<RottenTomatoesMovieReview> reviews;
	
	@Override
	public int getTotal() {
		int i = 0;
		// Just in case total is incorrectly reported as 0
		if (total == 0) {
			Iterator<Movie> it = iterator();
			while(it.hasNext()) {it.next(); i++;}
			return i;
		}

		return total;
	}

	@Override
	public MovieReview getFirst() {
		return reviews.get(0);
	}

	public Iterator<Movie> iterator() {
		@SuppressWarnings("unchecked")
		Iterator<Movie> it = (Iterator<Movie>)(Object)reviews.iterator();
		return it;
	}

	@Override
	public MovieReview get(int index) {
		if(index < getTotal() && index < reviews.size()) {
			return reviews.get(index);
		}

		return null;
	}

}

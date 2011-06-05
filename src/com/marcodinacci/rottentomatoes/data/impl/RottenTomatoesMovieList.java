package com.marcodinacci.rottentomatoes.data.impl;

import java.util.Iterator;
import java.util.List;

import com.marcodinacci.rottentomatoes.data.Movie;
import com.marcodinacci.rottentomatoes.data.MovieList;

public class RottenTomatoesMovieList implements MovieList {

	private int total;
	private List<RottenTomatoesMovie> movies;

	@Override
	public int getTotal() {
		return total;
	}

	@Override
	public Movie getFirst() {
		return movies.get(0);
	}

	public Iterator<Movie> iterator() {
		// to return a Iterator<Movie>
		// (Iterator<Movie>)(Object)
		Iterator<Movie> it = (Iterator<Movie>)(Object)movies.iterator();
		return it;
	}
}

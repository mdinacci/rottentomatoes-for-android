package com.marcodinacci.rottentomatoes.data;


public interface MovieList extends Iterable<Movie> {

	public Movie getFirst();
	public int getTotal();
}

package com.marcodinacci.social.rottentomatoes.data;

public interface MovieList extends Iterable<Movie> {

	public Movie getFirst();
	public Movie get(int index);
	public int getTotal();
}

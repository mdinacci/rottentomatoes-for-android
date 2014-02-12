package com.marcodinacci.social.rottentomatoes.data.impl;

import java.util.Iterator;
import java.util.List;

import com.marcodinacci.social.rottentomatoes.data.Movie;
import com.marcodinacci.social.rottentomatoes.data.MovieList;

public class RottenTomatoesMovieList implements MovieList {

	private int total;
	private List<RottenTomatoesMovie> movies;

	@Override
	public int getTotal() {
		// There's currently a bug in the RT API, when asking for similar movies
		// the Json document does not return the total field.
		int i = 0;
		if(total == 0) {
			Iterator<Movie> it = iterator();
			while(it.hasNext()) {it.next(); i++;}
			return i;
		}
		return total;
	}

	@Override
	public Movie getFirst() {
		return movies.get(0);
	}

	public Iterator<Movie> iterator() {
		@SuppressWarnings("unchecked")
		// Ugly but it's the only way
		Iterator<Movie> it = (Iterator<Movie>)(Object)movies.iterator();
		return it;
	}

	@Override
	public Movie get(int index) {
		// FIXME getTotal should work but sometimes I still get an
		// IndexOutOfBoundsException.
		if(index < getTotal() && index < movies.size()) {
			return movies.get(index);
		}

		return null;
	}
}

package com.marcodinacci.rottentomatoes.data.impl;

import android.util.Log;

import com.marcodinacci.rottentomatoes.data.Movie;
import com.marcodinacci.rottentomatoes.data.MoviePoster;

public class RottenTomatoesMovie implements Movie {

	private static final String TAG = RottenTomatoesMovie.class.getName();
	
	private String title;
	private String synopsis;
	private RottenTomatoesMoviePoster posters;
	
	public RottenTomatoesMovie() {
		Log.d(TAG, "Created a new RottenTomatoesMovie");
	}
	
	@Override
	public String getAttribute(String key) {
		// XXX I wish Java had a switch working with Strings too...
		
		if(key == Movie.KEY_ENGLISH_TITLE)
			return title;
		else if(key == Movie.KEY_SYNOPSIS)
			return synopsis;
		
		return "unsupported key";
	}

	@Override
	public MoviePoster getMoviePoster() {
		return (MoviePoster)posters;
	}
}

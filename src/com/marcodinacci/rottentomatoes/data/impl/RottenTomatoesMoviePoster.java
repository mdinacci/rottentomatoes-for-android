package com.marcodinacci.rottentomatoes.data.impl;

import com.marcodinacci.rottentomatoes.data.Movie;
import com.marcodinacci.rottentomatoes.data.MoviePoster;

public class RottenTomatoesMoviePoster implements MoviePoster {
	private String thumbnail;
	private String profile;
	private String detailed;
	private String original;
	
	@Override
	public String getAttribute(String key) {
		String attr = null;
		if(key == Movie.KEY_POSTER_THUMBNAIL)
			attr = thumbnail;
		else if(key == Movie.KEY_POSTER_PROFILE) 
			attr = profile;
		else if(key == Movie.KEY_POSTER_DETAILED) 
			attr = detailed;
		else if(key == Movie.KEY_POSTER_ORIGINAL) 
			attr = original;
		return attr;
	}
}

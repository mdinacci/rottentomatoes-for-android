package com.marcodinacci.rottentomatoes.data;

public interface Movie extends KeyAttribute {

	public static final String KEY_ID = "_id";
	public static final String KEY_ORIGINAL_TITLE = "original_title";
	public static final String KEY_ENGLISH_TITLE = "title";
	public static final String KEY_DIRECTOR = "director";
	public static final String KEY_RELEASE_DATES = "_id";
	public static final String KEY_GENRES = "genres";
	public static final String KEY_MPAA_RATING = "_id";
	public static final String KEY_RUNTIME = "runtime";
	public static final String KEY_RATINGS = "ratings";
	public static final String KEY_SYNOPSIS= "synopsis";
	public static final String KEY_POSTER_THUMBNAIL = "poster_thumbnail";
	public static final String KEY_POSTER_PROFILE = "poster_profile";
	public static final String KEY_POSTER_DETAILED = "poster_detailed";
	public static final String KEY_POSTER_ORIGINAL = "poster_original";
	
	public MoviePoster getMoviePoster();
}

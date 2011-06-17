package com.marcodinacci.social.rottentomatoes.data;

import android.os.Parcelable;

public interface Movie extends KeyAttribute, Parcelable {

	public static final String KEY_ID = "_id";
	public static final String KEY_ORIGINAL_TITLE = "original_title";
	public static final String KEY_ENGLISH_TITLE = "title";
	public static final String KEY_DIRECTOR = "director";
	public static final String KEY_RELEASE_DATES = "_id";
	public static final String KEY_GENRES = "genres";
	public static final String KEY_MPAA_RATING = "_id";
	public static final String KEY_RUNTIME = "runtime";
	public static final String KEY_RATINGS = "ratings";
	public static final String KEY_CRITICS_RATING = "critics_rating";
	public static final String KEY_AUDIENCE_RATING = "audience_rating";
	public static final String KEY_CRITICS_SCORE = "critics_score";
	public static final String KEY_AUDIENCE_SCORE = "audience_score";
	public static final String KEY_AVERAGE_SCORE = "average_score";
	public static final String KEY_SYNOPSIS = "synopsis";
	public static final String KEY_POSTER_THUMBNAIL = "poster_thumbnail";
	public static final String KEY_POSTER_PROFILE = "poster_profile";
	public static final String KEY_POSTER_DETAILED = "poster_detailed";
	public static final String KEY_POSTER_ORIGINAL = "poster_original";
	public static final String KEY_CRITICS_CONSENSUS = "critics_consensus";
	public static final String KEY_LINKS = "links";
	public static final String KEY_LINK_SIMILAR = "links";
	public static final String KEY_RELEASE_DATE_THEATER = "release_date_theater";
	public static final String KEY_RELEASE_DATE_DVD = "release_date_dvd";
	public static final String KEY_RELEASE_YEAR = "release_year";
	
	public MoviePoster getMoviePoster();
	public MovieRatings getMovieRatings();
	public MovieLinks getMovieLinks();
	public MovieCast getMovieCast();
	public MovieRelease getMovieRelease();
}

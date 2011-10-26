package com.marcodinacci.social.rottentomatoes.data.impl;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.marcodinacci.social.rottentomatoes.data.Movie;
import com.marcodinacci.social.rottentomatoes.data.MovieCast;
import com.marcodinacci.social.rottentomatoes.data.MovieLinks;
import com.marcodinacci.social.rottentomatoes.data.MoviePoster;
import com.marcodinacci.social.rottentomatoes.data.MovieRatings;
import com.marcodinacci.social.rottentomatoes.data.MovieRelease;

public class RottenTomatoesMovie implements Movie {

	public static final Parcelable.Creator<RottenTomatoesMovie> 
     CREATOR
            = new Parcelable.Creator<RottenTomatoesMovie>() {
        public RottenTomatoesMovie createFromParcel(Parcel in) {
            return new RottenTomatoesMovie(in);
        }

        public RottenTomatoesMovie[] newArray(int size) {
            return new RottenTomatoesMovie[size];
        }
    };
    
	private static final String TAG = RottenTomatoesMovie.class.getName();
	
	private String title;
	private String synopsis;
	private String critics_consensus;
	private RottenTomatoesMoviePoster posters;
	private RottenTomatoesMovieRatings ratings;
	private RottenTomatoesMovieLinks links;
	private List<RottenTomatoesMovieRole> abridged_cast;
	private RottenTomatoesMovieRelease release_dates;
	
	public RottenTomatoesMovie() {
		Log.d(TAG, "Created a new RottenTomatoesMovie");
	}
	
	@SuppressWarnings("unchecked")
	public RottenTomatoesMovie(Parcel in) {
		title = in.readString();
		synopsis = in.readString();
		critics_consensus = in.readString();
		
		ClassLoader cl = getClass().getClassLoader();
		
		posters = in.readParcelable(cl);
		ratings = in.readParcelable(cl);
		links = in.readParcelable(cl);
		abridged_cast = in.readArrayList(cl);
		release_dates = in.readParcelable(cl);
	}
	
	@Override
	public String getAttribute(String key) {
		// XXX I wish Java had a switch working with Strings too...
		
		String result = "unsupported key";
		
		if(key == Movie.KEY_ENGLISH_TITLE)
			result = title;
		else if(key == Movie.KEY_SYNOPSIS)
			result = synopsis;
		else if(key == Movie.KEY_CRITICS_CONSENSUS)
			result = critics_consensus;
		else if(key == Movie.KEY_AVERAGE_SCORE) {
			result = ratings.getAttribute(key);
		} else if(key == Movie.KEY_RELEASE_YEAR) {
			result = release_dates.getReleaseYear();
		}
		
		return result;
	}

	
	@Override
	public MoviePoster getMoviePoster() {
		return (MoviePoster)posters;
	}

	@Override
	public MovieRatings getMovieRatings() {
		return (MovieRatings)ratings;
	}

	@Override
	public MovieLinks getMovieLinks() {
		return (MovieLinks)links;
	}
	
	@Override
	public MovieCast getMovieCast() {
		return new RottenTomatoesMovieCast(abridged_cast);
	}
	
	@Override
	public MovieRelease getMovieRelease() {
		return (MovieRelease)release_dates;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(title);
		dest.writeString(synopsis);
		dest.writeString(critics_consensus);
		dest.writeParcelable(posters, flags);
		dest.writeParcelable(ratings, flags);
		dest.writeParcelable(links, flags);
		dest.writeList(abridged_cast);
		dest.writeParcelable(release_dates, flags);
	}
}

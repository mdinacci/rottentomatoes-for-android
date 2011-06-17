package com.marcodinacci.social.rottentomatoes.data.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.marcodinacci.social.rottentomatoes.data.Movie;
import com.marcodinacci.social.rottentomatoes.data.MovieRatings;

public class RottenTomatoesMovieRatings implements MovieRatings {

	public static final Parcelable.Creator<RottenTomatoesMovieRatings> 
    CREATOR
           = new Parcelable.Creator<RottenTomatoesMovieRatings>() {
       public RottenTomatoesMovieRatings createFromParcel(Parcel in) {
           return new RottenTomatoesMovieRatings(in);
       }

       public RottenTomatoesMovieRatings[] newArray(int size) {
           return new RottenTomatoesMovieRatings[size];
       }
   };
   
	private int critics_score;
	private int audience_score;

	public RottenTomatoesMovieRatings(Parcel in) {
		critics_score = in.readInt();
		audience_score = in.readInt();
	}

	@Override
	public int getAverageScore() {
		return (critics_score + audience_score) / 2;
	}

	@Override
	public String getAttribute(String key) {
		String result = "unsupported key";
		
		if(key == Movie.KEY_AVERAGE_SCORE)
			result = Integer.toString(getAverageScore());
			
		return result;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(critics_score);
		dest.writeInt(audience_score);
	}
}

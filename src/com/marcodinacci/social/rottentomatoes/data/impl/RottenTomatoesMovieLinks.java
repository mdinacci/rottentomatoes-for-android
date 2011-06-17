package com.marcodinacci.social.rottentomatoes.data.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.marcodinacci.social.rottentomatoes.data.Movie;
import com.marcodinacci.social.rottentomatoes.data.MovieLinks;

public class RottenTomatoesMovieLinks implements MovieLinks {
	
	public static final Parcelable.Creator<RottenTomatoesMovieLinks> 
    CREATOR
           = new Parcelable.Creator<RottenTomatoesMovieLinks>() {
       public RottenTomatoesMovieLinks createFromParcel(Parcel in) {
           return new RottenTomatoesMovieLinks(in);
       }

       public RottenTomatoesMovieLinks[] newArray(int size) {
           return new RottenTomatoesMovieLinks[size];
       }
   };
	
	public String similar;
	public String reviews;

	public RottenTomatoesMovieLinks(Parcel in) {
		similar = in.readString();
		reviews = in.readString();
	}

	@Override
	public String getAttribute(String key) {
		String attr = "unsupported key";
		
		if(key == Movie.KEY_LINK_SIMILAR)
			attr = similar;
		
		return attr;
	}

	public String getSimilarMoviesLink() {
		return similar;
	}
	
	public String getReviewsLink() {
		return reviews;
	}
	
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(similar);
		dest.writeString(reviews);
	}

}

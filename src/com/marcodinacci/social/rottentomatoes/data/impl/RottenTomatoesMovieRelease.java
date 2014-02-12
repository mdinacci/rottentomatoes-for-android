package com.marcodinacci.social.rottentomatoes.data.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.marcodinacci.social.rottentomatoes.data.Movie;
import com.marcodinacci.social.rottentomatoes.data.MovieRelease;

public class RottenTomatoesMovieRelease implements MovieRelease {

	private String theater;
	private String dvd;
	
	public static final Parcelable.Creator<RottenTomatoesMovieRelease> 
    CREATOR
           = new Parcelable.Creator<RottenTomatoesMovieRelease>() {
       public RottenTomatoesMovieRelease createFromParcel(Parcel in) {
           return new RottenTomatoesMovieRelease(in);
       }

       public RottenTomatoesMovieRelease[] newArray(int size) {
           return new RottenTomatoesMovieRelease[size];
       }
   };
	
	public RottenTomatoesMovieRelease(Parcel in) {
		theater = in.readString();
		dvd = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(theater);
		dest.writeString(dvd);
	}

	@Override
	public String getAttribute(String key) {
		String attr = "";
		if(key == Movie.KEY_RELEASE_DATE_THEATER) {
			attr = theater;
		} else if (key == Movie.KEY_RELEASE_DATE_DVD) {
			attr = dvd;
		} else if (key == Movie.KEY_RELEASE_YEAR) {
			attr = getReleaseYear();
		}
		
		return  attr;
	}

	public String getReleaseYear() {
		if(theater != null) {
			return theater.substring(0, theater.indexOf('-'));
		}

		return "";
	}

}

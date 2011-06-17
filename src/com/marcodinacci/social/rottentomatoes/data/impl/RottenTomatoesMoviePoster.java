package com.marcodinacci.social.rottentomatoes.data.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.marcodinacci.social.rottentomatoes.data.Movie;
import com.marcodinacci.social.rottentomatoes.data.MoviePoster;

public class RottenTomatoesMoviePoster implements MoviePoster {
	
	public static final Parcelable.Creator<RottenTomatoesMoviePoster> 
    CREATOR
           = new Parcelable.Creator<RottenTomatoesMoviePoster>() {
       public RottenTomatoesMoviePoster createFromParcel(Parcel in) {
           return new RottenTomatoesMoviePoster(in);
       }

       public RottenTomatoesMoviePoster[] newArray(int size) {
           return new RottenTomatoesMoviePoster[size];
       }
   };
   
	private String thumbnail;
	private String profile;
	private String detailed;
	private String original;
	
	public RottenTomatoesMoviePoster(Parcel in) {
		thumbnail = in.readString();
		profile = in.readString();
		detailed = in.readString();
		original = in.readString();
	}

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(thumbnail);
		dest.writeString(profile);
		dest.writeString(detailed);
		dest.writeString(original);
	}
}

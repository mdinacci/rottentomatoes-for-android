package com.marcodinacci.social.rottentomatoes.data.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.marcodinacci.social.rottentomatoes.data.MovieReview;

public class RottenTomatoesMovieReview implements MovieReview {

	public static final Parcelable.Creator<RottenTomatoesMovieReview> 
    CREATOR
           = new Parcelable.Creator<RottenTomatoesMovieReview>() {
       public RottenTomatoesMovieReview createFromParcel(Parcel in) {
           return new RottenTomatoesMovieReview(in);
       }

       public RottenTomatoesMovieReview[] newArray(int size) {
           return new RottenTomatoesMovieReview[size];
       }
   };
   
   	private String critic;
   	private String date;
   	private String publication;
	private String original_score;
	private String quote;

	public RottenTomatoesMovieReview(Parcel in) {
		critic = in.readString();
		date = in.readString();
		publication = in.readString();
		quote = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(critic);
		dest.writeString(date);
		dest.writeString(publication);
		dest.writeString(quote);
	}

	@Override
	public String getCritic() {
		return critic;
	}

	@Override
	public String getPublication() {
		return publication;
	}

	@Override
	public String getRating() {
		return original_score;
	}

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public String getQuote() {
		return quote;
	}

}

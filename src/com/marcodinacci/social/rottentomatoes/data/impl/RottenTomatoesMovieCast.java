package com.marcodinacci.social.rottentomatoes.data.impl;

import java.util.Iterator;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.marcodinacci.social.rottentomatoes.data.MovieCast;
import com.marcodinacci.social.rottentomatoes.data.MovieRole;

public class RottenTomatoesMovieCast implements MovieCast {

	public static final Parcelable.Creator<RottenTomatoesMovieCast> 
    CREATOR
           = new Parcelable.Creator<RottenTomatoesMovieCast>() {
       public RottenTomatoesMovieCast createFromParcel(Parcel in) {
           return new RottenTomatoesMovieCast(in);
       }

       public RottenTomatoesMovieCast[] newArray(int size) {
           return new RottenTomatoesMovieCast[size];
       }
    };
    
	private List<RottenTomatoesMovieRole> mRoles;
   
	public RottenTomatoesMovieCast(List<RottenTomatoesMovieRole> abridged_cast) {
		mRoles = abridged_cast;
	}
	
	@SuppressWarnings("unchecked")
	public RottenTomatoesMovieCast(Parcel in) {
		mRoles = in.readArrayList(getClass().getClassLoader());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(mRoles);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<MovieRole> iterator() {
		return (Iterator<MovieRole>)(Object)mRoles.iterator();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (MovieRole mr : mRoles) {
			sb.append(mr.toString() + ", ");
		}
		
		String str = sb.toString();
		
		return str.substring(0, str.length()-2); // get rid of comma.
	}
}

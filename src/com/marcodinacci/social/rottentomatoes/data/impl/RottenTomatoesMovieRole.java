package com.marcodinacci.social.rottentomatoes.data.impl;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.marcodinacci.social.rottentomatoes.data.MovieRole;

public class RottenTomatoesMovieRole implements MovieRole {

	public static final Parcelable.Creator<RottenTomatoesMovieRole> 
    CREATOR
           = new Parcelable.Creator<RottenTomatoesMovieRole>() {
       public RottenTomatoesMovieRole createFromParcel(Parcel in) {
           return new RottenTomatoesMovieRole(in);
       }

       public RottenTomatoesMovieRole[] newArray(int size) {
           return new RottenTomatoesMovieRole[size];
       }
    };
    
	private String name;
	private List<String> characters;
    
    @SuppressWarnings("unchecked")
	public RottenTomatoesMovieRole(Parcel in) {
    	name = in.readString();
    	characters = in.readArrayList(getClass().getClassLoader());
	}
    
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeList(characters);
	}
	
	@Override
	public String toString() {
		// Everything can be null
		
		if(characters == null) {
			String result = name;
			if(name == null) {
				result = "";
			}
			
			return result;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(name).append(": (");
		for (String role : characters) {
			sb.append(role);
			sb.append(", ");
		}
		
		String str = sb.toString().toString();
		return str.substring(0, str.length() - 2) + ") ";
	}
}

package com.marcodinacci.social.rottentomatoes.data;

import android.os.Parcelable;

public interface MovieRatings extends KeyAttribute, Parcelable {

	public int getAverageScore();
}

package com.marcodinacci.social.rottentomatoes.data;

import android.os.Parcelable;

public interface MovieReview extends Parcelable {

	public String getCritic();
	public String getPublication();
	public String getRating();
	public String getDate();
	public String getQuote();
}

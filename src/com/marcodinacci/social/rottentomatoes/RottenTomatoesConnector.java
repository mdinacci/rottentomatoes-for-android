package com.marcodinacci.social.rottentomatoes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.net.Uri;
import android.util.Log;

import com.marcodinacci.commons.data.Unmarshaller;
import com.marcodinacci.commons.data.impl.JSONUnmarshaller;
import com.marcodinacci.commons.network.ConnectivityFailure;
import com.marcodinacci.commons.network.SimpleConnector;
import com.marcodinacci.social.rottentomatoes.data.impl.RottenTomatoesMovieList;
import com.marcodinacci.social.rottentomatoes.data.impl.RottenTomatoesMovieReviewList;

public class RottenTomatoesConnector extends SimpleConnector {

	private static final String TAG = RottenTomatoesConnector.class.getSimpleName();

	private static final String HOST = "api.rottentomatoes.com";
	private static final String API_KEY_PARAM = "?apikey=".intern();
	private static final String QUERY_KEY_PARAM = "&q=";
	private static final String DEFAULT_ENCODING = "utf-8";

	private static final String MOVIE_SEARCH_ENDPOINT = "/api/public/v1.0/movies.json";

	private String mApiKey;

	public RottenTomatoesConnector(String apiKey, String callback) {
		super(HOST);

		mApiKey = apiKey;
		mApiKey.intern();
	}

	@Override
	public String get(String query) {
		String response = "";
		try {
			
			response = super.get(query);
		} catch (ConnectivityFailure inae) {
			Log.e(TAG, "Request failed, probably internet is not available");
			// TODO escalate error to UI
		}

		return response;
	}

	/**
	 * Search for a movie. 
	 * @param movie The title of the movie to search.
	 * @return a list of possible matches.
	 */
	public RottenTomatoesMovieList searchMovie(String movie) {
		StringBuffer sb = new StringBuffer();
		try {
			sb.append(MOVIE_SEARCH_ENDPOINT).append(API_KEY_PARAM)
					.append(mApiKey).append(QUERY_KEY_PARAM)
					.append(URLEncoder.encode(movie, DEFAULT_ENCODING));
		} catch (UnsupportedEncodingException e) {
			Log.e(TAG, "IMPOSSIBLE");
		}
		
		return getMovieListFromJson(get(sb.toString()));
	}

	public RottenTomatoesMovieList getRelatedMovies(String uri) {
		if(uri.contains(HOST))
			uri = uri.substring(uri.indexOf("com/")+3);
		uri += API_KEY_PARAM + mApiKey;
		
		Log.d(TAG, "Getting related movies from: " + uri);
		
		return getMovieListFromJson(get(uri));
	}
	/**
	 * It expects that the uri already contains the movie ID.
	 * 
	 * @param uri Endpoint to query for related movies. 
	 * @return a list of related movies
	 */
	public RottenTomatoesMovieList getRelatedMovies(Uri uri) {
		
		return getMovieListFromJson(get(uri.toString()));
	}

	/* Transform a JSON document in a RottenTomatoesMovieList */
	private RottenTomatoesMovieList getMovieListFromJson(String json) {
		if (Log.isLoggable(TAG, Log.VERBOSE))
			Log.v(TAG, "Response: " + json);

		Unmarshaller<RottenTomatoesMovieList> unmarshaller = 
			new JSONUnmarshaller<RottenTomatoesMovieList>();
		
		return unmarshaller.unmarshal(RottenTomatoesMovieList.class, json);
	}

	public RottenTomatoesMovieReviewList getReviews(String uri) {
		if(uri.contains(HOST))
			uri = uri.substring(uri.indexOf("com/")+3);
		uri += API_KEY_PARAM + mApiKey;
		
		Log.d(TAG, "Getting reviews from: " + uri);
		
		return getReviewListFromJson(get(uri));
	}

	private RottenTomatoesMovieReviewList getReviewListFromJson(String json) {
		if (Log.isLoggable(TAG, Log.VERBOSE))
			Log.v(TAG, "Response: " + json);

		Unmarshaller<RottenTomatoesMovieReviewList> unmarshaller = 
			new JSONUnmarshaller<RottenTomatoesMovieReviewList>();
		
		return unmarshaller.unmarshal(RottenTomatoesMovieReviewList.class, json);
	}
}

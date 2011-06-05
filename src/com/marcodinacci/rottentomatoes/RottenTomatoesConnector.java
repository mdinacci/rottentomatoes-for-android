package com.marcodinacci.rottentomatoes;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.marcodinacci.commons.data.Unmarshaller;
import com.marcodinacci.commons.data.impl.JSONUnmarshaller;
import com.marcodinacci.commons.network.SimpleConnector;
import com.marcodinacci.rottentomatoes.data.impl.RottenTomatoesMovie;
import com.marcodinacci.rottentomatoes.data.impl.RottenTomatoesMovieList;

public class RottenTomatoesConnector extends SimpleConnector {

	private static final String TAG = "[RTC]";

	private static final String HOST = "api.rottentomatoes.com";
	private static final String API_KEY_PARAM = "?apikey=".intern();
	private static final String QUERY_KEY_PARAM = "&q=";
	private static final String DEFAULT_ENCODING = "utf-8";

	private static final String MOVIE_SEARCH_ENDPOINT = "/api/public/v1.0/movies.json";

	private static final String MOVIE_SIMILAR_ENDPOINT = "/api/public/v1.0/movies/$/similar.json";

	private static final String MOVIE_INFO_ENDPOINT = "/api/public/v1.0/movies/$.json";

	private String mCallback;
	private String mApiKey;
	private String mCurrentEndpoint;

	public RottenTomatoesConnector(String apiKey, String callback) {
		super(HOST);

		mApiKey = apiKey;
		mApiKey.intern();

		mCallback = callback;

		mCurrentEndpoint = MOVIE_SEARCH_ENDPOINT;

	}

	@Override
	public String get(String query) {
		String response = "";
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(HOST).append(mCurrentEndpoint).append(API_KEY_PARAM)
					.append(mApiKey).append(QUERY_KEY_PARAM)
					.append(URLEncoder.encode(query, DEFAULT_ENCODING));

			response = super.get(sb.toString());
		} catch (UnsupportedEncodingException e) {
			Log.e(TAG, "IMPOSSIBLE");
		}

		return response;
	}

	// TODO for the moment just return the first entry.
	// TODO should return a list of movies and the user can select the one
	// most appropriate.
	public RottenTomatoesMovieList searchMovie(String movie) {
		mCurrentEndpoint = MOVIE_SEARCH_ENDPOINT;

		String json = get(movie);
		Log.d(TAG, "RESPONSE: " + json);

		if (Log.isLoggable(TAG, Log.VERBOSE))
			Log.v(TAG, json);

		Unmarshaller<RottenTomatoesMovieList> unmarshaller = 
			new JSONUnmarshaller<RottenTomatoesMovieList>();
		
		return unmarshaller.unmarshal(RottenTomatoesMovieList.class, json);
	}

	public String getRelatedMovies(String movieId) {
		mCurrentEndpoint = MOVIE_SIMILAR_ENDPOINT.replace("$", movieId);

		return get("");
	}

	public String getMovieInfo(String movieId) {
		mCurrentEndpoint = MOVIE_INFO_ENDPOINT.replace("$", movieId);

		return get("");
	}
}

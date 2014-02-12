package com.marcodinacci.commons.data.impl;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.marcodinacci.commons.data.Unmarshaller;
import com.marcodinacci.commons.data.UnmarshallerException;

/**
 * Unmarshal JSON data. It relies on the Gson library.
 */
public final class JSONUnmarshaller<T> implements Unmarshaller<T> {

	@Override
	public T unmarshal(Class<T> rootClass, String data)
			throws UnmarshallerException {
		return new Gson().fromJson(data, rootClass);
	}

	public T unmarshal(Type type, String data)
			throws UnmarshallerException {
		return new Gson().fromJson(data, type);
	}
}
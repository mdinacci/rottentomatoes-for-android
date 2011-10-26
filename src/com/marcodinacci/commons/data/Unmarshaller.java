package com.marcodinacci.commons.data;

/**
 * Unmarshal the given data to an object of the class T
 * 
 * @param <T> The Class of the object that will be unmarshalled.
 */
public interface Unmarshaller<T> {

	/**
	 * Unmarshal a String into an object of class T
	 * 
	 * @param rootClass
	 *            The class of the unmarshalled object.
	 * @param data
	 *            A String containing the raw data to unmarshal
	 * @return a new object of type T
	 * @throws Exception
	 */
	public T unmarshal(Class<T> rootClass, String data)
			throws UnmarshallerException;
}

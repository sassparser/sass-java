package com.sassparser.parser;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Marcellus Tavares
 */
public class URLStyleSheetResource implements StyleSheetResource {

	public URLStyleSheetResource(URL url) {
		_url = url;
	}

	public InputStream getInputStream() throws Exception {
		URLConnection urlConnection = _url.openConnection();

		return urlConnection.getInputStream();
	}

	private URL _url;

}

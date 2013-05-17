package com.sassparser.parser;

import java.io.InputStream;

/**
 * @author Marcellus Tavares
 */
public interface StyleSheetResource {

	public InputStream getInputStream() throws Exception;

}

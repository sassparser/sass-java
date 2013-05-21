package com.sassparser.io;

import java.io.OutputStream;

import com.sassparser.model.StyleSheet;

public interface StyleSheetWriter {

	public void write(StyleSheet styleSheet, OutputStream outputStream)
		throws Exception;

}

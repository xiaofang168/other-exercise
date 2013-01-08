/*		
 * Copyright 2012 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,2012-11-30 cognos Exp $
 * created at:下午08:34:47
 */
package com.fangj.exercise.models;

/**
 * @author cognos
 * 
 */
public class Person {
	private String readwrite;
	private String readonly;

	public String getReadwrite() {
		return readwrite;
	}

	public void setReadwrite(String readwrite) {
		this.readwrite = readwrite;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

}

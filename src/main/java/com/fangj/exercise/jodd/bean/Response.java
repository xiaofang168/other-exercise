package com.fangj.exercise.jodd.bean;

import java.util.List;

import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class Response {
	
	private final String html;
	private final CookieStore cookieStore;
	private final StatusLine statusLine;

	public Response(String html, StatusLine statusLine, CookieStore cookieStore) {
		this.html = html;
		this.cookieStore = cookieStore;
		this.statusLine = statusLine;
	}

	public String getHtml() {
		return html;
	}

	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public List<Cookie> getCookies() {
		return cookieStore.getCookies();
	}

	public StatusLine getStatusLine() {
		return statusLine;
	}
}

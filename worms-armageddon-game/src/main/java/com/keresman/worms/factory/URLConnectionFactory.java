package com.keresman.worms.factory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class URLConnectionFactory {

    private static final int TIMEOUT = 10_000;

    private static final String REQUEST_METHOD_GET = "GET";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final String USER_AGENT_VALUE = "Mozilla/5.0";

    private URLConnectionFactory() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static HttpURLConnection getHttpUrlConnection(String path) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(path).openConnection();
        connection.setConnectTimeout(TIMEOUT);
        connection.setReadTimeout(TIMEOUT);
        connection.setRequestMethod(REQUEST_METHOD_GET);
        connection.addRequestProperty(HEADER_USER_AGENT, USER_AGENT_VALUE);
        return connection;
    }
}

/*
 * Copyright (c) 2021, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.smart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmartJDBCClient {

  public static final String SMARTJDBC_SERVER_URL = ConfigUtil.getSmartJDBCServerUrl();

  public static String request(String request) throws IOException {
    URL url = new URL(SMARTJDBC_SERVER_URL);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/json; utf-8");
    conn.setRequestProperty("Accept", "application/json");
    conn.setDoOutput(true);
    byte[] input = request.getBytes("utf-8");
    conn.getOutputStream().write(input, 0, input.length);
    if (conn.getResponseCode() != 200) {
      throw new IOException("[SmartJDBCClient->request] response code = " + conn.getResponseCode());
    }
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
    StringBuilder response = new StringBuilder();
    String responseLine = null;
    while ((responseLine = bufferedReader.readLine()) != null) {
      response.append(responseLine);
      response.append(System.lineSeparator());
    }
    return response.toString();
  }
}

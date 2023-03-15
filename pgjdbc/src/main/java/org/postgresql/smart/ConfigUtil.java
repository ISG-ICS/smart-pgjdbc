/*
 * Copyright (c) 2021, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.smart;

import org.postgresql.util.OSUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

  private static final String CONFIG_PATH = OSUtil.getUserConfigRootDirectory() + "/smart-pgjdbc.config";
  private static final String SMARTJDBC_SERVER_URL_DEFAULT = "http://localhost:8000";
  private static final String APP_GUID = "App007";

  public static Properties readConfigProperties() throws IOException {
    File configFile = new File(CONFIG_PATH);
    FileReader cofingFileReader = new FileReader(configFile);
    Properties properties = new Properties();
    properties.load(cofingFileReader);
    return properties;
  }

  public static String getSmartJDBCServerUrl() {
    try {
      Properties properties = readConfigProperties();
      return properties.getProperty("smartjdbc.server.url");
    } catch (IOException e) {
      return SMARTJDBC_SERVER_URL_DEFAULT;
    }
  }

  public static String getAppGuid() {
    try {
      Properties properties = readConfigProperties();
      return properties.getProperty("app.guid");
    } catch (IOException e) {
      return APP_GUID;
    }
  }
}

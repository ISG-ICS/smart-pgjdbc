/*
 * Copyright (c) 2021, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.smart;

import org.postgresql.util.OSUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class LogUtil {

  public static final String LOG_PATH = OSUtil.getUserConfigRootDirectory() + "/smart-pgjdbc.log";

  public static void log(String text) throws SQLException {
    try {
      // Create log file if not exists.
      File logFile = new File(LOG_PATH);
      logFile.createNewFile();
      // Append text to log file
      FileWriter logAppender = new FileWriter(LOG_PATH, true);
      logAppender.append(text);
      logAppender.append("\n");
      logAppender.close();
    } catch (IOException e) {
      throw new SQLException(e + "\n" + LOG_PATH);
    }
  }
}

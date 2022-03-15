/*
 * Copyright (c) 2021, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.smart;

import java.io.IOException;

public class QueryRewritter {

  public static String rewriteQuery(String sql) {
    try {
      return SmartJDBCClient.request(sql);
    } catch (IOException e) {
      return sql;
    }
  }
}

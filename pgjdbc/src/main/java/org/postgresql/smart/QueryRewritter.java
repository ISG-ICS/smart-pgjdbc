/*
 * Copyright (c) 2021, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.smart;

import java.io.IOException;

public class QueryRewritter {

  public static String rewriteQuery(String guid, String sql) {
    try {
      return SmartJDBCClient.request("{\"cmd\": \"rewrite\", \"db\": \"postgresql\", \"query\": \"" + sql.replace("\"", "\\\"") + "\", \"guid\": \"" + guid + "\", \"appguid\": \"" + ConfigUtil.getAppGuid() + "\"}");
    } catch (IOException e) {
      return sql;
    }
  }

  public static boolean reportQuery(String guid, long queryTimeMs) {
    try {
      SmartJDBCClient.request("{\"cmd\": \"report\", \"db\": \"postgresql\", \"queryTimeMs\": " + String.valueOf(queryTimeMs) + ", \"guid\": \"" + guid + "\", \"appguid\": \"" + ConfigUtil.getAppGuid() + "\"}");
      return true;
    } catch (IOException e) {
      return false;
    }
  }
}

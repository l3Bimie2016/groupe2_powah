package fr.assurance;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

import java.util.List;

/**
 * Created by Max on 07/04/2016.
 */
public class SqlQuery {

    private static JsonObject mySQLClientConfig = new JsonObject()
            .put("host", "localhost")
            .put("port", 3306)
            .put("username", "root")
            .put("password", "1234")
            .put("database", "vertx_assurance");

    public static void execQuery(String querySql, JsonArray params, Handler<AsyncResult<JsonObject>> handler){
        Vertx vertx = Vertx.currentContext().owner();

        vertx.runOnContext(x -> {
            AsyncSQLClient mySQLClient = MySQLClient.createShared(vertx, mySQLClientConfig);

            mySQLClient.getConnection(res -> { System.out.println("-- 1");

                if (res.succeeded()) {
                    System.out.println("-- 2 "+querySql);
                    //System.out.println("-- 2 "+(params == null ? "" : params.getString(0)));
                    SQLConnection connection = res.result();

                    connection.queryWithParams(querySql, params, query -> {
                        System.out.println("-- 3");
                        if (query.succeeded()) {
                            System.out.println("-- 4");
                            handler.handle(Future.succeededFuture(query.result().toJson()));
                            connection.close();
                        } else {
                            System.out.println("-- 5");
                            handler.handle(Future.failedFuture(query.cause()));
                        }
                    });
                } else {
                    System.out.println("-- 6 "+res.cause().getMessage());
                    handler.handle(Future.failedFuture(res.cause()));
                }
            });
        });
    }
}

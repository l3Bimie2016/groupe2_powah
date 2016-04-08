package fr.assurance;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.JWTAuthHandler;

import java.util.List;

/**
 * Created by Max on 04/04/2016.
 */
public class App extends AbstractVerticle {

    public static void main(String[] args){
        Vertx v = Vertx.vertx();
        v.deployVerticle(App.class.getCanonicalName());

    }

    private JWTAuth authProvider;

    private JsonObject mySQLClientConfig = new JsonObject()
            .put("host", "localhost")
            .put("port", 3306)
            .put("username", "rootpass")
            .put("password", "plop")
            .put("database", "vertx_assurance");

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8090);

        JsonObject config = new JsonObject().put("keyStore", new JsonObject()
                .put("path", "keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));

        authProvider = JWTAuth.create(vertx, config);

        router.route("/private/*").handler(JWTAuthHandler.create(authProvider));

        router.post("/login").consumes("application/json").handler(x -> { System.out.println("-- /login");
            JsonObject json = x.getBodyAsJson();
            String username = json.getString("username");
            String password = json.getString("password");

            userExist(x, username, password);
        });

        // Récupère tous les failure
        router.route().failureHandler(x -> {

        });

        router.post("/list").consumes("application/json").handler(x -> { System.out.println("-- /list");

            JsonObject json = x.getBodyAsJson();
            String action = json.getString("action");
            Integer marque = json.getInteger("marque");
            Integer modele = json.getInteger("modele");
            Integer chevaux = json.getInteger("chevaux");
            Integer carburant = json.getInteger("carburant");



            /*
            AsyncSQLClient mySQLClient = MySQLClient.createShared(vertx, mySQLClientConfig);

            mySQLClient.getConnection(res -> { System.out.println("-- 1");

                if (res.succeeded()) { System.out.println("-- 2");

                    SQLConnection connection = res.result();


                    JsonObject json = new JsonObject();

                    connection.query("SELECT * FROM voiture", query -> {
                        System.out.println("-- 3");
                        if (query.succeeded()) {
                            System.out.println("-- 4");
                            // Get the result set
                            ResultSet resultSet = query.result();
                            List<JsonArray> results = resultSet.getResults();
                            int i = 1;
                            for (JsonArray row : results) {
                                json.put("row"+i, row.getInteger(0) + "," + row.getInteger(1) + "," + row.getInteger(2) + "," + row.getInteger(3));
                                i++;
                            }
                        } else {
                            System.out.println("-- 5");
                            // Failed!
                        }
                        connection.close();
                        x.response().end(json.toString());
                    });
                } else { System.out.println("-- 6 "+res.cause().getMessage());
                    // Failed to get connection - deal with it
                }
            });
            */
        });

    }



    private void userExist(RoutingContext x, String username, String password){

        SqlQuery.execQuery("SELECT * FROM user WHERE name = ?", new JsonArray().add(username), result -> {
            String token = "";
            Boolean success = false;
            if (result.succeeded()){
                JsonObject json = result.result();
                if(json.getInteger("numRows") == 1){
                    if(json.getJsonArray("rows").getJsonObject(0).getString("password").equals(password)){
                        success = true;
                        token = authProvider.generateToken(new JsonObject().put("username", username), new JWTOptions());
                    }
                }
                //x.response().end(result.result().toString());
            }/* else {
                x.fail(result.cause());
            }*/
            x.response().end("{success:'"+success+"', token:'"+token+"'}");
        });
    }
}

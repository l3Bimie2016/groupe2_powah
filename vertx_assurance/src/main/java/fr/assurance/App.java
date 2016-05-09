package fr.assurance;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.JWTAuthHandler;


/**
 * Created by Max on 04/04/2016.
 */
public class App extends AbstractVerticle {

    public static void main(String[] args){
        Vertx v = Vertx.vertx();
        v.deployVerticle(App.class.getCanonicalName());

    }

    private JWTAuth authProvider;

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
        /*router.route().failureHandler(x -> {
            System.out.println("-- fail !");
        });*/

        router.post("/private/list").consumes("application/json").handler(x -> {
        //router.post("/list").consumes("application/json").handler(x -> { System.out.println("-- /list");

            JsonObject json = x.getBodyAsJson();
            String action = json.getString("action");
            Integer marque = json.getInteger("marque");
            Integer modele = json.getInteger("modele");
            Integer chevaux = json.getInteger("chevaux");
            String sql = "";
            JsonArray params = new JsonArray();
            if(action.equals("modele")) {
                sql = "select distinct id_modele, name from voiture " +
                        "inner join modele m on id_modele = m.id " +
                        "where id_marque = ?";
                params = new JsonArray().add(marque);
            }else if(action.equals("chevaux")) {
                sql = "select distinct id_chevaux_fiscaux, name from voiture " +
                        "inner join chevaux_fiscaux cf on id_chevaux_fiscaux = cf.id " +
                        "where id_marque = ? and id_modele = ?";
                params = new JsonArray().add(marque).add(modele);
            }else if(action.equals("carburant")) {
                sql = "select distinct id_carburant, name from voiture " +
                        "inner join carburant c on id_carburant = c.id " +
                        "where id_marque = ? and id_modele = ? and id_chevaux_fiscaux = ?";
                params = new JsonArray().add(marque).add(modele).add(chevaux);
            }else{
                sql = "select distinct id_marque, name from voiture " +
                        "inner join marque m on id_marque = m.id";
            }
            System.out.println("- pre getList");
            getList(x, sql, params);
        });

    }

    private void getList(RoutingContext x, String sql, JsonArray params){
        SqlQuery.execQuery(sql, params, result -> {
            Boolean success = false;
            JsonArray list = new JsonArray();
            if (result.succeeded()){
                success = true;
                JsonObject json = result.result();
                list = json.getJsonArray("rows");
            }
            x.response().end("{success:'"+success+"', list:"+list.toString()+"}");
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

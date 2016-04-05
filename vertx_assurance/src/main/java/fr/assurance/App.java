package fr.assurance;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.Router;
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

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
<<<<<<< HEAD

        router.route().handler(BodyHandler.create());

=======
        
>>>>>>> d1a2d6dfb165aaa63ffa683ac3f297f81dd53101
        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8090);

        JsonObject config = new JsonObject().put("keyStore", new JsonObject()
                .put("path", "keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));

<<<<<<< HEAD
        JWTAuth authProvider = JWTAuth.create(vertx, config);

        router.route("/private/*").handler(JWTAuthHandler.create(authProvider));

        router.post("/login").consumes("application/json").handler(x -> {
            JsonObject json = x.getBodyAsJson();
            String username = json.getString("username");
            String password = json.getString("password");
=======
        JWTAuth provider = JWTAuth.create(vertx, config);

        router.get("/login").handler(x -> {
>>>>>>> d1a2d6dfb165aaa63ffa683ac3f297f81dd53101
            String token = "";
            Boolean success = false;
            if (username.equals("admin") && password.equals("admin")) {
                success = true;
                token = authProvider.generateToken(new JsonObject().put("username", username), new JWTOptions());
            }

            x.response().end("{success:'"+success+"', token:'"+token+"'}");
        });
    }
}

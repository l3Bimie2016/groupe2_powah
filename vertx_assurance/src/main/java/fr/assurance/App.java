package fr.assurance;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

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

        router.route().handler(BodyHandler.create());

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8090);

        JsonObject config = new JsonObject().put("keyStore", new JsonObject()
                .put("path", "keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));

        JWTAuth provider = JWTAuth.create(vertx, config);

        router.post("/login").consumes("application/json").handler(x -> {
            JsonObject json = x.getBodyAsJson();
            //System.out.println(x.getBodyAsString() == null ? "json est null" : "string : "+x.getBodyAsString());
            String username = json.getString("username");
            String password = json.getString("password");
            String token = "";
            Boolean success = false;
            if (username.equals("admin") && password.equals("admin")) {
                success = true;
                token = provider.generateToken(new JsonObject().put("username", username), new JWTOptions());
            }

            x.response().end("{success:'"+success+"', token:'"+token+"'}");
        });
    }
}

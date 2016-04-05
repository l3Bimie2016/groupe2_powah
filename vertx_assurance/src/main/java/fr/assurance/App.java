package fr.assurance;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.Router;

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
        
        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8090);

        JsonObject config = new JsonObject().put("keyStore", new JsonObject()
                .put("path", "keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));

        JWTAuth provider = JWTAuth.create(vertx, config);

        router.get("/login").handler(x -> {
            String token = "";
            // "paulo".equals(username) && "super_secret".equals(password)
            if (true) {
                token = provider.generateToken(new JsonObject().put("sub", "paulo"), new JWTOptions());
            }
            x.response().end("Hello from vertx : "+token);
        });
    }
}

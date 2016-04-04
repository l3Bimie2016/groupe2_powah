package fr.assurance;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
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
        router.get("/verts/index").handler(x -> {
            x.response().end("Hello from vertx !");
        });

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8090);
    }
}

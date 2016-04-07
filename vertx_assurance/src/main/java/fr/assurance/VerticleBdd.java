package fr.assurance;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

/**
 * Created by Max on 07/04/2016.
 */
public class VerticleBdd extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer("LOGIN_USER",(Message<JsonObject> x) -> loginUser(x));
    }

    private void loginUser(Message<JsonObject> message){
        JsonObject json = message.body();
        String username = json.getString("username");
        String password = json.getString("password");


    }

}

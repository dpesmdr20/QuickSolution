package com.deerwalk.QuickSolution.Server;

import com.deerwalk.QuickSolution.Utils.ConfProvider;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * Created by dimanandhar on 9/4/17.
 */
public class Server extends AbstractVerticle{
    private ConfProvider confProvider;

    @Override
    public void start() {

        confProvider = ConfProvider.getInstance();
        confProvider.setConfig(vertx.getOrCreateContext().config());
        confProvider.setVertx(vertx);
        confProvider.setEventBus(vertx.eventBus());
        Router router = Router.router(vertx);
        router.route("/web-app/*").handler(StaticHandler.create("web-app"));
        router.get("/login/").handler(h->{
            h.response().end("200");
        });
        deployVerticles();
        vertx.createHttpServer().requestHandler(router::accept).listen(confProvider.getConfig().getInteger("port"),confProvider.getConfig().getString("url"));


    }
    private void deployVerticles() {
     //   vertx.deployVerticle("com.dpesmdr20.mypunchin.Verticles.LoginVerticle");
    }
}

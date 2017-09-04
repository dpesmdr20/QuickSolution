package com.deerwalk.QuickSolution.Utils;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

/**
 * Created by dimanandhar on 9/4/17.
 */
public class ConfProvider {
    private JsonObject config;
    private static ConfProvider instance = null;
    private Vertx vertx;
    private EventBus eventBus;


    public static ConfProvider getInstance(){
        if(instance==null)
            instance = new ConfProvider();
        return instance;
    }

    public JsonObject getConfig() {
        return config;
    }

    public void setConfig(JsonObject config) {
        this.config = config;
    }

    public Vertx getVertx() {
        return vertx;
    }

    public void setVertx(Vertx vertx) {
        this.vertx = vertx;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }}

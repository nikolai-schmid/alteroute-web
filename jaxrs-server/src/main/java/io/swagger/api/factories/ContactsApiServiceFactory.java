package io.swagger.api.factories;

import io.swagger.api.GamesApiService;
import io.swagger.api.impl.GamesApiServiceImpl;

public class GamesApiServiceFactory {
    private final static GamesApiService service = new GamesApiServiceImpl();

    public static GamesApiService getContactsApi() {
        return service;
    }
}

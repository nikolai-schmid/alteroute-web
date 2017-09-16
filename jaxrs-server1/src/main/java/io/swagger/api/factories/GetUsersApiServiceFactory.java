package io.swagger.api.factories;

import io.swagger.api.GetUsersApiService;
import io.swagger.api.impl.GetUsersApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T18:18:12.842Z")
public class GetUsersApiServiceFactory {
    private final static GetUsersApiService service = new GetUsersApiServiceImpl();

    public static GetUsersApiService getGetUsersApi() {
        return service;
    }
}

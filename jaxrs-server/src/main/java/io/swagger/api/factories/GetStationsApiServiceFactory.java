package io.swagger.api.factories;

import io.swagger.api.GetStationsApiService;
import io.swagger.api.impl.GetStationsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T20:48:32.436Z")
public class GetStationsApiServiceFactory {
    private final static GetStationsApiService service = new GetStationsApiServiceImpl();

    public static GetStationsApiService getGetStationsApi() {
        return service;
    }
}

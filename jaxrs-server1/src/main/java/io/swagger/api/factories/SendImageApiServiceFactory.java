package io.swagger.api.factories;

import io.swagger.api.SendImageApiService;
import io.swagger.api.impl.SendImageApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T22:36:21.796Z")
public class SendImageApiServiceFactory {
    private final static SendImageApiService service = new SendImageApiServiceImpl();

    public static SendImageApiService getSendImageApi() {
        return service;
    }
}

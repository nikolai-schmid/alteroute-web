package io.swagger.api;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T22:40:51.970Z")
public abstract class SendImageApiService {
    public abstract Response sendImagePost(SecurityContext securityContext) throws NotFoundException;
}

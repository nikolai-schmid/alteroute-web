package io.swagger.api;

import io.swagger.model.User;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T18:18:12.842Z")
public abstract class GetUsersApiService {
    public abstract Response usersGet(SecurityContext securityContext) throws NotFoundException;
}

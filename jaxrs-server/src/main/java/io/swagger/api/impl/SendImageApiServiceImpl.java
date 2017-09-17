package io.swagger.api.impl;

import io.swagger.api.*;


import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T22:36:21.796Z")
public class SendImageApiServiceImpl extends SendImageApiService {
    @Override
    public Response sendImagePost(SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}

package io.swagger.api.impl;

import io.swagger.api.*;

import io.swagger.model.User;

import io.swagger.api.NotFoundException;

import com.google.gson.Gson;

import dao.UserDao;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T18:18:12.842Z")
public class GetUsersApiServiceImpl extends GetUsersApiService {
    @Override
    public Response usersGet(SecurityContext securityContext) throws NotFoundException {
        UserDao ud = new UserDao();
    	
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK,
                new Gson().toJson(ud.readUserItems()).toString().replace("\"",""))).build();
    }
}

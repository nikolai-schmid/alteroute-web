package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.AlterouteDao;
import dao.UserDao;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T18:18:12.842Z")
public class GetUsersApiServiceImpl extends GetUsersApiService {
    @Override
    public Response usersGet(SecurityContext securityContext) throws NotFoundException {
        UserDao ud = new UserDao();
    	
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, new Gson().toJson(ud.readUserItems()))).build();
    }
}

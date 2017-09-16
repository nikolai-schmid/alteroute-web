package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.GetUsersApiService;
import io.swagger.api.factories.GetUsersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/getUsers")


@io.swagger.annotations.Api(description = "the getUsers API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T18:18:12.842Z")
public class GetUsersApi  {
   private final GetUsersApiService delegate;

   public GetUsersApi(@Context ServletConfig servletContext) {
      GetUsersApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("GetUsersApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (GetUsersApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = GetUsersApiServiceFactory.getGetUsersApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = User.class, responseContainer = "List", tags={ "user", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = User.class, responseContainer = "List") })
    public Response usersGet(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.usersGet(securityContext);
    }
}

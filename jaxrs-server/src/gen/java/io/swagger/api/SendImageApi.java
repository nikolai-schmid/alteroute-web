package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SendImageApiService;
import io.swagger.api.factories.SendImageApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.xml.ws.spi.http.HttpContext;

@Path("/sendImage")


@io.swagger.annotations.Api(description = "the sendImage API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T22:40:51.970Z")
public class SendImageApi  {
   private final SendImageApiService delegate;

   public SendImageApi(@Context ServletConfig servletContext) {
      SendImageApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SendImageApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SendImageApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SendImageApiServiceFactory.getSendImageApi();
      }

      this.delegate = delegate;
   }

    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })

    @POST
    public Response sendImagePost(@Context SecurityContext securityContext)
    throws NotFoundException {
        System.out.println("hello");
        return null;
    }
}

package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.GetStationsApiService;
import io.swagger.api.factories.GetStationsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Station;

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

@Path("/getStations")


@io.swagger.annotations.Api(description = "the getStations API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T20:48:32.436Z")
public class GetStationsApi  {
   private final GetStationsApiService delegate;

   public GetStationsApi(@Context ServletConfig servletContext) {
      GetStationsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("GetStationsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (GetStationsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = GetStationsApiServiceFactory.getGetStationsApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Station.class, responseContainer = "List", tags={ "station", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Station.class, responseContainer = "List") })
    public Response stationsGet(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.stationsGet(securityContext);
    }
}

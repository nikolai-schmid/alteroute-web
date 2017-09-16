package dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.google.gson.Gson;
import com.microsoft.azure.documentdb.Database;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.DocumentCollection;

import io.swagger.annotations.ApiParam;
import io.swagger.api.NotFoundException;
import io.swagger.api.factories.ContactsApiServiceFactory;
import io.swagger.model.Contact;
import model.Game;
import model.GameParticipation;

@Path("/contacts")


@io.swagger.annotations.Api(description = "the contacts API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T11:24:35.659Z")
public class GameDao {
	private final GamesApiService delegate;
    
    public ContactsApi(@Context ServletConfig servletContext) {
        ContactsApiService delegate = null;

        if (servletContext != null) {
           String implClass = servletContext.getInitParameter("ContactsApi.implementation");
           if (implClass != null && !"".equals(implClass.trim())) {
              try {
                 delegate = (ContactsApiService) Class.forName(implClass).newInstance();
              } catch (Exception e) {
                 throw new RuntimeException(e);
              }
           } 
        }

        if (delegate == null) {
           delegate = ContactsApiServiceFactory.getContactsApi();
        }

        this.delegate = delegate;
     }
    
    @GET
    @Produces({ "application/json", "text/json" })
    public List<Game> readGameItems() {
        List<Game> games = new ArrayList<Game>();

        List<Document> documentList = documentClient
                .queryDocuments(AlterouteDao.getCollection(COLLECTION_ID_GAME).getSelfLink(),
                        "SELECT * FROM root",
                        null).getQueryIterable().toList();

        for (Document game : documentList) {
            games.add(gson.fromJson(game.toString(),
        			Game.class));
        }
        
        return games;
    }
    
    
    @GET
    @Produces({ "application/json", "text/json" })
    public List<GameParticipation> readGameParticipationItems() {
        List<GameParticipation> gameParticipations = new ArrayList<model.GameParticipation>();

        List<Document> documentList = documentClient
                .queryDocuments(AlterouteDao.getCollection(COLLECTION_ID_GAME).getSelfLink(),
                        "SELECT * FROM root",
                        null).getQueryIterable().toList();

        for (Document game : documentList) {
            gameParticipations.add(gson.fromJson(game.toString(),
        			GameParticipation.class));
        }
        
        return gameParticipations;    	
    }
}

@io.swagger.annotations.Api(description = "the contacts API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T11:24:35.659Z")
public class ContactsApi  {
   private final ContactsApiService delegate;

   public ContactsApi(@Context ServletConfig servletContext) {
      ContactsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ContactsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ContactsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ContactsApiServiceFactory.getContactsApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Contact.class, responseContainer = "List", tags={ "Contact", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Contact.class, responseContainer = "List") })
    public Response contactsGet(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.contactsGet(securityContext);
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Contact.class, responseContainer = "List", tags={ "Contact", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Contact.class, responseContainer = "List") })
    public Response contactsGetById(@ApiParam(value = "",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.contactsGetById(id,securityContext);
    }
}

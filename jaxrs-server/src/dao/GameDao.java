package dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;
import com.microsoft.azure.documentdb.Database;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.DocumentCollection;

import bo.Game;
import bo.GameParticipation;
import io.swagger.api.ContactsApiService;
import io.swagger.api.factories.ContactsApiServiceFactory;

public class GameDao {
	
	 public GameDao(@Context ServletConfig servletContext) {
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
	
	private static Gson gson = new Gson();
	private DocumentClient documentClient = dao.DocumentClientFactory.getDocumentClient();
    private static final String COLLECTION_ID_GAME = "game";
    private static final String CONNECTION_ID_GAME_PARTICIPATION = "game_participation";
    private static DocumentCollection collectionCache;
    
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
    
    public List<GameParticipation> readGameParticipationItems() {
        List<GameParticipation> gameParticipations = new ArrayList<bo.GameParticipation>();

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
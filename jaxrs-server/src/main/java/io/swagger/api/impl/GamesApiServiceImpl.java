package io.swagger.api.impl;

 import io.swagger.api.*;

 import io.swagger.model.Contact;
import model.Game;

import java.util.*;
 import io.swagger.api.NotFoundException;

 import javax.ws.rs.core.Response;
 import javax.ws.rs.core.SecurityContext;

import com.google.gson.Gson;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentCollection;

import dao.AlterouteDao;

 public class GamesApiServiceImpl extends GamesApiService {
		
	private static Gson gson = new Gson();
	private DocumentClient documentClient = dao.DocumentClientFactory.getDocumentClient();
    private static final String COLLECTION_ID_GAME = "game";
    private static final String CONNECTION_ID_GAME_PARTICIPATION = "game_participation";
    private static DocumentCollection collectionCache;
	    
     @Override
     public Response gamesGet(SecurityContext securityContext)
     throws NotFoundException {
         List<Game> games = new ArrayList<Game>();

         List<Document> documentList = documentClient
                 .queryDocuments(AlterouteDao.getCollection(COLLECTION_ID_GAME).getSelfLink(),
                         "SELECT * FROM root",
                         null).getQueryIterable().toList();

         for (Document game : documentList) {
             games.add(gson.fromJson(game.toString(),
         			Game.class));
         }
         
         return Response.ok().entity(games).build();
     }

     @Override
     public Response contactsGetById(Integer id, SecurityContext securityContext)
     throws NotFoundException {
         ArrayList<Contact> list = loadContacts();
         Contact ret = null;

         for(int i=0; i<list.size(); i++)
         {
             if(list.get(i).getId() == id)
                 {
                     ret = list.get(i);
                 }
         }
         return Response.ok().entity(ret).build();
     }
 }
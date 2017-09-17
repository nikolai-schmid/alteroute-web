package dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.DocumentCollection;
import io.swagger.model.Image;
import io.swagger.model.Station;

public class ImageDao {

    private static Gson gson = new Gson();
    private DocumentClient documentClient = DocumentClientFactory.getDocumentClient();
    private static final String COLLECTION_ID = "image";
    private static DocumentCollection collectionCache;

    private DocumentCollection getImageCollection() {
        if (collectionCache == null) {
            List<DocumentCollection> collectionList = documentClient
                    .queryCollections(
                            AlterouteDao.getAlterouteDatabase().getSelfLink(),
                            "SELECT * FROM root r WHERE r.id='" + COLLECTION_ID
                                    + "'", null).getQueryIterable().toList();


            if (collectionList.size() > 0) {
                collectionCache = collectionList.get(0);
            } else {
                try {
                    DocumentCollection collectionDefinition = new DocumentCollection();
                    collectionDefinition.setId(COLLECTION_ID);

                    collectionCache = documentClient.createCollection(
                            AlterouteDao.getAlterouteDatabase().getSelfLink(),
                            collectionDefinition, null).getResource();
                } catch (DocumentClientException e) {
                    e.printStackTrace();
                }
            }
        }

        return collectionCache;
    }

    public List<Image> readImage() {
        List<Image> stations = new ArrayList<Image>();

        List<Document> documentList = documentClient
                .queryDocuments(getImageCollection().getSelfLink(),
                        "SELECT * FROM root",
                        null).getQueryIterable().toList();

        for (Document image : documentList) {
            stations.add(gson.fromJson(image.toString(),
                    Image.class));
        }

        return stations;
    }
}
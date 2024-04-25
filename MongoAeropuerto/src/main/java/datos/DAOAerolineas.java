/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import modelos.Aerolinea;
import org.bson.types.ObjectId;

/**
 *
 * @author abelc
 */
public class DAOAerolineas {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public DAOAerolineas() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("airport");
        collection = database.getCollection("airlines");
    }

    public ArrayList<Aerolinea> obtenerAerolineas() {
        ArrayList<Aerolinea> aerolineas = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document d = cursor.next();
                Aerolinea a = new Aerolinea(d.getObjectId("_id"), d.getString("name"), d.getString("country"), d.getString("currency"), d.getBoolean("lowcost") == null ? false : true);
                aerolineas.add(a);

            }
        } finally {
            cursor.close();
        }
        return aerolineas;
    }

    public void AgregarAerolinea(Aerolinea a) {
        Document aerolinea = new Document("name", a.getNombre())
                .append("country", a.getPais())
                .append("currency", a.getMoneda())
                .append("lowcost", a.isEconomica());
        collection.insertOne(aerolinea);
    }
    
    public void EliminarAerolinea(String id) {
    Document eliminarDocumento = new Document("_id", new ObjectId(id));
    DeleteResult result = collection.deleteOne(eliminarDocumento);

    if (result.getDeletedCount() > 0) {
        System.out.println("Aerolínea eliminada correctamente.");
    } else {
        System.out.println("No se encontró ninguna aerolínea con ese ID.");
    }
}
}

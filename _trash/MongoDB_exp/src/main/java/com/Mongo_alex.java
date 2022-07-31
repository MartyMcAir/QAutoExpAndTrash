package com;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.function.Consumer;

// https://alexkosarev.name/2019/01/30/java-and-mongo-basic-operations/
public class Mongo_alex {
    public static void main(String[] args) {
//        String firstDataBaseName = showDataBasesAndGetLast(); // admin
//        System.out.println(firstDataBaseName);
//        String lastCollectionName = showCollectionsAndGetLast("admin"); // firstCollection
//        System.out.println(lastCollectionName);

        showFromDataBaseCollection("admin", "firstCollection"); // firstDataBaseName
    }

    private static void showFromDataBaseCollection(String dataBaseName, String collectionName) {
        try (var mongoClient = MongoClients.create()) {
            MongoDatabase database = mongoClient.getDatabase(dataBaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            ListIndexesIterable<Document> documents = collection.listIndexes();
            for (Document item : documents) {
                System.out.println(item);
                // Document{{v=2, key=Document{{_id=1}}, name=_id_}}
            }
        }
    }

    private static String showCollectionsAndGetLast(String dataBaseName) {
        String lastCollectionName = "";
        try (var mongoClient = MongoClients.create()) {
            // if dbName, not exist it create new DB
            var database = mongoClient.getDatabase(dataBaseName);
//            database.drop(); // for delete database

            database.listCollectionNames().forEach((Consumer<String>) System.out::println);
            database.listCollections().forEach((Consumer<Document>) System.out::println);
            // Document{{name=todo, type=collection, options=Document{{}},
            //  info=Document{{readOnly=false, uuid=ec6302c9-3b3a-4c61-9bf0-27f54044c193}},
            //  idIndex=Document{{v=2, key=Document{{_id=1}}, name=_id_, ns=newtest.todo}}}}

            System.out.println("----------------");
            MongoIterable<String> collectionsList = database.listCollectionNames();
            for (String item : collectionsList) System.out.println(item);

            MongoCursor<String> iterator = collectionsList.iterator();
            while (iterator.hasNext()) lastCollectionName = iterator.next();
        }
        return lastCollectionName;
    }

    private static String showDataBasesAndGetLast() {
        String firstDataBaseName = "";
        try (MongoClient mongoClient = MongoClients.create()) {
            mongoClient.listDatabases().forEach((Consumer<Document>) System.out::println);
            // Document{{name=test, sizeOnDisk=1.385336832E9, empty=false}}
            mongoClient.listDatabaseNames().forEach((Consumer<String>) System.out::println);

            MongoIterable<String> dataBasesList = mongoClient.listDatabaseNames();
            for (String item : dataBasesList) {
                System.out.println(item);
                firstDataBaseName = item;
            }
        }
        return firstDataBaseName;
    }

}

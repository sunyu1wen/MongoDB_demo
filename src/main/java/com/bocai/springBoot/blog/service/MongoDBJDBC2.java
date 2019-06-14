package com.bocai.springBoot.blog.service;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class MongoDBJDBC2 {
    public static void main(String[] args){
//        MongoClient mongoClient = new MongoClient();
        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        List<ServerAddress> listServer = new ArrayList<ServerAddress>();
        listServer.add(serverAddress);
        MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        MongoClient mongoClient = new MongoClient(listServer,credentials);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
        System.out.println("Connect to database successfully");

    }
}

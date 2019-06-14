package com.bocai.springBoot.blog.service;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class MongoDBJDBC{
    public static void main( String args[] ){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("testDatabases");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("runoob");
            System.out.println("集合 runoob 选择成功");
            Document doc  = new Document("title","MongoDB");
            doc.append("discription","databases");
            doc.append("likes","100");
            doc.append("by","bocai");
            List<Document> lisDoc = new ArrayList<Document>();
            lisDoc.add(doc);
            collection.insertMany(lisDoc);
            System.out.println("=============插入文档成功=========");

            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> cursor = findIterable.iterator();
            while (cursor.hasNext()){
                System.out.println(cursor.next());
            }

//            FindIterable<Document> findIterable =



        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}

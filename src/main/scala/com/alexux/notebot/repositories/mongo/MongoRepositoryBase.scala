package com.alexux.notebot.repositories.mongo

import com.mongodb.casbah.{MongoClient, MongoClientURI}

/**
  * Created by v.bazarevsky on 4/9/2016.
  */
class MongoRepositoryBase(connectionString: String, databaseName: String, collectionName: String){
  protected lazy val mongoUri = MongoClientURI(connectionString)
  protected val collection = MongoClient(mongoUri)(databaseName)(collectionName)
}

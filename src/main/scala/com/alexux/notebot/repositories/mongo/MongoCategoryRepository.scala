package com.alexux.notebot.repositories.mongo

import com.alexux.notebot.model.Category
import com.alexux.notebot.repositories.CategoryRepository
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.Imports._

/**
  * Created by v.bazarevsky on 4/10/2016.
  */
class MongoCategoryRepository(connectionString: String, databaseName: String, collectionName: String)
  extends MongoRepositoryBase(connectionString, databaseName, collectionName) with CategoryRepository {


  override def add(category: Category): Category = {
    val categoryMongo = MongoDBObject(
      "name" -> category.name,
      "description" -> category.description
    )

    collection.insert(categoryMongo)

    category
  }

  override def list(): Seq[Category] = {
    def parse(obj : MongoDBObject) = {
      Category(obj.as[String]("name"), obj.as[String]("description"))
    }

    collection.find().map(parse(_)).toSeq
  }
}

package com.alexux.notebot.repositories.mongo

import com.alexux.notebot.repositories.CategoryRepository

/**
  * Created by v.bazarevsky on 4/10/2016.
  */
class RepositoryContext(connectionString: String, databaseName: String) {
   def categoryRepository: CategoryRepository = new MongoCategoryRepository(connectionString, databaseName, "category")
}

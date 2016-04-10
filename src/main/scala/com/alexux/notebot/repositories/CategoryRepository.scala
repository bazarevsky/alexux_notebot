package com.alexux.notebot.repositories

import com.alexux.notebot.model.Category

/**
  * Created by v.bazarevsky on 4/10/2016.
  */
trait CategoryRepository {
  def add(category: Category) : Category

  def list() : Seq[Category]
}

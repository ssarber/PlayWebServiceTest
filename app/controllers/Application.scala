package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.Stock

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def getStock = Action {
  	val stock = Stock("GOOG", 1000.0)
  	Ok(Json.toJson(stock))
  }

}
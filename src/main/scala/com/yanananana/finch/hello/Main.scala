package com.yanananana.finch.hello

import com.twitter.finagle.Http
import com.twitter.util.Await
import io.finch._

object Main extends App {
  val api: Endpoint[String] = get("hello") { Ok("Hello, World!") }

  Await.ready(Http.server.serve(":8080", api.toServiceAs[Text.Plain]))
}

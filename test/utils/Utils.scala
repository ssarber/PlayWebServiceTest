package utils

trait Utils {
  // def bar = 1
}
object Utils extends Utils {

  @throws(classOf[java.io.IOException])
  @throws(classOf[java.net.SocketTimeoutException])
  def get(url: String,
		  connectTimeout:Int = 5000,
		  readTimeout:Int = 5000,
		  requestMethod: String = "GET") = {
    import java.net.{URL, HttpURLConnection}
    val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
    connection.setConnectTimeout(readTimeout)
    connection.setReadTimeout(readTimeout)
    connection.setRequestMethod(requestMethod)
    val inputStream = connection.getInputStream
    val json = io.Source.fromInputStream(inputStream).mkString
    if (inputStream != null) inputStream.close
    json
  } 
}
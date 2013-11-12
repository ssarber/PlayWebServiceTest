import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

import utils.Utils


@RunWith(classOf[JUnitRunner])
class APISpec extends Specification with Utils {
  
  "Application" should {

    "return correct JSON when API is called" in new WithApplication {
      
      try {
        val json = Utils.get("http://localhost:8084/getStock", 1000, 1000)
        println(f"\n$json%s\n")
        json must be equalTo("{\"symbol\":\"GOOG\",\"price\":1000.0}")
      } catch {
        case ioe: java.io.IOException => println("Ahhh, IOException!")
        case ste: java.net.SocketTimeoutException => println("Ohhh, SocketTimeoutException!")
      }
    }
  }
}

import scala.util.{ Try, Success, Failure }

def getNameOfAirport(iata: String) = {
  val url = s"https://soa.smext.faa.gov/asws/api/airport/status/$iata"
  
  val response = scala.io.Source.fromURL(url).mkString 

  if(!response.contains("Name")) {
    throw new RuntimeException("Invalid airport code " + iata)
  }

  response.split("\"")(3)
  //way too lazy to do the real work to get the data
}

def tryToGetAirportName(iata: String) = Try(getNameOfAirport(iata))

val iataCodes = List("AUS", "IAH", "DFW", "TAS", "SAT")

iataCodes
  .map { tryToGetAirportName }
  .map { _.map { _.toUpperCase } }
  .map { _ match {
      case Success(name) => name
      case Failure(ex) => ex.getMessage
    }
  }
  .foreach(println)

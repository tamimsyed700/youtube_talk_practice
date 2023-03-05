def getNameOfAirport(iata: String) = {
  val url = s"https://soa.smext.faa.gov/asws/api/airport/status/$iata"
  
  val response = scala.io.Source.fromURL(url).mkString 

  if(!response.contains("Name")) {
    throw new RuntimeException("Invalid airport code " + iata)
  }

  response.split("\"")(3)
  //way too lazy to do the real work to get the data
}

val iataCodes = List("AUS", "IAH", "DFW", "SAT")

iataCodes
  .map { getNameOfAirport }
  .map { _.toUpperCase }
  .foreach(println)


val tickers = List("AAPL", "CSCO", "GOOG", "HPQ", "INTC", "MSFT", "ORCL", "XRX")

case class StockPrice(ticker : String, price : Double) {
  def print = println("Top stock is " + ticker + " at price $" + price)
}

def getPrice(ticker : String) = {
  println("getting price for " + ticker)
  val url = "http://ichart.finance.yahoo.com/table.csv?s=" + ticker  
  val data = io.Source.fromURL(url).mkString
  val price = data.split("\n")(1).split(",")(4).toDouble
  println("got price for " + ticker)
  StockPrice(ticker, price)
}

def isLessThan500(sp: StockPrice) = sp.price < 500

def pickHigh(sp1 : StockPrice, sp2: StockPrice) =
  if(sp1.price < sp2.price) sp2 else sp2

println("The traditional approach")
var tickersAndPrices : List[StockPrice] = List()
for(ticker <- tickers) {
  tickersAndPrices = getPrice(ticker) :: tickersAndPrices
}

var tickersAndPricesLessThan500 : List[StockPrice] = List()
for(sp <- tickersAndPrices) {
  if (isLessThan500(sp))
    tickersAndPricesLessThan500 = sp :: tickersAndPricesLessThan500
}

var highPricedLessThan500 = StockPrice("", 0.0)
for(sp <- tickersAndPricesLessThan500) {
  highPricedLessThan500 = pickHigh(highPricedLessThan500, sp)
}

println(highPricedLessThan500)

println("Function composition")
tickers map getPrice filter isLessThan500 reduce pickHigh print

println("Making it concurrent")
tickers.par map getPrice filter isLessThan500 reduce pickHigh print
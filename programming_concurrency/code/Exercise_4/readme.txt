Given a list of stocks (simply use this list in your code so you don't have to
read a file), write a program that does the following:

1. Sequentially goes out to Yahoo to get prices and computes the stock ticker
with highest and lower price. Display the result of high and low tickers and
their price along with time it takes to perform this action.

2. Using actors to make this concurrent. Hint, your executor service can send 
out request to yahoo and when result arrives can sendOneWay that information
to your actor. Your actor will wait to receive all the response and then print
the final result (and the time taken).

long start = System.nanoTime();
...
long end = System.nanoTime();

System.out.println("Time taken: " + (end - start)/1.0e9);


List<String> tickers = Arrays.asList("AAPL", "AMGN", "AMZN", "BAC", "BMY", 
"CAT", "C", "CMCSA", "CSCO", "CVX", "DELL", "DIS", "DOW", "EMC", "FDX", "GD", 
"GE", "GOOG", "HAL", "HNZ", "HPQ", "IBM", "INTC", "JPM", "KFT", "LMT", "MET", 
"MO", "MSFT", "NKE", "NSC", "ORCL", "PFE", "RTN", "S", "SO","TXN", "USB", 
"VZ", "WMT");

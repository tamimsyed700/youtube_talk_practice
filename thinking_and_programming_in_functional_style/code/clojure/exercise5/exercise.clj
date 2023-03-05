;Using memoization, compute the Fibonacci number where Fib(n) = Fib(n-1) + Fib(n-1), and Fib(0) = 0, and Fib(1) = 1.
;Measure the time for non-memoized recursive version and the memoized version.

(defn fib [n]
  (if (< n 2) n (+ (fib (- n 1)) (fib (- n 2)))))

(time (println (fib 40)))

(def fibMemoized
  (memoize (fn [n]
    (if (< n 2) n (+ (fibMemoized (- n 1)) (fibMemoized (- n 2)))))))

(time (println (fibMemoized 40)))

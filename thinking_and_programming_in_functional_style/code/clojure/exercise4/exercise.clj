;Given a number, determine the factorial of that number using tail recursion

(defn factorial [number]
  (defn factorial-impl [fact num]
    (if (== num 1)
      fact
      (recur (* fact num) (- num 1))))
  
  (factorial-impl 1 number))
  
(println (factorial 5))
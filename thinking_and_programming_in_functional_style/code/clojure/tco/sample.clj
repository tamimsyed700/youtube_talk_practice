(defn f1 [n]
  (if (= n 100000)
    n
    (f1 (+ n 1))))

(try
  (println (f1 1))
  (catch StackOverflowError ex (println ex)))    


(defn f2 [n]
  (if (= n 100000)
    n
    (recur (+ n 1))))
    
(println (f2 1))

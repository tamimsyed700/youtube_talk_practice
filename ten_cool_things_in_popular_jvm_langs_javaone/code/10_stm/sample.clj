(defn increment[balance]  
  (dosync 
    (. Thread sleep 100)
    (println 'incrementing)
    (ref-set balance (+ @balance 1))))
  
(def balance (ref 0))
(.start (Thread. (fn[] (increment balance))))
(.start (Thread. (fn[] (increment balance))))
(. Thread sleep 1000)
(println @balance)
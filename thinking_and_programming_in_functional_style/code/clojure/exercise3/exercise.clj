;Given a number, determine if the number is a perfect number or not. 
;A perfect number is a number for which the sum of its factors equals
;twice the number. For example, factors of 6 are 1, 2, 3, and 6, total
;of which is 12, which is equal to 6 * 2. 
;The number 7 is not perfect since 1 + 7 == 8 != 14.

(defn is-perfect [number]
  (= (reduce + (filter #(= 0 (mod number %)) (range 1 (+ number 1)))) (* number 2)))

(println "6 is perfect?:" (is-perfect 6))
(println "7 is perfect?:" (is-perfect 7))
(println "28 is perfect?:" (is-perfect 28))
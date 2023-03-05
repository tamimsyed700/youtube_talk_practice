;Given a list of names, find the total number of characters. For example, given “John”, “Jack”, “Jill”, “Sam”, “William”, the result should be 22.

(def names (list "John" "Jack" "Jill" "Sam" "William"))

(println (reduce + (map count names)))

;or

(println (count (apply str names)))

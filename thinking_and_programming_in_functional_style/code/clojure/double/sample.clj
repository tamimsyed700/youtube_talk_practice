(def numbers (list 1 2 3 4 5 6))

;imperative style
;hard to do this, but you can with ref and dosync
;better to avoid this style

;functional style
(println (map #(* % 2) numbers))
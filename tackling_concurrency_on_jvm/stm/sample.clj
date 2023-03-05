(def friends1 (ref ()))
(def friends2 (ref ()))

(defn method1 [] 
  (dosync 
    (println "staring method1*****")
    (alter friends1 conj "Stu")
    (println (str "in method1" @friends1 @friends2 "~~~~~~"))
    (. Thread sleep 1000)
    (alter friends2 conj "Bob")
    (println (str "in method1" @friends1 @friends2 "~~~~~~"))
    )
)

(defn method2 [] 
  (dosync 
    (println "staring method2*****")
    (alter friends2 conj "Sara")
    (println (str "in method2" @friends1 @friends2 "~~~~~~"))
    (. Thread sleep 1000)
    (alter friends1 conj "Nancy")
    (println (str "in method2" @friends1 @friends2 "~~~~~~"))
    )
)

(.start (Thread. (fn[] (method1))))
(.start (Thread. (fn[] (method2))))

(. Thread sleep 3000)
(println @friends1)
(println @friends2)
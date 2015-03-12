;Different values in Clojure

;simple number
(println 42)        

;vector -> like an array
(println [1 2 3])   

;s-expression being evaluated
(println (+ 1 2 3 4 5 6))

;putting together two 'arrays'
(println (concat [1 2] [3 4]))


;Starting at page 25
(println "===== Page 25 =====")
(println "
         This is a text block
         spanning multiple
         lines. No prob.
         ")

(println "===== About name binding =====")
(def array ["hello" "," "world" "," 1 "," 2 "," 3])
(println array)

(println "===== Page 27: Macros =====")
(println (str ["hello" "world" 1 2 3]))
(println (str "hello" "world" 1 2 3))
(println (str array))
(println (apply str array))

;Ture or false
(println (true? ""))
(println (true? true))
(println (true? false))
(println (true? nil))

;if else expressions
(println
  (if (> (count array) 2 )
    "array has more than two things"
    "array has more than two things"))

;Maps
(def inventor {"Lisp" "John", "Clojure" "Rich"})
(println inventor)
(println "Lisp is invented by " (inventor "Lisp"))
(println "C++ is invented by " 
  (if (nil? (inventor "C++")) "NO ONE" (inventor "C++")))
(println "C++ is invented by " (get inventor "C++" "NO ONE"))

;Keywords
;:<keyword-name>
(println :hello :world)

(def inventor {:lisp "John" :clojure "Rich"})
(println "Clojure is invented by " (inventor :clojure))
(println "Clojure is invented by " (:clojure inventor))

;when to use :clojure as a function to feth value from map
(defn build-big-map []
  {:clojure [1 2 3]
   :c++     [\d \e \f]})

(println (apply str ((build-big-map) :c++)))
(println (apply str (:c++ (build-big-map))))

(println "===== Page 33 =====")
(defn add [ a b]
  (+ a b))

(println "10 + 20 = " (add 10 20))

(defn repeat-n-times [n f a b]
  (dotimes [i n]
    (println "Iteration:" i " -- " (f a b))))

(repeat-n-times 4 add 100 200)

(repeat-n-times 5 (fn [a b] (* a b)) 2 4)


(repeat-n-times 5 #(- %1 %2) 200 300)


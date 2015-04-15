(ns main)

;Use this to generate random strings
(def alphanumeric "abcdefghijklmnopqrstuvwxyz1234567890")
(defn get-random-string [length]
  (apply str (repeatedly length #(rand-nth alphanumeric))))
  
;Use this to convert string->int
(defn parse-int [s]
  (Integer. (re-find #"\d+" s)))

;BUBBLE SORT
(defn bubble [in]
  (if (or (nil? in) (nil? (second in)))
    in
    (if (> (first in) (second in))
      (cons (second in) (cons (first in) (nthrest in 2)))
      (cons (first in) (bubble (rest in))))))

(defn bubble-sort [in]
  (if (= (bubble in) in)
    in
    (recur (bubble in))))

;MERGE SORT
(comment (defn merger
  ([left right]
   (merger (list left right)))
  ([left right]
   (loop [l left, r right, result[]]
     (let [lhead (first l), rhead (first r)]
       (cond
         (nil? lhead) (concat result r)
         (nil? rhead) (concat result l)
         (<= lhead rhead) (recur (rest l) r (conj result lhead))
         true (recur l (rest r) (conj result rhead)))))))

(defn mergesort [xs]
  ((fn mergesort-counted [xs n]
     (if (<= n 1)
       xs
       (let [middle (bit-shift-right n 1)]
         (merger (map mergesort-counted
                      (split-at middle xs)
                      [middle (- n middle)])))))
  xs (count xs)))
)
;QUICK SORT
(defn quick-sort [in]
  (if (empty? in)
    '()
    (let [pvt (first in)
          smaller (filter #(< % pvt) (rest in))
          larger (filter #(>= % pvt) (rest in))]
      (concat (quick-sort smaller) pvt (quick-sort larger)))))

;Get user input
(println "What kind of sort? [bubble/merge/quick] ")
(def sortType (read-line))
(println "Variable type? [int/string/float] ")
(def valType (read-line))
(println "How Many? ")
(def size (parse-int (read-line)))

;Make the necesarry list
(case valType
  "int" (def randList (repeatedly size #(rand-int 100)))
  "string" (def randList (repeatedly size #(get-random-string 10)))
  "float" (def randList (repeatedly size #(rand 100)))
  "default")

(println "Before Sorting:")
(println randList)
(println "After Sorting:")

;Call the correct sort method now
(case sortType
  "bubble" (time (bubble-sort randList))
  "merge" (time (merge-sort randList ))
  "quick" (time (quick-sort randList))
  "default")

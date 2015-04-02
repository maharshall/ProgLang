(ns main)

;Use this to generate random strings
(def alphanumeric "abcdefghijklmnopqrstuvwxyz1234567890")
(defn get-random-string [length]
  (apply str (repeatedly length #(rand-nth alphanumeric))))
  
;Use this to convert string->int
(defn parse-int [s]
  (Integer. (re-find #"\d+" s)))

;=====BUBBLE SORT=====
(defn bubble-sort [xs]
  (letfn [(bubble [acc x]
                  (if (seq acc)
                    (if (> 0 (compare x (peek acc)))
                      (conj (pop acc) x (peek acc))
                      (conj acc x))
                    [x]))]
         (loop [xs xs]
           (let [bubbled (reduce bubble [] xs)]
             (if (= xs bubbled)
               bubbled
               (recur bubbled))))))

;=====QUICK SORT=====
(defn quick-sort [[pvt & xs]]
  (when pvt
    (let [smaller #(< % pvt)]
      (lazy-cat (quick-sort (filter smaller xs))
                [pvt]
                (quick-sort (remove smaller xs))))))

;=====MERGE SORT=====
(defn merge* [left right]
  (cond (nil? left) right
        (nil? right) left
        true (let [[l & *left] left
                   [r & *right] right]
               (if (<= l r) (cons l (merge* *left right))
                            (cons r (merge* left *right))))))

(defn merge-sort [xs]
  (let [[x & *xs] xs]
    (if (nil? *xs)
      xs
      (let [[left right] (split-at (/ (count xs) 2) xs)]
        (merge* (merge-sort left) (merge-sort right))))))



;Get user input
(println "What kind of sort? [bubble/merge/quick] ")
(def sortType (read-line))
;(println "Ascending or Descending? ")
;(def updown (read-line))
(println "Variable type? [int/string/float] ")
(def valType (read-line))
(println "How Many? ")
(def size (parse-int (read-line)))

;Make the necesarry list
(case valType
  "int" (def randList (repeatedly size #(rand-int 100)))
  "string" (def randList (repeatedly size #(get-random-string 10)))
  "float" (def randList (repeatedly size #(rand 100)))
  "You dun goof'd.")

;Boolean for sort direction
;(case updown
;  "ascending" (def ascending true)
;  "descending" (def ascending false)
;  "You think this is a game?")

(println "Before Sorting:")
(println randList)

;Call the correct sort method now
(case sortType
  "bubble" (time (println (bubble-sort randList)))
  "merge" (time (println (merge-sort randList)))
  "quick" (time (println (quick-sort randList)))
  "I'm not here to fuck spiders, mate")

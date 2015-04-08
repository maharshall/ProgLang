(ns main)
(require '[bubblesort.sort :as bub])
(require '[mergesort.sort :as merg])
(require '[quicksort.sort :as qck])

;Use this to generate random strings
(def alphanumeric "abcdefghijklmnopqrstuvwxyz1234567890")
(defn get-random-string [length]
  (apply str (repeatedly length #(rand-nth alphanumeric))))
  
;Use this to convert string->int
(defn parse-int [s]
  (Integer. (re-find #"\d+" s)))

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
  "bubble" (time (println (bub/bubble-sort randList)))
  "merge" (time (println (merg/merge-sort randList)))
  "quick" (time (println (qck/quick-sort randList)))
  "ECH")

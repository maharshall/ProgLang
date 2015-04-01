(ns main)

;Use this to generate random strings
(def alphanumeric "abcdefghijklmnopqrstuvwxyz1234567890")
(defn get-random-string [length]
  (apply str (repeatedly length #(rand-nth alphanumeric))))
  
;Use this to convert string->int
(defn parse-int [s]
  (Integer. (re-find #"\d+" s)))

(defn bubble [input]
  (if (or (nil? input) (nil? (second input)))
    (if (> (first input) (second input))
      (cons (second input) (cons (first input) (nthrest input 2)))
      (lazy-cons (first input) (bubble (rest input))))))

(defn bsort [input]
  (if (= (bubble input) input)
    input
    (recur (bubble input))))


;Get user input
(println "What kind of sort? [bubble/merge/quick] ")
(def sortType (read-line))
(println "Ascending or Descending? ")
(def updown (read-line))
(println "Variable type? [int/string/float] ")
(def valType (read-line))
(println "How Many? ")
(def size (parse-int (read-line)))

;Make the necesarry list
(case valType
  "int" (def intList (repeatedly size #(rand-int 100)))
  "string" (def strList (repeatedly size #(get-random-string 10)))
  "float" (def fltList (repeatedly size #(rand 100)))
  "You dun goof'd.")

;Boolean for sort direction
(case updown
  "ascending" (def ascending true)
  "descending" (def ascending false)
  "You think this is a game?")

;Call the sort methods now I guess?
(bsort intList)

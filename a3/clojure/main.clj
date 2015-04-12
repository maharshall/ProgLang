(ns main)
;(require '[bubblesort.sort])
;(require '[mergesort.sort])
;(require '[quicksort.sort])

;Use this to generate random strings
(def alphanumeric "abcdefghijklmnopqrstuvwxyz1234567890")
(defn get-random-string [length]
  (apply str (repeatedly length #(rand-nth alphanumeric))))
  
;Use this to convert string->int
(defn parse-int [s]
  (Integer. (re-find #"\d+" s)))

;BUBBLE SORT
(defn bubble-sort [in]
  (def f1 1) (def f2 1) (def i 0)
  (while (= f1 f2) (do
    (def f2 0)
    (if (> (nth in i) (nth in (inc i)))
      ((assoc in (inc i) (nth in i) i (nth in (inc i)))
      (def f2 1)
      (println "f1->" f1 " f2->" f2 " i->" i)))
    (if (= (inc i) (count in)) (def i 0) (def i (inc i))))))

;MERGE SORT
(defn merger [in low middle high]
  (def x low)
  (def holder [])
  (while (<= x high) (do
    (assoc holder x (nth in x))))

  (def i low) (def j (inc middle)) (def k low)

  (while (and (<= i middle) (<= j high)) (do
    (if (< (nth holder i) (nth holder j))
      ((assoc in k (nth holder i))
        (def i (inc i))
        (def k (inc k)))
      ((assoc in k (nth holder j))
       (def j (inc j))
       (def k (inc k))))))

  (while (<= i middle) (do
    (assoc in k (nth holder i))
    (def k (inc k))
    (def i (inc i)))))

(defn merge-sort [in low high]
  (if (< low high)
    ((def middle (+ low (/ (- high low) 2)))
    (merge-sort in low middle)
    (merge-sort in (inc middle) high)
    (merger in low middle high))))


;QUICK SORT
(defn quick-sort [in start end]
  (if (< start end)
    ((def pivot (nth in end))
    (def i start) (def j end)

    (while (not= i j) (do
      (if (< (nth in i) pivot)
        (def i (inc i))
        ((assoc in j (nth in i))
        (assoc in i (nth in (dec j)))
        (def j (dec j))))))
  
      (assoc in j pivot)
      (quick-sort in start (dec j))
      (quick-sort in (inc j) end))))

;Get user input
(println "What kind of sort? [bubble/merge/quick] ")
(def sortType (read-line))
(println "Variable type? [int/string/float] ")
(def valType (read-line))
(println "How Many? ")
(def size (parse-int (read-line)))

;Make the necesarry list
(case valType
  "int" (def randList (vector (repeatedly size #(rand-int 100))))
  "string" (def randList (repeatedly size #(get-random-string 10)))
  "float" (def randList (repeatedly size #(rand 100)))
  "STREETS 112 TIL THE DAY I FUCKING DIE")

(println "Before Sorting:")
(println randList)

;Call the correct sort method now
(case sortType
  "bubble" (time (bubble-sort randList))
  "merge" (time (merge-sort randList 0 (dec size)))
  "quick" (time (quick-sort randList 0 (dec size)))
  "I'VE NEVER SEEN A 113 AND I NEVER FUCKING WILL")

(println "After Sorting:")
(println randList)

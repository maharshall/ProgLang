(ns bubblesort)

(defn bubble [input]
  (if (or (nil? input) (nil? (second input)))
    (if (> (first input) (second input))
      (cons (second input) (cons (first input) (nthrest input 2)))
      (lazy-cons (first input) (bubble (rest input))))))

(defn bsort [input]
  (if (= (bubble input) input)
    input
    (recur (bubble input))))

(ns bubblesort)

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

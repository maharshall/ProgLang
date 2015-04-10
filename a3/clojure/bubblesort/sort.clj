(ns bubblesort.sort)

(defn bubble-sort [in]
  (letfn [(bubble [acc x]
                  (if (seq acc)
                    (if (> 0 (compare x (peek acc)))
                      (conj (pop acc) x (peek acc))
                      (conj acc x))
                    [x]))]
         (loop [in in]
           (let [bubbled (reduce bubble [] in)]
             (if (= in bubbled)
               bubbled
               (recur bubbled))))))

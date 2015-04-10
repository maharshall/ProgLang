(ns quicksort.sort)

(defn quick-sort [[pivot & in]]
  (when pivot
    (let [smaller #(< % pivot)]
      (lazy-cat (quick-sort (filter smaller in))
                [pivot]
                (quick-sort (remove smaller in))))))

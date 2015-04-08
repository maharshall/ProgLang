(ns quicksort)

(defn quick-sort [[pvt & xs]]
  (when pvt
    (let [smaller #(< % pvt)]
      (lazy-cat (quick-sort (filter smaller xs))
                [pvt]
                (quick-sort (remove smaller xs))))))

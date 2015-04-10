(ns mergesort.sort)

(defn merge* [left right]
  (cond (nil? left) right
        (nil? right) left
        true (let [[l & *left] left
                   [r & *right] right]
               (if (<= l r) (cons l (merge* *left right))
                            (cons r (merge* left *right))))))

(defn merge-sort [in]
  (let [[i & *in] in]
    (if (nil? *in)
      in
      (let [[left right] (split-at (/ (count in) 2) in)]
        (merge* (merge-sort left) (merge-sort right))))))

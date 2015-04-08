(ns mergesort)

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

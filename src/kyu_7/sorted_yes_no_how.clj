(ns kyu-7.sorted-yes-no-how)

(defn sorted-and-how? [sq]
  (cond
    (= sq (sort > (set sq))) "yes, descending"
    (= sq (sort (set sq))) "yes, ascending"
    :else "no"))
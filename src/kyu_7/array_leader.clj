(ns kyu-7.array-leader)

(def numbers [1 2 3 4 0])

(defn array-leaders [numbers]
  (loop [n numbers
         r []]
    (cond (nil? (seq n)) r
          (> (first n) (apply + (rest n))) (recur (rest n) (conj r (first n)))
          :else (recur (rest n) r))))
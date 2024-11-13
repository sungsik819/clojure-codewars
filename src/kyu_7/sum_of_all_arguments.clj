(ns kyu-7.sum-of-all-arguments)

(defn sum [& xs]
  (apply + xs))

(sum 8 2)
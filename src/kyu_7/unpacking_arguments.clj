(ns kyu-7.unpacking-arguments)

(defn spread
  [func, args]
  (apply func args))
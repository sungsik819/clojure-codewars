(ns kyu-7.first-class-function-factory)

(defn factory [x]
  (fn [coll] (map (partial * x) coll)))

(let [fives (factory 5)]
  (fives [1 2 3]))
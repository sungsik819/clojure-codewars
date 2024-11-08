(ns kyu-7.last
  (:refer-clojure :exclude [last]))

(def lst [1 2 3 4])
(defn last [lst]
  (first (reverse lst)))

(last [1 2 3 4])
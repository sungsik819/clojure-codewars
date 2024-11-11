(ns kyu-8.beginner-series-2-clock)

(def h 1)
(def m 1)
(def s 1)

(defn past [h m s]
  (+ (* h 3600000) (* m 60000) (* s 1000)))
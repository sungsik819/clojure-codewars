(ns kyu-7.l2-triple-x)

(def s "abraxxxas")

(defn triple-x? [s]
  (<= 3 (count (first (re-seq #"x+" s)))))

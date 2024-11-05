(ns kyu-7.testing-1-2-3)

(defn number [lines]
  (map #(str %1 ": " %2) (iterate inc 1) lines))
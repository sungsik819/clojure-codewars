(ns kyu-7.average-scores)

(def data [5 3 3 5])

(defn average [data]
  (quot (apply + data) (count data)))
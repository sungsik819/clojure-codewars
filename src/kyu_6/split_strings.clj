(ns kyu-6.split-strings)

(defn solution
  [s]
  (map #(apply str %) (partition 2 2 ["_"] (map str s))))
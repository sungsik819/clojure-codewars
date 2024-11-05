(ns kyu-6.persistent-bugger)

(defn persistence [n]
  (loop [n n multi 0]
    (let [coll (flatten (partition 1 1 (str n)))]
      (if (= (count coll) 1) multi
          (recur (apply * (map #(Character/getNumericValue %) coll)) (inc multi))))))
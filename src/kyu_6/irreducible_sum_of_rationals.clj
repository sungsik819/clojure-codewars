(ns kyu-6.irreducible-sum-of-rationals)

(def l [])

(defn sum_fracts [l]
  (if (empty? l) (seq l)
      (let [sum-of-rationals (apply + (map (fn [[n d]] (/ n d)) l))]
        (if (ratio? sum-of-rationals)
          [(numerator sum-of-rationals)
           (denominator sum-of-rationals)]
          sum-of-rationals))))
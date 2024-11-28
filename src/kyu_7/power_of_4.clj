(ns kyu-7.power-of-4)

(def x 16)

(defn isPowerOf4? [x]
  (loop [value 4
         i 2]
    (cond (= x 1) true
          (> value x) false
          (= value x) true
          :else (recur (apply * (repeat i 4)) (inc i)))))


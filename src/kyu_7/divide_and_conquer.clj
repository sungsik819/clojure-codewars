(ns kyu-7.divide-and-conquer)

(def x ["5" "0" 9 3 2 1 "9" 6 7])


(defn div-con [x]
  (- (apply + (filter integer? x))
     (apply + (map #(Integer/valueOf %) (filter string? x)))))
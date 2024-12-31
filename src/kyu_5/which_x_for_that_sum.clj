(ns kyu-5.which-x-for-that-sum)

(def m 4.00)

(defn solve [m]
  (/ (/ (- (+ (* 2 m) 1) (Math/sqrt (+ (* 4 m) 1))) 2) m))
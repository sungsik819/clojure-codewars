(ns kyu-7.basic-sequence-practice)

(defn sum-of-n [n]
  (if (neg? n) (reductions + (take (inc (Math/abs n)) (iterate dec 0)))
      (reductions + (take (inc (Math/abs n)) (iterate inc 0)))))

(ns kyu-7.recursion-101)

(def a 8796203)
(def b 7556)

(defn solve
  [a b]
  (loop [a a
         b b]
    (cond (or (= a 0) (= b 0)) [a b]
          (>= a (* 2 b)) (recur (- a (* 2 b)) b)
          (>= b (* 2 a)) (recur a (- b (* 2 a)))
          :else [a b])))
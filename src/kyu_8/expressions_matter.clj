(ns kyu-8.expressions-matter)

(def a 3)
(def b 5)
(def c 7)

(defn expression-matter [a b c]
  (apply max [(* a (+ b c)) (* a b c) (+ a (* b c)) (* c (+ a b)) (+ a b c)]))
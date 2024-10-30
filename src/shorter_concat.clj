(ns shorter-concat)

(def a "first")
(def b "abcde")

(defn reverseLonger [a b]
  (if (>= (count a) (count b))
    (str b (apply str (reverse a)) b)
    (str a (apply str (reverse b)) a)))
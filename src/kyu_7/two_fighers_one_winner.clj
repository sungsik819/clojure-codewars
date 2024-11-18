(ns kyu-7.two-fighers-one-winner)

(defrecord Fighter [name hp attack])

(def f1 (->Fighter "Harald" 20 5))
(def f2 (->Fighter "Jerry" 30 3))

(defn declare-winner [f1 f2]
  (loop [f1-hp (- (:hp f1) (:attack f2))
         f2-hp (- (:hp f2) (:attack f1))]
    (cond (<= f1-hp 0) (:name f2)
          (<= f2-hp 0) (:name f1)
          :else (recur (- f1-hp (:attack f2))
                       (- f2-hp (:attack f1))))))
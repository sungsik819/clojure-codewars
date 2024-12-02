(ns kyu-7.arithmetic-sequence)

(def fi -50)
(def n 10)
(def c 20)

(defn nth-term
  [fi n c]
  (let [v (if (< 0 c) java.lang.Integer/MAX_VALUE
              10)]
    (last (take (inc n) (range fi v c)))))

;; 다른 사람 풀이법
(defn nth-term1
  [n0 idx c]
  (+ n0 (* c idx)))
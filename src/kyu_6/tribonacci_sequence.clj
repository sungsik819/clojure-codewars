(ns kyu-6.tribonacci-sequence)

;; Tribonacci Sequence
(defn tribonacci [[a b c] n]
  (loop [l 3 r [1 1 1]]
    (cond
      (= l n) r
      (= n 0) []
      (= n 1) [a]
      (= n 2) [a b]
      (= n 3) [a b c]
      :else (recur (inc l) (conj r (apply + (take-last 3 r)))))))

(tribonacci [1 1 1] 0)

;; 다른 풀이
(defn trib [a b c]
  (lazy-seq
   (cons a (trib b c (+ a b c)))))

(take 10 (trib 1 1 1))
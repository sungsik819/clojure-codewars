(ns sum-of-first-term)

;; 처음 생각한 풀이법
(defn terms [v i]
  (lazy-seq
   (cons v (terms (/ 1 (+ 1 (* 3 i))) (inc i)))))

(defn round2 [v]
  (double (/ (Math/round (* v 100)) 100)))

(round2 (double (apply + (take 5 (terms 1 1)))))

;; 두번째 구현한 풀이법
(def n 5)
(defn terms2 []
  (loop [i 0 r 0.00]
    (if (= i n) r
        (recur (inc i) (+ r (/ 1 (+ 1 (* 3 i))))))))

(format "%.2f" (terms2))


;; 다른 사람의 풀이법
(defn series-sum [n]
  (->> (range n)
       (map #(/ (+ (* % 3) 1)))
       (reduce + 0.0)
       (format "%.2f")))

;; 분자가 없이 하나만 넣을 경우 자동으로 분자가 1이 됨
(/ 2)
(ns kyu-7.max-min-array)

(def numbers [91,75,86,14,82])

(sort > numbers)

;; 큰수, 작은수로 순서를 바꾸기
(defn solve [numbers]
  (loop [i 0
         c (sort > numbers)
         r []]
    (cond (= i (count numbers)) r
          (zero? (rem i 2)) (recur (inc i) (rest c) (conj r (first c)))
          :else (recur (inc i)
                       (butlast c)
                       (conj r (last c))))))


;; 다른 사람 풀이법
;; sort 및 역순을 두어, interleave 한다.
(defn solve1 [xs]
  (let [xs (vec (sort xs))]
    (take (count xs) (interleave (rseq xs) xs))))
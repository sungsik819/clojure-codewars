(ns kyu-7.sum-of-squares-less-than-some-number)

(def n 1)

(defn get-number-of-square [n]
  (let [ran (map #(* % %) (range 1 n))]
    (if (not (seq ran)) 0
        (->> ran
             (reductions +)
             (filter #(< % n))
             (count)))))

;; 다른 사람 풀이
;; iterate의 범위를 지정하지 않음
;; 마지막에 take-while을 사용하여 값을 필터링함
(defn get-number-of-squares1 [n]
  (->> (iterate inc 1) (map #(* % %)) (reductions +) (take-while #(< % n)) count))

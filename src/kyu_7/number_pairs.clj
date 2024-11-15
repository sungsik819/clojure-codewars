(ns kyu-7.number-pairs)

(def a [13 64 15 17 88])
(def b [23 14 53 17 80])

(defn get-larger-numbers [a b]
  (vec (map (fn [x y]
              (if (>= x y) x y)) a b)))

;; 다른 사람 풀이
;; mapv는 최종 coll을 vector로 해주는 함수
;; 결과적으로 max로 하면 문제는 풀린다.
(defn get-larger-numbers1 [a b]
  (mapv max a b))


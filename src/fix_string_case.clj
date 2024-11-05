(ns fix-string-case
  (:require [clojure.string :as string]))

;; upper가 더 많으면 전체를 upper로
;; lower가 많거나 같으면 lower로 바꾸는 문제
(def s "CODe")

(defn solve [s]
  (let [upper-count (count (re-seq #"[A-Z]" s))
        lower-count (count (re-seq #"[a-z]" s))]
    (if (>= lower-count upper-count) (string/lower-case s)
        (string/upper-case s))))


;; 다른 사람 풀이
;; upper만 filter하면 그 외에는 lower이므로 전체에서 upper를 빼고,
;; 분기 처리 한다.
(defn solve2 [s]
  (let [u (count (filter #(Character/isUpperCase %) s))
        l (- (count s) u)]
    (if (> u l) (clojure.string/upper-case s)
        (clojure.string/lower-case s))))
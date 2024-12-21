(ns kyu-7.double-trouble)

(def xs [2 2 2 2 2 2])
(def t 4)

;; xs에서 t의 합이 있을 경우 두번째 항목을 제거
(defn trouble [xs t]
  (reduce (fn [acc x]
            (if (= t (+ (last acc) x)) acc
                (conj acc x))) [(first xs)] (rest xs)))

;; 다른 사람 풀이법
;; 파라미터를 구조분해 하여 비슷하게 풀이 됨
(defn trouble1 [[x & xs] t]
  (reduce (fn [acc n]
            (if (= t (+ n (peek acc)))
              acc
              (conj acc n)))
          [x]
          xs))
(ns no-zeros-for-heros)

;; 0을 제거 하되 중간의 0을 포함한 숫자를 필터링 한다.

;; 최종
(defn no-boring-zeros [n]
  (if (zero? n) 0
      (Integer/parseInt (first (re-seq #"\-?[1-9]+0*[1-9]+" (str n))))))

(no-boring-zeros 0)

;; 다른 사람 풀이
(defn no-boring-zeros2 [n]
  (cond
    (zero? n) n
    (zero? (rem n 10)) (recur (/ n 10))
    :else n))
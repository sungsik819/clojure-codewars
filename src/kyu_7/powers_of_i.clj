(ns kyu-7.powers-of-i)

(def n 3)

;; 복소수의 power 값을 구하는 문제
;; 단순히 4를 나눈 나머지를 전달하면 된다.
(defn pofi [n]
  (let [i (rem n 4)]
    (cond (= i 0) "1"
          (= i 1) "i"
          (= i 2) "-1"
          (= i 3) "-i")))


;; 다른 사람 풀이법
;; 나머지 값을 인덱스로 사용하여 풀이
(defn pofi1 [n]
  (nth ["1" "i" "-1" "-i"] (mod n 4)))
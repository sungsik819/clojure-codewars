(ns kyu-7.count-the-digit
  (:require [clojure.string :as string]))

;; count the digit
;; Timeout 발생하여 최적화 필요
;; n까지의 범위 생성
;; 제곱 계산
;; 숫자 분리
;; d에 해당하는 숫자만 필터링
(def n 11549)
(def d 1)

(defn digitize [n]
  (map #(Character/getNumericValue %) (str n)))

(defn digitize2 [n]
  (map read-string (map str (str n))))

(defn digitize3 [n]
  (map #(Character/digit % 10) (str n)))

(defn digitize4 [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn digitize5 [n]
  (loop [n n r '()]
    (if (< n 10) (conj r n)
        (recur (quot n 10) (conj r (rem n 10))))))

(defn digitize6 [n]
  (map #(- (int %) 48) (str n)))

(def square-digits (comp digitize #(* % %)))

(->>
 (range (inc n))
 (map square-digits)
 (flatten)
 (filter #(= d %))
 (count))

({\0 12 \1 123456} (first (str d)))

;; string에서 char를 가져올 수는 있음
(get "123445" 0)

;; 분해 후 합치기
(apply concat (map str [12 13]))

;; 위를 줄이면 아래와 같다.
(mapcat str [12 13])

;; 분해 후 숫자별 그룹화
(map concat (map str [12 13]))

;; 다른 방법
((frequencies (mapcat #(str (* % %)) (range (inc n)))) (first (str d)))

;; 다른 방법
;; 제곱 후 join 하여 frequencies를 해도 동작 한다.
((frequencies (clojure.string/join (map #(* % %) (range (inc n)))))
 (char (+ d 48)))
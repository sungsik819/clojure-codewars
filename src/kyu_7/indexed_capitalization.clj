(ns kyu-7.indexed-capitalization
  (:require [clojure.string :as string]))

(def s "abcdef")
(def idx [1 2 5])

;; 최종
;; string을 분리 한다.
;; index에 해당하는 char를 대문자로 바꾼다.
;; 하나로 합친다.
(defn solve [s idx]
  (apply str (map-indexed (fn [i v]
                            (if ((set idx) i)
                              (string/upper-case v) v)) (vec s))))

;; 위 코드를 순서대로 표시 하기
(->> (vec s)
     (map-indexed #(if ((set idx) %1)
                     (string/upper-case %2)
                     %2))
     (apply str))



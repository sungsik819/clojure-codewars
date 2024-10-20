(ns string-ends-with
  (:require [clojure.string :as string]))

(def strng "abc")
(def ending "bc")

;; 라이브러리를 사용하여 해결
(string/ends-with? strng ending)


;; 다른 사람 풀이
;; reverse 후에 첫글자부터 가져온 것을 비교값을 reverse 한 값과 비교한다.
(defn solution [strng ending]
  (= (take (count ending) (reverse strng)) (reverse ending)))
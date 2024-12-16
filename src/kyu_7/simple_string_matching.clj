(ns kyu-7.simple-string-matching
  (:require [clojure.string :as string]))

(def s1 "code*warrior")
(def s2 "codewars")

;; *는 공백이거나, 1개 이상의 문자이다.
(defn solve [s1 s2]
  ((complement nil?) (re-find (re-pattern (str "^" (string/replace s1 #"\*" "(.)*") "$")) s2)))

;; 다른 사람 풀이법
;; 굳이 (.)*로 할 필요는 없다.
;; .matches로 정규식?
(defn solve1 [s1 s2]
  (.matches s2 (clojure.string/replace s1 "*" ".*")))
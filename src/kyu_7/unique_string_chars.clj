(ns kyu-7.unique-string-chars
  (:require [clojure.string :as string]))

(def a "xyab")
(def b "xzca")

;; regex를 사용하여 해결
(defn solve [a b]
  (str (string/replace a (re-pattern (str "[" b "]")) "")
       (string/replace b (re-pattern (str "[" a "]")) "")))

;; 다른 사람 풀이
;; set을 조건식으로 할 수 있으므로 포함된 것을 제거하고, 합친다.
(defn solve2 [a b]
  (apply str (concat (remove (set b) a) (remove (set a) b))))
(ns alphabet-symmetry
  (:require [clojure.string :as string]))

(def alpha "abcdefghijklmnopqrstuvwxyz")

(defn solve [arr]
  (map #(->> (map-indexed (fn [i x] [i x]) %)
             (filter (fn [[i x]] (= (string/index-of alpha (string/lower-case x)) i)))
             (count))
       arr))

;; 다른 풀이
(defn other [arr]
  (for [s arr]
    (->> (string/lower-case s)
         (map = "abcdefghijklmnopqrstuvwxyz")
         (filter true?)
         count)))

;; 이렇게도 검증이 가능하구나..
(map = alpha "abode")
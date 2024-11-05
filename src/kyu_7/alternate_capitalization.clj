(ns kyu-7.alternate-capitalization
  (:require [clojure.string :as string]))

;; 최종
(defn solve [s]
  [(string/join (map-indexed (fn [i v] (if (even? i)
                                         (string/upper-case v)
                                         v)) (map str s)))

   (string/join (map-indexed (fn [i v] (if (odd? i)
                                         (string/upper-case v)
                                         v)) (map str s)))])
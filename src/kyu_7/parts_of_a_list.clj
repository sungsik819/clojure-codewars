(ns kyu-7.parts-of-a-list
  (:require [clojure.string :as string]))

;; parts of a list
(def arr ["az", "toto", "picaro", "zone", "kiwi"])

;; 최종
(defn partlist [arr]
  (map #(map (partial string/join " ") (split-at % arr)) (range 1 (count arr))))

(apply string/join '("toto" "picaro" "zone" "kiwi"))

(string/join " " '("toto" "picaro" "zone" "kiwi"))

;; example
(def original "This is an example!")

(apply str (reverse "This"))
(string/join " " (map #(apply str (reverse %)) (string/split original #" ")))

(float (+ 1 1/4))

(float (+ 1 1/4 1/7))

(float 1/4)
(float 1/7)

(+ 1/4 3/28)
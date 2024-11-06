(ns kyu-7.regexp-basic-is-it-a-vowel
  (:require [clojure.string :as string]))

(def s "ou")

;; 최종
(defn vowel [s]
  ((complement nil?) (re-matches #"[aeiou]" (string/lower-case s))))
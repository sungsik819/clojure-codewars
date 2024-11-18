(ns kyu-7.VAPORCODE
  (:require [clojure.string :as string]))

(def s "Why isn't my code working?")

(defn vaporcode
  [s]
  (apply str (interpose "  " (string/replace (string/upper-case s) #" " ""))))

;; 다른 사람 풀이법
(defn vaporcode1
  [s]
  (->> s
       (remove (partial = \space))
       (string/join "  ")
       (string/upper-case)))
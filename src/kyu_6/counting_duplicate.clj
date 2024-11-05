(ns kyu-6.counting-duplicate
  (:require [clojure.string :as string]))

;; counting-duplicates
(->>
 "Indivisibilities"
 (string/lower-case)
 (frequencies)
 (vals)
 (filter #(< 1 %))
 (count))
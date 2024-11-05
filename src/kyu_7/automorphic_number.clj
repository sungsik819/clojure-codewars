(ns kyu-7.automorphic-number
  (:require [clojure.string :as string]))

;; Automorphic Number
(string/includes? (str (* 25 25)) (str 25))

;; 다른 방법
(apply str (take-last (count (str 25)) (str (* 25 25))))
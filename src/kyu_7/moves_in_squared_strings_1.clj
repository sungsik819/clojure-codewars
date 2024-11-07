(ns kyu-7.moves-in-squared-strings-1
  (:require [clojure.string :as string]))

(def s "lVHt\nJVhv\nCSbg\nyeCt")

(defn vert-mirror [strng]
  ; your code
  (map #(apply str (reverse %)) strng))

(defn hor-mirror [strng]
  ; your code
  (reverse strng))

(defn oper [fct s]
  ; your code
  (let [sp (string/split s #"\n")]
    (string/join "\n" (fct sp))))

(oper vert-mirror s)
(oper hor-mirror s)
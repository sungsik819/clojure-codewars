(ns kyu-7.jaden-casing-strings
  (:require [clojure.string]))

(defn jaden-case [s]
  #_TODO
  (->> (clojure.string/split s #" ")
       (map clojure.string/capitalize)
       (clojure.string/join " ")))
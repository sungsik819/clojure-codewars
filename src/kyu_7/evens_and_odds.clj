(ns kyu-7.evens-and-odds
  (:require [clojure.pprint :refer [cl-format]]))

(def n 58)
(defn evens-and-odds [n]
  (if (even? n)
    (cl-format nil "~b" n)
    (cl-format nil "~x", n)))
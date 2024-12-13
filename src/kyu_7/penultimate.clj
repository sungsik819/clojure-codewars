(ns kyu-7.penultimate)

(def lst "LISP IS AWESOME")

(defn penultimate
  [lst]
  (second (reverse lst)))
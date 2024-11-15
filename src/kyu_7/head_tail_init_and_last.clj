(ns kyu-7.head-tail-init-and-last)

(defn head [x]
  (first x))

(defn tail [x]
  (rest x))

(defn init [x]
  (reverse (rest (reverse x))))

(defn last_ [x]
  (last x))

(init [])
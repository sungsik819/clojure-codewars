(ns kyu-7.drying-potatoes)

(def p0 99)
(def w0 100)
(def p1 98)

(defn potatos [p0 w0 p1]
  (int (* w0 (/ (- 100 p0) (- 100 p1)))))
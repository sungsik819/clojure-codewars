(ns find-the-slope)

(def v [10 20 20 80])

(let [[x1 y1 x2 y2] v
      xs (- x2 x1)
      ys (- y2 y1)]
  (if (zero? xs) "undefined"
      (str (quot ys xs))))
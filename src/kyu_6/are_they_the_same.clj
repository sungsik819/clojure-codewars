(ns kyu-6.are-they-the-same)

(defn square [x]
  (* x x))

(defn compSame [a b]
  ; your code
  (if (or (nil? a) (nil? b)) false
      (= (sort (map square a)) (sort b))))
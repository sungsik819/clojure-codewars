(ns kyu-6.find-the-odd-int)


(->> [0 1 0 1 0]
     frequencies
     (filter (fn [[_ v]] (odd? v)))
     flatten
     first)

;; 다른 사람 풀이
(defn find-odd [xs]
  (->> (frequencies xs)
       (filter #(odd? (second %)))
       ffirst))
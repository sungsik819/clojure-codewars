(ns kyu-7.maximum-triplet-sum)

;; Maximum Triplet Sum (Array Series #7)
(defn get-triple-max [numbers]
  (loop [i 0 r [] d (sort > (set numbers))]
    (let [m (first d)]
      (if (= i 3) r
          (recur (inc i) (conj r m) (rest d))))))

;; 다른 풀이
(defn max-tri-sum [n]
  (->> n distinct sort (take-last 3) (reduce +)))
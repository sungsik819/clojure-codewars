(ns kyu-7.disarium-number)

(defn digitize [n]
  (map read-string (map str (str n))))

(defn disarium-number [number]
  (if (= number (->> (digitize number)
                     (map-indexed (fn [idx item] (int (Math/pow item (inc idx)))))
                     (apply +)))
    "Disarium !!"
    "Not !!"))
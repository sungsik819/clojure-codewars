(ns kyu-6.reach-me-and-sum-my-digits)

(defn digitize [n]
  (map read-string (map str (str n))))

(defn sum-dig-nth-term [initval patternl nthterm]
  (->> (cycle patternl)
       (take (dec nthterm))
       (reductions + initval)
       (last)
       (digitize)
       (apply +)))

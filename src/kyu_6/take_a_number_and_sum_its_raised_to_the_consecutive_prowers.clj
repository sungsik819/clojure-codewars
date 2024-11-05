(ns kyu-6.take-a-number-and-sum-its-raised-to-the-consecutive-prowers)

;; Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!
(defn digitize [n]
  (map read-string (map str (str n))))

(defn digit-pow-sum [n]
  (apply + (map-indexed #(int (Math/pow %2 (inc %1))) n)))

(let [r (range 1 100)]
  (->> (map digit-pow-sum (map digitize r))
       (map vector r)
       (filter (fn [[n p]] (= n p)))
       (map first)))

(map digitize (range 1 100))
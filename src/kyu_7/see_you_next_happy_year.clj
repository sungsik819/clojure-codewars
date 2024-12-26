(ns kyu-7.see-you-next-happy-year)

(defn digitize [n]
  (map read-string (map str (str n))))

(def year 1001)

;; 연도가 중복이 아닌 연도 찾기
(defn next-happy-year [year]
  (loop [y (inc year)]
    (if (apply distinct? (digitize y)) y
        (recur (inc y)))))
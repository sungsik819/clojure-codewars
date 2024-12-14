(ns kyu-7.balanced-number)

(defn digitize [n]
  (map read-string (map str (str n))))

(def numb 413023)

;; 가운데 숫자를 기준으로 양 옆 숫자의 합이 같은지 확인
;; 짝수인 경우 가운데 숫자는 2개이다.
(let [d (digitize numb)
      c (count d)
      b (if (even? c)
          (dec (int (/ c 2)))
          (int (/ c 2)))]
  (if (= (apply + (take b (digitize numb)))
         (apply + (take b (reverse (digitize numb)))))
    "Balanced"
    "Not Balanced"))
(ns special-number-5)

(defn digitize [n]
  (map read-string (map str (str n))))

(if (every? true? (map #(<= 0 % 5) (digitize 709)))
  "Special!!"
  "NOT!!")

;; 다른 사람 풀이
;; 정규식으로 찾기
(defn special-number [n]
  (if (re-find #"^[0-5]+$" (str n)) "Special!!" "NOT!!"))

;; every?에 set을 비교하여 찾기
(defn special-number2 [number]
  (if (every? #{\0 \1 \2 \3 \4 \5} (str number)) "Special!!" "NOT!!"))

;; map 순환시 char list로 분해 되므로 every?도 실행 가능하다.
(map identity "123")

(every? #{\0 \1 \2 \3 \4 \5} "123")
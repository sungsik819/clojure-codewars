(ns kyu-7.tidy-number)

;; 커지거나 같은 숫자이면 참, 아니면 거짓을 판별 한다.
(defn digitize [n]
  (map read-string (map str (str n))))

;; 최종
(defn tidy-number [n]
  (apply <= (digitize n)))

;; 다른 사람 풀이
;; 순서가 sort한 것과 같으면 참으로 한다.
(defn tidy-number2 [n]
  (let [digits (seq (str n))]
    (= digits (sort digits))))
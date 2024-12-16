(ns util)

;; 앞의 문자를 끝에 붙이기
(defn cc-rotate [cc]
  (apply str (flatten [(rest cc) (first cc)])))

;; 앞의 문자를 끝에 붙이기
(defn rotate-s [s]
  (str (subs s 1) (subs s 0 1)))


;; 숫자를 컬렉션으로 바꾸기
(defn digitize [n]
  (map #(Character/getNumericValue %) (str n)))

(defn digitize2 [n]
  (map read-string (map str (str n))))

(defn digitize3 [n]
  (map #(Character/digit % 10) (str n)))

(defn digitize4 [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn digitize5 [n]
  (loop [n n r '()]
    (if (< n 10) (conj r n)
        (recur (quot n 10) (conj r (rem n 10))))))

(defn digitize6 [n]
  (map #(- (int %) 48) (str n)))
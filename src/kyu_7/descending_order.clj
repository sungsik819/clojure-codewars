(ns kyu-7.descending-order)

(def n 123456789)

(defn digitize [n]
  (map read-string (map str (str n))))

(defn desc-order [n]
  (read-string (apply str (sort > (digitize n)))))

;; 다른 사람 풀이법
;; str 후, sort하면 자동으로 character로 분리 된다.
(defn desc-order1 [n]
  (->> (str n)
       sort reverse
       (apply str)
       Integer/parseInt))
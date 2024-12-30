(ns kyu-7.jumping-number)

(def number 79)

(defn digitize [n]
  (map read-string (map str (str n))))

;; 각 자리수의 차이가 모두 1이면 점핑 값이다.
(defn jumping-number [number]
  (let [d (digitize number)]
    (cond (= 1 (count d)) "Jumping!!"
          (->> d
               (partition 2 1)
               (map #(Math/abs (apply - %)))
               (every? #(= 1 %))) "Jumping!!"
          :else "Not!!")))

;; abs를 하지 않고도 가능 하다
(let [d (digitize number)]
  (cond (= 1 (count d)) "Jumping!!"
        (->> d
             (partition 2 1)
             (map #(apply - %))
             (every? #{1 -1})) "Jumping!!"
        :else "Not!!"))

;; 다른 사람 풀이법
;; str 변형후 compare 하게 되면 두 숫자의 차이를 반환하게 된다
;; map으로 하면 각 자리에 해당하는 값의 차이 들을 seq로 반환 한다.
(defn jumping-number1 [number]
  (if (every? #{1 -1} (map compare (str number) (rest (str number))))
    "Jumping!!"
    "Not!!"))
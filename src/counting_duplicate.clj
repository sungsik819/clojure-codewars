(ns counting-duplicate
  (:require [clojure.string :as string]))

;; counting-duplicates

(->>
 "Indivisibilities"
 (string/lower-case)
 (frequencies)
 (vals)
 (filter #(< 1 %))
 (count))

;; transportation on vacation
;; 1 -> 40
;; 7일 이상 빌리면 50 할인
;; 3일 이상 빌리면 20 할인

(def n 3)
(cond
  (and (>= n 3) (<= n 6)) (- (* n 40) 20)
  (>= n 7) (- (* n 40) 50)
  :else (* n 40))

;; deodorant evaporator
;; content -> ml
;; 매일 evap_per_day 퍼센트 만큼 가스 또 foam을 잃는다.
;; threshold 아래 퍼센트면 더이상 유용하지 않다.

;; 10ml
;; 매일 10% 씩 잃고,
;; 5% 아래이면 유용하지 않다.
;; 몇일동안 사용 가능한가?
;; 10 10 5 -> 29일

;; 10에서 10퍼센트를 빼면 얼마 인가?
(def content 10)
(def evap_per_day 10)
(def threshold 5)

(loop [p 100 d 0]
  (if (< p threshold) d
      (recur (- p (* p (* evap_per_day 0.01))) (inc d))))

(* 100 (* 10 0.01))

;; count the digit
;; Timeout 발생하여 최적화 필요
;; n까지의 범위 생성
;; 제곱 계산
;; 숫자 분리
;; d에 해당하는 숫자만 필터링
(def n 11549)
(def d 1)

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

(def square-digits (comp digitize #(* % %)))

(->>
 (range (inc n))
 (map square-digits)
 (flatten)
 (filter #(= d %))
 (count))

({\0 12 \1 123456} (first (str d)))

;; string에서 char를 가져올 수는 있음
(get "123445" 0)

;; 분해 후 합치기
(apply concat (map str [12 13]))

;; 위를 줄이면 아래와 같다.
(mapcat str [12 13])

;; 분해 후 숫자별 그룹화
(map concat (map str [12 13]))

;; 다른 방법
((frequencies (mapcat #(str (* % %)) (range (inc n)))) (first (str d)))

;; 다른 방법
;; 제곱 후 join 하여 frequencies를 해도 동작 한다.
((frequencies (clojure.string/join (map #(* % %) (range (inc n)))))
 (char (+ d 48)))

;; convert number to reversed array of digits
(def digits (comp digitize str))

(reverse (digits 35231))

(map read-string (map str "35231"))

;; sum of the first nth term of Series
(+ 1 1/4)
(- 1/4 3/28)
(double (- 1/7 1/4))

;; build a pile of cubes
(apply + (map #(* % % %) (range 1 (inc 4824))))

(def p 135440716410000)

(loop [i 1 r 0]
  (cond
    (= r p) (dec i)
    (> r p) -1
    :else (recur (inc i) (+' r (*' i i i)))))

(read-string "1 year old")

[(string/join (map-indexed (fn [i v] (if (even? i)
                                       (string/upper-case v)
                                       v)) (map str "abcdef")))

 (string/join (map-indexed (fn [i v] (if (odd? i)
                                       (string/upper-case v)
                                       v)) (map str "abcdef")))]

;; sum of odd numbers
(+ (+ (+ 1 2) 4) 6)

(+ 1 (apply + (take (dec 4) (iterate #(+ % 2) 2))))

(defn start-number [n]
  (loop [i n r 1 d 2]
    (if (= i 1) r
        (recur (dec i) (+ r d) (+ d 2)))))

(defn start-number2 [n]
  (+ 1 (apply + (take (dec n) (iterate #(+ % 2) 2)))))

(defn triangle [n]
  (let [s (start-number2 n)
        r (take (* n 2) (iterate inc s))]
    (take n (filter odd? r))))

(def row-num 3)
(apply + (triangle row-num))

(* row-num row-num row-num)

;; 위 계산이 n^3이 되는 과정
;; The triangular number is the standard derivation of partial sums of the
;; natural numbers. These partial sums are used to index into the triangle.
;;
;; 1 + 2 + 3 + ... + n = (n(n+1))/2
;;
;; A similar derivation can be made for the partial sums of the odd numbers,
;; which we'll use to calculate the value of a row.
;;
;;  S = 1 + 3 + 5 + ... + n
;; 2S = 2(1 + 3 + 5 + ... + n)
;; 2S =  1      +  3     +  5     +  ...  +  n
;;     + (2n-1) + (2n-3) + (2n-5) +  ...  +  1
;;    = 2n + 2n + 2n + 2n + ... + 2n
;; 2S = n(2n)
;; 2S = 2n^2
;;  S = n^2
;;
;; We can subtract the partial sum of the entire triangle up to the row before
;; the one we're working with from the partial sum including that row, and this
;; will give us our answer.
;;
;; We can use triangular numbers to find the indices into the triangle and
;; calculate our partial sums.
;;
;; This gives us a final formula of:
;;
;; ((n(n+1))/2)^2 - ((n(n-1))/2)^2
;;
;; This equation can be simplified through the following steps:
;;
;; ((n^2 + n)/2)^2 - ((n^2 - n)/2)^2
;; ((n^2 + n)^2)/4 - ((n^2 - n)^2)/4
;; (n^4 + 2n^3 + n^2)/4 - (n^4 - 2n^3 + n^2)/4
;; (4n^3)/4
;; n^3


;; parts of a list
(def a ["az", "toto", "picaro", "zone", "kiwi"])

(map #(map (partial string/join " ") (split-at % a)) (range 1 (count a)))

(apply string/join '("toto" "picaro" "zone" "kiwi"))

(string/join " " '("toto" "picaro" "zone" "kiwi"))

;; example
(def original "This is an example!")

(apply str (reverse "This"))
(string/join " " (map #(apply str (reverse %)) (string/split original #" ")))

(float (+ 1 1/4))

(float (+ 1 1/4 1/7))

(float 1/4)
(float 1/7)

(+ 1/4 3/28)

;; Automorphic Number
(string/includes? (str (* 25 25)) (str 25))

;; 다른 방법
(apply str (take-last (count (str 25)) (str (* 25 25))))

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

;; Maximum Product
(apply max (map #(apply * %) (partition 2 1 [-23, 4, -5, 99, -27, 329, -2, 7, -921])))

(sort > (set [2 9 13 10 5 2 9 5]))

;; Maximum Triplet Sum (Array Series #7)
(defn get-triple-max [numbers]
  (loop [i 0 r [] d (sort > (set numbers))]
    (let [m (first d)]
      (if (= i 3) r
          (recur (inc i) (conj r m) (rest d))))))

;; 다른 풀이
(defn max-tri-sum [n]
  (->> n distinct sort (take-last 3) (reduce +)))

;; Tribonacci Sequence
(defn tribonacci [[a b c] n]
  (loop [l 3 r [1 1 1]]
    (cond
      (= l n) r
      (= n 0) []
      (= n 1) [a]
      (= n 2) [a b]
      (= n 3) [a b c]
      :else (recur (inc l) (conj r (apply + (take-last 3 r)))))))

(tribonacci [1 1 1] 0)

;; 다른 풀이
(defn trib [a b c]
  (lazy-seq
   (cons a (trib b c (+ a b c)))))

(take 3 (trib 1 1 1))
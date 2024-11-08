(ns kyu-6.primorial-of-a-number)

;; project euler에서 풀었던 함수들을 가져옴
;; 약수 구하기
(defn divisor [n]
  (let [max (inc (Math/sqrt n))]
    (->>
     (filter #(= (rem n %) 0) (range 1 max))
     (reduce #(conj %1 %2 (quot n %2))
             [])
     (set)
     (sort))))

;; 원래 수 와 약수의 조합
;; 원래수가 10이고 약수가 4개일때
;; [10 4]가 된다.
(defn div-cnt [d]
  (let [div (divisor d)
        cnt (count div)]
    [d cnt]))

;; n번째 소수 구하기
(defn n-prime [n]
  (->> (map div-cnt (range))
       (filter (fn [[_ c]] (= 2 c)))
       (take n)
       (last)
       (first)))

;; 위 함수들을 바탕으로 n개의 소수 구하는 함수 제작
;; n개의 소수 구하기
(defn prime [n]
  (->> (map div-cnt (range))
       (filter (fn [[_ c]] (= 2 c)))
       (take n)
       (map first)))


(defn num-primorial [n]
  (apply *' (prime n)))

;; 다른 사람 풀이
;; prime을 구하는 함수가 있는줄은 몰랐네..
;; biginteger에서 사용 가능함
;; iterate는 앞에 구해진 수를 사용하여 다음 수를 구한다.
(defn num-primorial2 [n]
  (->> (biginteger 2) (iterate #(.nextProbablePrime %)) (take n) (reduce *)))

(take 10 (iterate #(.nextProbablePrime %) (biginteger 2)))


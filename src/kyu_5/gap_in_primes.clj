(ns kyu-5.gap-in-primes)

(def m 300)
(def n 400)
(def g 8)

(range 100 (inc 110))

;; 소수 구하기
(defn prime? [n]
  (let [max (int (inc (Math/sqrt n)))]
    (loop [i 2]
      (cond (= (rem n i) 0) false
            (= i max) true
            :else (recur (inc i))))))

(defn gap [g m n]
  (->> (range m (inc n))
       (filter prime?)
       (partition 2 1)
       (filter (fn [[x y]] (= g (- y x))))
       (first)))

;; 다른 사람 풀이법
;; prime?을 아래로 대체 가능? -> 대체는 가능
;; 5를 넣으면 50%의 확률?
(defn prime1? [n]
  (.isProbablePrime (BigInteger/valueOf n) 5))

(->> (range m (inc n))
     (filter prime1?)
     (partition 2 1)
     (filter (fn [[x y]] (= g (- y x))))
     (first))
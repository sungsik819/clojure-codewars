(ns kyu-6.up-AND-down
  (:require [clojure.string :as string]))

;; 1.index를 알 수 있도록 구조를 만든다.
;; 2. index가 홀수이면 <= 비교, 짝수이면 >= 비교하여 구조 변환
;; 3. index가 홀수이면 lowercase, 짝수이면 uppercase로 변환

(def strng "turn know great-aunts aunt look A to back")

;; 밑에 ordered? 참고하여 변경
(defn ordered1? [f s]
  ((if (odd? (first s)) <= >=) (count (second f)) (count (second s))))

(defn arrange [strng]
  (let [r (loop [mi (map-indexed vector (.split strng " "))
                 f (first mi)
                 s (second mi)
                 result []]
            (if (nil? s) (conj result (second f))
                (if (ordered1? f s) (recur (rest mi) s (second (rest mi)) (conj result (second f)))
                    (recur (rest mi) f (second (rest mi)) (conj result (second s))))))]
    (string/join " " (map-indexed (fn [i v] (if (even? i) (.toLowerCase v)
                                                (.toUpperCase v))) r))))

;; 다른 사람 풀이법
;; 내 풀이법은 result에 값을 넣는 방식인데 아래 방식은 swap 하는 방식임
;; even? odd? 비교할 필요 없이 cycle을 이용하여 번갈아가면서 lower, upper 변환
(defn swap [v i]
  (assoc v
         i (v (inc i))
         (inc i) (v i)))

(defn ordered? [i a b]
  ((if (even? i) <= >=) (count a) (count b)))

(defn arrange1 [s]
  (let [words (string/split s #" ")]
    (->> (range (dec (count words)))
         (reduce (fn [v i]
                   (if (ordered? i (v i) (v (inc i)))
                     v
                     (swap v i)))
                 words)
         (map #(%1 %2) (cycle [string/lower-case string/upper-case]))
         (string/join " "))))

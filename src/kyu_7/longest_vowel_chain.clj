(ns kyu-7.longest-vowel-chain)

(defn solve [s]
  (count (last (sort-by count (re-seq #"[aeiou]+" s)))))

(solve "chrononhotonthuooaos")

;; 다른 사람 풀이
;; 숫자 값만 필요하므로 count를 생성 후에 max를 전달한다.
;; max값을 찾을 때 (apply max) 도 가능함
(defn solve2 [s]
  (->> s
       (re-seq #"[aeiou]+")
       (map count)
       (reduce max 0)))
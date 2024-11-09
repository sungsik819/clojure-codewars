(ns kyu-7.dominant-array-elements)

(def numbers [16,17,14,3,14,5,2])
;; 앞의 수가 뒤의 나머지 수보다 큰 수들만 결과를 리턴하는 문제
(defn solve [numbers]
  (loop [n numbers r []]
    (if (empty? n) r
        (if (every? (partial > (first n)) (rest n))
          (recur (rest n) (conj r (first n)))
          (recur (rest n) r)))))

;; 다른 사람 풀이
;; 큰수를 표시하기 위하여 reverse 한다
;; 큰 수만 남긴다.
;; 중복 제거 한다.
;; 다시 원래대로 위치를 바꾼다.
(defn solve2 [numbers]
  (->> (reverse numbers)
       (reductions max)
       dedupe
       reverse))
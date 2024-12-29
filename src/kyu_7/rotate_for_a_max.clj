(ns kyu-7.rotate-for-a-max)

(defn rotate-s [s]
  (str (subs s 1) (subs s 0 1)))

(def n 507992495)

;; 위 함수를 바탕으로 rotate-n 함수를 만드는 과정
(rotate-s (str n))

(str (subs (str n) 1) (subs (str n) 0 1))
(str (subs (str n) 0 1) (subs (str n) 2) (subs (str n) 1 2))

;; 해당 자리의 수를 끝으로 보내는 함수
(defn rotate-n [s n]
  (str (subs s 0 (dec n)) (subs s n) (subs s (dec n) n)))

;; 자리에 해당하는 단일 숫자를 끝으로 보내고 만들어진 숫자중 제일 큰 수를 찾기
;; String인 상태에서 데이터를 만든 후, Long으로 변환하는 것이 핵심이다.
(defn max-rot [n]
  (->> (range 1 (inc (count (str n))))
       (reductions #(rotate-n %1 %2) (str n))
       (map #(Long/parseLong %))
       (apply max)))

;; 다른 방식 풀이
;; reductions를 iterate로 변경 해보기
(->> (iterate (fn [[i n]] [(inc i) (rotate-n n i)]) [1 (str n)])
     (take (count (str n)))
     (map #(Long/parseLong (second %)))
     (apply max))
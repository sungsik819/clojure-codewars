(ns kyu-7.growth-of-a-population)

(def p0 1500)
(def percent 5)
(def aug 100)
(def p 5000)

(defn nb-year [p0 percent aug p]
  (loop [year 0 in-p p0]
    (if (>= in-p p) year
        (recur (inc year)
               (int (+ aug (+ in-p (* in-p (* 0.01 percent)))))))))

(nb-year 1500000 2.5 10000 2000000)
(nb-year 1500000 0.25 1000 2000000)

;; 다른 사람 풀이법
;; iterate - 앞의 결과 값을 바탕으로 계샨한 컬렉션을 반환 한다.
(defn nb-year2 [p0 percent aug p]
  (let [growing-fn #(+ % aug (Math/floor (* (/ percent 100) %)))
        population (iterate growing-fn p0)]
    (count (take-while #(< % p) population))))
(ns kyu-7.target-dates
  (:import [java.time LocalDate]))

(def a0 4281)
(def a 5087)
(def p 2)

(defn date-nb-days [a0 a p]
  (let [days (loop [days 0
                    a0 a0]
               (if (>= a0 a) days
                   (recur (inc days) (+ a0 (double (/ (/ (* a0 p) 100) 360))))))]
    (str (.plusDays (LocalDate/of 2016 1 1) days))))

;; 다른 사람 풀이법
;; 반복 없이 log를 사용해서 어떻게 적용되는거지?
(def ft (java.text.SimpleDateFormat. "yyyy-MM-dd"))
(def ^:const st (.getTime (.parse ft "2016-01-01")))
(defn date-nb-days-aux [n]
  (.format ft
           (java.util.Date. (+ (* n 86400 1000)
                               st))))
(defn date-nb-days1 [a0 a p]
  (let [r1 (Math/log (/ a (double a0)))
        r2 (Math/log (+ 1 (/ p 36000.0)))
        r  (int (Math/ceil (/ r1 r2)))]
    (date-nb-days-aux r)))
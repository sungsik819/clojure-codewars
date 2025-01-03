(ns kyu-6.statistics-for-an-Athletic-Association
  (:require [clojure.string :as string])
  (:import [java.time LocalTime]
           [java.time.format DateTimeFormatter]
           [java.time.temporal ChronoUnit]))

(def strg "")

;; 1. 파싱 후 시간으로 변환
;; 2. 오름차순으로 sort 한다.
;; range, avg, median 값을 구한다
;; string으로 변환 한다.
(defn stat [strg]
  (if (empty? strg) ""
      (let [sorted-times (vec (sort (map #(LocalTime/parse % (DateTimeFormatter/ofPattern "H|mm|s"))
                                         (string/split strg #", "))))
            list-size (count sorted-times)
            range (LocalTime/ofSecondOfDay (.until (first sorted-times) (last sorted-times) ChronoUnit/SECONDS))
            avg (LocalTime/ofSecondOfDay (int (/ (reduce (fn [acc v] (+ acc (.toSecondOfDay v))) 0 sorted-times) list-size)))
            median (if (odd? list-size) (sorted-times (int (/ list-size 2)))
                       (LocalTime/ofSecondOfDay (/ (+ (.toSecondOfDay (sorted-times (int (/ list-size 2))))
                                                      (.toSecondOfDay (sorted-times (- (int (/ list-size 2)) 1)))) 2)))]
        (str "Range: " (.format range (DateTimeFormatter/ofPattern "HH|mm|ss"))
             " Average: " (.format avg (DateTimeFormatter/ofPattern "HH|mm|ss"))
             " Median: " (.format median (DateTimeFormatter/ofPattern "HH|mm|ss"))))))
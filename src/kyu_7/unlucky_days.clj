(ns kyu-7.unlucky-days
  (:import [java.time LocalDate DayOfWeek]))

(def year 2015)

(defn unluckyDays [year]
  (count (filter #(= DayOfWeek/FRIDAY (.getDayOfWeek %))
                 (map #(LocalDate/of year % 13) (range 1 13)))))
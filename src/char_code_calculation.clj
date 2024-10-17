(ns char-code-calculation
  (:require [clojure.string :as string]))

(def s "aaaaaddddr")

(string/replace (apply str (map int (seq s))) #"7" "1")

(defn digitize [n]
  (map read-string (map str (str n))))

(let [total1 (apply str (map int (seq s)))
      total2 (string/replace total1 #"7" "1")]
  (- (apply + (digitize total1))
     (apply + (digitize total2))))

;; 다른 사람들 풀이
(defn calc [s]
  (->> s (mapcat (comp str int)) (filter #(= % \7)) count (* 6)))
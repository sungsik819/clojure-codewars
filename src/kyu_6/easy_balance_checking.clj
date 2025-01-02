(ns kyu-6.easy-balance-checking
  (:require [clojure.string :as string]))

(def book "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00 ?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?")

;; 1. 기호 없애기
;; 2. 숫자 필터링 하기
;; 3. 숫자 계산 하기
;; 4. 추가 항목 계산 하기
;; 5. 문자열에 붙이기
(defn balance [book]
  (let [s (string/join "" (filter #(not= "" %) (string/split book #"[!=:;?{}]")))
        s-seq (map #(string/join " " %) (map #(string/split % #" ") (rest (string/split s #"\n"))))
        balance-values (reductions #(format "%.2f" (- (Double/valueOf %1) (Double/valueOf %2))) (re-seq #"\d+\.\d+" s))
        balance-struct (map #(string/join "" %) (partition 2 (conj (interpose "Balance " balance-values) "Original Balance: ")))
        total-expense (- (Double/valueOf (first balance-values)) (Double/valueOf (last balance-values)))
        average-expense (/ total-expense (count (rest balance-values)))
        average-round (/ (Math/round (* 100 average-expense)) 100.0)
        add-balanced (vec (conj (map #(string/join " " %) (partition 2 (interleave s-seq (rest balance-struct)))) (first balance-struct)))
        balance (str "Total expense  " (format "%.2f" total-expense) "\nAverage expense  "  (format "%.2f" average-round))]
    (string/join "\n" (conj add-balanced balance))))
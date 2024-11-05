(ns kyu-8.convert-number-to-reversed-array-of-digits)

;; convert number to reversed array of digits
(defn digitize [n]
  (map #(Character/getNumericValue %) (str n)))

(def digits (comp digitize str))

(reverse (digits 35231))

(map read-string (map str "35231"))

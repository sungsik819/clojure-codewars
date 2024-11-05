(ns kyu-7.strong-number)

(defn strong [n]
  (let [r (apply + (map #(apply * (range % 0 -1))
                        (map #(Character/getNumericValue %) (str n))))]
    (if (= r n) "STRONG!!!!"
        "Not Strong !!")))
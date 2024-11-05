(ns kyu-7.categorize-new-member)

(def data [[74 10] [55 6] [12 -2] [68 7]])

(defn open-or-senior [data]
  (map (fn [[a h]] (if
                    (and (>= a 55) (> h 7)) "Senior"
                    "Open")) data))
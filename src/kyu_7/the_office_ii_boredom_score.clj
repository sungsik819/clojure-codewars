(ns kyu-7.the-office-ii-boredom-score)

(def de {:accounts 1
         :finance 2
         :canteen 10
         :regulation 3
         :trading 6
         :change 6
         :IS 8
         :retail 5
         :cleaning 4
         :pissing_about 25})

(def xs [["tim" :pissing_about]
         ["jim" :canteen]
         ["randy" :canteen]
         ["sandy" :change]
         ["andy" :change]
         ["katie" :IS]
         ["laura" :change]
         ["saajid" :IS]
         ["alex" :trading]
         ["john" :accounts]])

(defn boredom [xs]
  (let [score (apply + (map (comp #(% de) second) xs))]
    (cond (<= score 80) "kill me now"
          (< 80 score 100) "i can handle this"
          :else "party time!!")))
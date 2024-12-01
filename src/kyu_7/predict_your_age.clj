(ns kyu-7.predict-your-age)

(def l [65 60 75 55 60 63 64 45])

(defn predict-age [age1 age2 age3 age4 age5 age6 age7 age8]
  (let [l (vector age1 age2 age3 age4 age5 age6 age7 age8)]
    (int (quot (Math/sqrt (apply + (map #(* % %) l))) 2))))

(predict-age 65 60 75 55 60 63 64 45)
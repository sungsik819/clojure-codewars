(ns max-length-diff)

(def a1 ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"])
(def a2 ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"])

(let [a1c (map count a1)
      a2c (map count a2)]
  (max (Math/abs (- (apply max a1c)
                    (apply min a2c)))
       (Math/abs (- (apply min a1c)
                    (apply max a2c)))))
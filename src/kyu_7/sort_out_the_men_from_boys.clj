(ns kyu-7.sort-out-the-men-from-boys)

(defn men-from-boys [arr]
  (flatten [(sort < (filter even? (set arr)))
            (sort > (filter odd? (set arr)))]))
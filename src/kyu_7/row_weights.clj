(ns kyu-7.row-weights)

(defn row-weights [weights]
  ;TODO
  [(apply + (keep-indexed #(when (even? %1) %2) weights))
   (apply + (keep-indexed #(when (odd? %1) %2) weights))])
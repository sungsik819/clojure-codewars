(ns kyu-7.minimum-steps)

(def numbers [4 6 3])

(def value 7)

(defn minimum-steps [numbers value]
  (reduce #(if (< %2 value) (inc %1) %1) 0 (reductions + (sort numbers))))

;; 다른 사람 풀이법
;; reduce 대신에 take-while을 사용하여 value 보다 작은 값을 가져오고 count를 센다.
(defn minimum-steps1 [numbers value]
  (->> (sort numbers)
       (reductions +)
       (take-while #(< % value))
       (count)))
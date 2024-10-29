(ns simple-consecutive-pairs)


(defn pairs [arr]
  (count (filter (fn [[f l]] (or (= 1 (- f l))
                                 (= -1 (- f l)))) (partition 2 arr))))

;; 다른 사람 풀이
;; 절대값 사용
(defn pairs2 [arr]
  (->> (partition 2 arr)
       (filter (fn [[a b]] (= 1 (Math/abs (- b a)))))
       (count)))

;; filter에서 set 사용
(defn pairs3 [coll]
  (let [pair-coll (partition 2 coll)
        map-minus (map #(apply - %) pair-coll)]
    (count (filter #{-1 1} map-minus))))

;; comp 사용
(defn pairs4 [arr]
  (->> arr
       (partition 2)
       (filter (comp #{-1 1} (fn [[a b]] (- a b))))
       (count)))
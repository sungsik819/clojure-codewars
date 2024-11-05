(ns kyu-6.higiest-rank-number)

(def data [12, 10, 8, 8, 3, 3, 3, 3, 2, 4, 10, 12, 10])

(ffirst (sort #(if (or (> (second %1) (second %2))
                       (and (= (second %1) (second %2))
                            (> (first %1) (first %2)))) true false)
              (frequencies data)))

;; 다른 사람들 풀이
;; sql의 여러 항목 order 처럼 사용하려면 juxt를 사용 한다.
(->> data
     frequencies
     (sort-by (juxt val key))
     last
     first)

(->> data
     frequencies
     (sort-by val)
     last
     key)
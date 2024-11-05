(ns kyu-7.maximum-product)

;; Maximum Product
(apply max (map #(apply * %) (partition 2 1 [-23, 4, -5, 99, -27, 329, -2, 7, -921])))

(sort > (set [2 9 13 10 5 2 9 5]))
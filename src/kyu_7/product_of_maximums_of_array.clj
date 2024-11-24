(ns kyu-7.product-of-maximums-of-array)

(defn max-product [arr size]
  (apply * (take size (reverse (sort arr)))))
(ns kyu-7.gcd-sum)

(defn gcd [a b]
  (loop [r (rem a b)
         a b]
    (if (zero? r) a
        (recur (rem a r) r))))

(def s 12)
(def g 4)

(defn solve [s g]
  (if (= g (gcd g (- s g))) [g (- s g)]
      -1))

;; 다른 사람 풀이법
;; 단순하게 나눠서 떨어지는지만 확인 하면 됨
(defn solve1 [s g]
  (if (= 0 (rem s g)) [g, (- s g)] -1))
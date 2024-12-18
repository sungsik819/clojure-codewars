(ns kyu-7.beginner-series-triangular-numbers)

(def t 2769)

;; 한변이 n인 트라이앵글 넘버
(defn triangle [n]
  (/ (* n (+ n 1)) 2))

(defn is-triangular [t]
  (if (= t 1) true
      ((complement nil?) (some #(= t %) (take t (map triangle (range)))))))

;; 다른 사람 풀이법
;; 위의 triangle을 n을 구하는 공식으로 변형하면 됨
(defn is-triangular1 [t]
  (let [n (int (Math/sqrt (* 2 t)))]
    (= t (* n (inc n) 1/2))))
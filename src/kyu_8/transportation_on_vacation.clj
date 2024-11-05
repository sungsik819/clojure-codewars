(ns kyu-8.transportation-on-vacation)

;; transportation on vacation
;; 1 -> 40
;; 7일 이상 빌리면 50 할인
;; 3일 이상 빌리면 20 할인

(def n 3)
(cond
  (and (>= n 3) (<= n 6)) (- (* n 40) 20)
  (>= n 7) (- (* n 40) 50)
  :else (* n 40))
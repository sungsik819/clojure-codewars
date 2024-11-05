(ns kyu-7.deodrant-evaporator)

;; deodorant evaporator
;; content -> ml
;; 매일 evap_per_day 퍼센트 만큼 가스 또 foam을 잃는다.
;; threshold 아래 퍼센트면 더이상 유용하지 않다.

;; 10ml
;; 매일 10% 씩 잃고,
;; 5% 아래이면 유용하지 않다.
;; 몇일동안 사용 가능한가?
;; 10 10 5 -> 29일

;; 10에서 10퍼센트를 빼면 얼마 인가?
(def content 10)
(def evap_per_day 10)
(def threshold 5)

;; 최종
(defn evaporator [content evap_per_day threshold]
  (loop [p 100 d 0]
    (if (< p threshold) d
        (recur (- p (* p (* evap_per_day 0.01))) (inc d)))))

(* 100 (* 10 0.01))
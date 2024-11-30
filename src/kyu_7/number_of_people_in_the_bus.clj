(ns kyu-7.number-of-people-in-the-bus)

(def bus-stops [[3 0] [9 1] [4 10] [12 2] [6 1] [7 10]])

;; 각각의 버스 정류장에서 내린 또는 탑승한 승객의 최종 값을 계산 한다.
;; 그 값의 최종 값을 계산 한다.
(defn number [bus-stops]
  (apply + (map (fn [[i o]] (- i o)) bus-stops)))

;; 다른 사람 풀이법
;; (apply map + bus-stop)을 하게 되면 (탑승한승객 내린승객) 형태로 계산 된다.
;; 그 값을 - 해주면 최종 결과가 나온다.
(defn number1
  [bus-stops]
  (reduce - (apply map + bus-stops)))
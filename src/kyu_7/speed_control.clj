(ns kyu-7.speed-control)

;; 매 s초 거리를 측정 한다.
;; x의 length가 1이면 0을 리턴한다.
;; 공식 : (3600 * delta_distance) / s

(def x [0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61])

(def s 20)

(->>
 ;; 구간별 거리 구하기
 (map #(apply - %) (partition 2 1 x))
 ;; 공식에 대입 
 (map #(Math/abs (/ (* 3600 %) s)))
 (apply max)
 int)

;; 다른 사람 풀이
(defn gps [s x]
  (int (/ (* 3600 (reduce max 0 (map - (rest x) x))) s)))

;; 뒤에 값에서 앞에 값을 빼도록 계산
(map - (rest x) x)

;; 값이 없을 경우 0을 리턴하기 위해 reduce 사용
;; (apply max (map - (rest x) x))로 해도 되지만 length가 1이면 0을 따로 분기 해줘야 한다.
(reduce max 0 (map - (rest x) x))
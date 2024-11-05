(ns looking-for-a-benefactor)

;; navg에 다음 값이 몇인지 구하는 문제
;; (def arr [14, 30, 5, 7, 9, 11, 16])
;; (def navg 90)
;; 와 같은 경우

;; 구하고자 하는 값을 x로 하고, 8개가 되었을때 90이 되면 된다.

;; 식으로 풀어 쓰면
;; ((arr의 합) + x) / 8 = 90 과 같으면 되므로
;; x = (90 * 8) - (arr의 합)이다.

(def arr [14, 30, 5, 7, 9, 11, 15.3])
(def navg 92)

(quot (+ 628 (apply + arr)) 8)

(quot (apply + arr) 7)

(apply + arr)

;; 최종
;; 아래 이전 풀이의 괄호를 풀어서 다시 구현 함
(defn new-avg [arr navg]
  (let [na (-> navg
               (* (inc (count arr)))
               (- (apply + arr))
               (Math/ceil)
               (int))]
    (if (< na 0) (throw (IllegalArgumentException.))
        na)))

(new-avg [14, 30, 5, 7, 9, 11, 15.3] 92)
(new-avg [14, 30, 5, 7, 9, 11, 15] 2)

;; 이전 풀이
;; ceil이 round처럼 안되는 줄 알고 직접 구현 함
(defn ceil [d]
  (if (= d (int d)) (int d)
      (int (+ 1 d))))

(defn new-avg2 [arr navg]
  ; your code
  (let [na (ceil (- (* navg (inc (count arr))) (apply + arr)))]
    (if (< na 0) (throw (IllegalArgumentException.))
        na)))
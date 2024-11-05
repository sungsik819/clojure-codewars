(ns kyu-6.bouncing-balls)

;; h는 0보다 크다
;; bounce는 0보다 크고  1보다 작다
;; window는 h보다 작다.

(* 3 0.66)
(* 1.98 0.66)
(* 1.3068 0.66)

(* 3 1)

;; 처음 푼 방법 
(defn bouncing-balls [h bounce window]
  (cond
    (<= h 0) -1
    (and (< bounce 0) (> bounce 1)) -1
    (>= window h) -1
    :else (loop [c 1 bh (* h bounce)]
            (if (< bh window) c
                (recur (+ c 2) (* bh bounce))))))

;; cond보다는 if가 빠르다.
(defn bouncing-balls2 [h bounce window]
  (if (and (> h 0)
           (< window h)
           (> bounce 0)
           (< bounce 1))
    (loop [c 1 bh (* h bounce)]
      (if (<= bh window) c
          (recur (+ c 2) (* bh bounce))))
    -1))

;; 범위 크기 비교시 and를 넣지 않아도 간단하게 비교 할 수 있다.
;; 즉, (and (> bounce 0) (< bounce 1)) 처럼 하지 않고
;; (< 0 bounce 1)로 할 수 있다.

(< 0 0.66 1)

;; 다른 사람의 방법
(defn bouncing-balls3 [h bounce window]
  (if-not (and (> h 0) (< 0 bounce 1) (< window h)) -1
          (-> (/ window h) Math/log (/ (Math/log bounce)) Math/ceil int (* 2) dec)))
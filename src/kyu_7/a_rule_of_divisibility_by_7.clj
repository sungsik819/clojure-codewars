(ns kyu-7.a-rule-of-divisibility-by-7)

;; A Rule of Divisibility by 7
(loop [s 0 v 234002979492340029794]
  (let [sv (str v)]
    (if (<= (count sv) 2) [v s]
        (recur (inc s) (- (bigint (apply str (take (- (count sv) 1) sv)))
                          (* 2 (Character/getNumericValue (last sv))))))))

;; 다른 방법
(defn seven [m]
  (loop [m m steps 0]
    (if (< m 100) ;; 100보다 작으면 2자리 이다.
      [m, steps]
      (let [x (quot m 10) ;; 나눴을 때의 값
            y (rem m 10)] ;; 나머지 값
        (recur (- x (* 2 y)) (inc steps))))))

;; 나누기
(quot 477557101 10)

;; 나머지
(rem 477557101 10)
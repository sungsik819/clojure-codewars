(ns kyu-8.whats-up-next)

(def xs (range 1 25))
(def item 12)

(defn next-item
  [xs item]
  (loop [r xs]
    (cond (= (first r) item) (second r)
          (empty? r) nil
          :else (recur (rest r)))))

;; 다른 사람 풀이법
;; drop-while을 사용하여 앞에서 부터 item이 아닌 값을 삭제 하고,
;; item을 만나면 종료하여 나머지 값들을 남긴다.
(defn next-item1
  "Returns the value that comes after item in xs or nil"
  ([xs item]
   (second (drop-while (complement #{item}) xs))))
(ns kyu-7.fill-the-hard-disk-drive)

(def sizes [4 4 4 3 3])
(def hd 12)

;; 최종
(defn save [sizes hd]
  (if (<= (apply + sizes) hd) (count sizes)
      (loop [i 0 coll sizes s 0]
        (println s)
        (cond (> s hd) (dec i)
              (>= s hd) i
              :else (recur (inc i) (rest coll) (+ s (first coll)))))))

;; 다른 사람 풀이
;; reductions를 사용하여 중간 과정 계산을 남긴다.
;; 0은 지운다.
;; 계산된 값이 hd보다 작거나 같은 값만 남긴다.
;; 갯수를 계산 한다.
;; take-while 대신 filter로도 가능 
(defn save2 [sizes hd]
  (->> sizes (reductions + 0) rest (take-while #(<= % hd)) count))
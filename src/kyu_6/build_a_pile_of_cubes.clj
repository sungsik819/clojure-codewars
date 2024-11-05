(ns kyu-6.build-a-pile-of-cubes)

;; build a pile of cubes
;; 연습
(apply + (map #(* % % %) (range 1 (inc 4824))))

(def m 135440716410000)

;; 최종
(defn find-nb [m]
  (loop [i 1 r 0]
    (cond
      (= r m) (dec i)
      (> r m) -1
      :else (recur (inc i) (+' r (*' i i i))))))
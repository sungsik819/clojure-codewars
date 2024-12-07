(ns kyu-7.homogenous-arrays)

(def sq [[1 5 4] [\a 3 5] [\b] [] [\1 2 3]])

;; 외부에는 filter
;; 내부에는 reduce ?
;; every?로 가능 할 것 같다

(defn filter-homogenous [sq]
  (->> sq
       (filter #(every? (fn [v]
                          (= (type (first %)) (type v))) (rest %)))
       (remove #(nil? (seq %)))))

;; 다른 사람 풀이법
;; type으로 변환 후에 apply로 = 체크
(defn homogenous [sq]
  (if (empty? sq)
    false
    (apply = (map type sq))))


(defn filter-homogenous1 [sq]
  (filter homogenous sq))
(ns kyu-7.how-green-is-my-valley)

(def arr [17, 17, 15, 14, 8, 7, 7, 5, 4, 4, 1])

;; 풀이 과정
(sort > arr)

(map second (filter (fn [[i _]] (even? i)) (map-indexed (fn [i v] [i v]) (sort > arr))))
(map second (filter (fn [[i _]] (odd? i)) (map-indexed (fn [i v] [i v]) (sort > arr))))

;; 왼쪽은 큰수에서 작은수로 정렬
;; 오른쪽 끝에서는 큰수에서 작은수로 정렬 하여 하나의 array로 만들기
(defn make-vally [arr]
  (flatten ((juxt (comp (partial map second)
                        (partial filter (fn [[i _]] (even? i))))
                  (comp reverse (partial map second)
                        (partial filter (fn [[i _]] (odd? i))))) (map-indexed (fn [i v] [i v]) (sort > arr)))))

;; 다른 사람 풀이법
;; take-nth를 사용하여 건너띄면서 가져오는 것이 가능하다.
(defn make-valley1 [arr]
  (let [heights (sort > arr)]
    (flatten [(take-nth 2 heights) (reverse (take-nth 2 (rest heights)))])))
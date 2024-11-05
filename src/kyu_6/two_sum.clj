(ns kyu-6.two-sum)

(def numbers [830 547 305 324])
(def target 1377)
(def index-values (map-indexed (fn [i v] [i v]) numbers))

;; 1번 돌려서 위치 변경 하기
(def rotate-1 (concat (drop 1 index-values) (take 1 index-values)))

;; value는 계산, index는 합치기
(def calc-values (map (fn [[i1 v1] [i2 v2]] [[i1 i2] (+ v1 v2)]) index-values rotate-1))

;; target 값을 필터링 하기
(def filtered-target (filter (fn [[[_ _] v]] (= v target)) calc-values))

;; index 찾고 [2 0] 같은 부분이 있으므로 sort 하기
(sort (ffirst filtered-target))

;; 최종 - rotate 한 부분에 대해서만 계산이 되어, 이 방법은 아님
(defn twosum [numbers target]
  (let [indexed (map-indexed (fn [i v] [i v]) numbers)
        rotate-1 (concat (drop 1 indexed) (take 1 indexed))
        calc-values (map (fn [[i1 v1] [i2 v2]] [[i1 i2] (+ v1 v2)]) indexed rotate-1)
        filtered-target (filter (fn [[[_ _] v]] (= v target)) calc-values)]
    (ffirst filtered-target)))


;; 최최종
;; for를 사용하여 계산하고, 데이터를 만들어서 값 추출
;; (apply not= (first r))로 인덱스에 대한 비교를 할 수 있다.
;; [i v] 형태로 인덱스, 값의 자료구조를 만든다.
;; 각각의 합 및 target과 같고, 인덱스가 다른 경우만 필터링 한다.
(defn twosum2 [numbers target]
  (let [indexted (map-indexed (fn [i v] [i v]) numbers)]
    (ffirst (for [x indexted
                  y indexted
                  :let [r [[(first x) (first y)] (+ (second x) (second y))]]
                  :when (and (= target (second r))
                             (apply not= (first r)))]
              r))))

(twosum2 [2 2 3] 4)

;; 다른 사람의 풀이
;; index를 range로 생성
;; i, j 인덱스가 같지 않고, 인덱스에 해당하는 값의 합이 target과 같은 것의 first를 보여준다.
(defn twosum3 [numbers target]
  (first
   (for [i (range (count numbers))
         j (range (count numbers))
         :when (and (not= i j)
                    (= target (+ (nth numbers i) (nth numbers j))))]
     [i j])))
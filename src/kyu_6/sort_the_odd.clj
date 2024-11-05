(ns kyu-6.sort-the-odd)

;; 짝수는 그자리에 두고 홀수만 sorting 한다.
;; 단, 짝수의 위치는 변경되면 안된다.

;; 짝수 값의 인덱스와 값을 필터링 한다.
;; 필터링된 값을 정렬 한다.
;; 해당하는 인덱스에 값을 교체 한다.

;; 최종
(def xs '(67 14 48 93 6 57 94 13 2 45 86 42 99 16 71 99 10 51 78 59 63 42 24 26))
(defn sort-odd [xs]
  (let [sv (apply vector (sort-by second (filter (fn [[_ v]] (odd? v))
                                                 (map-indexed vector xs))))
        si (sort (map first sv))]
    (map #(assoc-in %1 [0] %2) sv si)))

(if (nil? (seq xs)) []
    (let [vs (apply vector xs)]
      (reduce (fn [acc [i v]] (assoc-in acc [i] v)) vs (sort-odd vs))))


;; 다른 사람 풀이
(defn sort-array2 [xs]
  (let [mapping (map-indexed vector xs)
        odds (filter (comp odd? second) mapping)
        sorted-odds (sort-by second odds)
        replacements (zipmap (map first odds) (map second sorted-odds))]
    (map-indexed (partial get replacements) xs)))


;; 분석 하기
(def mapping (map-indexed vector xs))
;; 중첩 항목에 대한 filter
;; 중첩된 데이터를 접근하기 위해서는 comp를 사용한다.
;; 예시 ((comp first second) [[0 1] [1 2]])
(def odds (filter (comp odd? second) mapping))
(def sorted-odds (sort-by second odds))

;; (map #(assoc-in %1 [0] %2) sv si) 부분을 대체 할 수 있다.
;; 2개의 같은 크기의 데이터를 합쳐서 map으로 만든다.
;; 즉 앞의 map은 key, 뒤의 map은 value가 되는 map을 만든다.
(def replacements (zipmap (map first odds) (map second sorted-odds)))

;; 최종 컬렉션을 리턴 한다.
;; (map-indexed #(get replacements %1 %2) xs) 와 같은 의미
;; replacements에 key가 있으면 %1을 사용하고 없으면 xs의 값을 사용한다.
(map-indexed (partial get replacements) xs)
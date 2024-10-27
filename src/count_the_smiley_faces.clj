(ns count-the-smiley-faces)

;; )에만 \를 추가 해야하고 나머지는 없어도 됨
;; []안에 )가 있으면 \는 없어도 됨
(def smile-face #"[\:|\;][-|~]?[\)|D]")

(defn count-smileys [arr]
  (count (filter #(not-empty (re-find smile-face %)) arr)))

(count-smileys [":)"  ";("  ";}"  ":-D"])

;; 다른 사람 풀이
;; [] 안에 |는 없어도 된다.
(defn count-smileys2 [arr]
  ;return the total number of smiling faces in the array
  (count (filter #(re-find #"^[:;][-~]?[)D]" %) arr)))
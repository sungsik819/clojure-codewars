(ns sort-and-star)

;; 최종
;; array로 생성된 string을 sort하여 글자 사이마다 ***를 넣는 문제
(defn star-sort [arr]
  (apply str (interpose "***" (first (sort arr)))))

(star-sort ["bitcoin" "take" "over" "the" "world" "maybe" "who" "knows" "perhaps"])
;; => "b***i***t***c***o***i***n"
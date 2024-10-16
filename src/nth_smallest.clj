(ns nth-smallest)

;; 배열의 최소 크기는 3
;; 음수,양수, 0이 있음
;; 중복된 숫자는 삭제하지 말 것

(def arr [15,20,7,10,4,3])
(def n 3)

((vec (sort arr)) (dec n))
(ns reverse-or-rotate)

;; 문제 설명
;; chunk된 숫자가 2로 나누어지면 reverse
;; 그렇지 않으면 왼쪽으로 1번 회전을 한다.즉 앞의 숫자가 뒤로 가도록 한다.
;; 결과 값은 그 숫자들을 문자열로 합친 값을 반환 한다.

;; 최종

;; char collection rotate
(defn cc-rotate [cc]
  (apply str (flatten [(rest cc) (first cc)])))

;; char collection rotate 다른 방법
(defn cc-rotate2 [cc]
  (apply str (concat (rest cc) [(first cc)])))

;; char collection reverse 함수
(defn cc-reverse [cc]
  (apply str (reverse cc)))

;; char collection의 자리수 값 더하기
(defn sum-of-digits [cc]
  (apply + (map #(Character/getNumericValue %) cc)))

(defn solve [strng sz]
  (cond
    (= sz 0) ""
    (empty? strng) ""
    (< (count strng) sz) ""
    :else (apply str (map #(if (zero? (rem (sum-of-digits %) 2))
                             (cc-reverse %)
                             (cc-rotate %)) (partition sz strng)))))

;; 테스트
(comment
  (solve "123456987654", 6)
  (solve "", 8))
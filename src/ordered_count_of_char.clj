(ns ordered-count-of-char)

;; 문제 설명
;; 문자가 나타난 순서대로 갯수가 표시되어야 한다.

;; 최종
(defn solve [string]
  (mapcat vector (loop [v (seq string)
                        r (apply array-map (interleave (distinct (seq string)) (repeat 0)))]
                   (if (not (seq v)) r
                       (recur (rest v) (update-in r [(first v)] inc))))))

;; 풀이
;; 나타난 순서대로 표시하기 위해서 중복을 제거한 문자를 만든다
;; 0의 값을 갖는 array-map을 만들어 준다.
;; 문자가 나타난 갯수를 업데이트 한다.


;; 다른 사람 풀이
(defn ordered-count [string]
  (map (juxt identity (frequencies string)) (distinct string)))

(ordered-count "abracatabra")

;; 위 풀이는 아래 두가지의 각각 결과들이 합쳐진 값이다.
(map identity (distinct "abracatabra"))
(map (frequencies "abracatabra") (distinct "abracatabra"))
(ns kyu-7.find-the-vowels
  (:require [clojure.string :as string]))

(def word "Super")

;; 최종
;; lowercase 만들기
;; index를 가진 map으로 변환
;; 모음만 필터링
;; inc한 index만 가져온다.
(defn vowel-indices [word]
  (->> word
       (string/lower-case)
       (map-indexed vector)
       (filter #(re-seq #"[aeiouy]" (str (second %))))
       (map (comp inc first))))

;; 정규식을 사용하지 않는 방법
;; 밑에 풀이를 참고하여 정규식을 사용하지 않는 방법으로 변경
;; char를 검증하는 방법으로 변경할 경우, lowercase가 필요하지 않는다.
;; str로 변경하지 않아도 된다.
(def vowels #{\a \A \e \E \i \I \o \O \u \U \y \Y})

(->> word
     (map-indexed vector)
     (filter #(vowels (second %)))
     (map (comp inc first)))

;; 다른 사람 풀이
;; keep-indexed로 index를 알 수 있다.
;; map-indexed와 마찬가지로 (keep-indexed vector word)로 사용 가능
;; 차이라면 filter가 가능하다는 것이다.
(comment
  (def vowels #{\a \A \e \E \i \I \o \O \u \U \y \Y})


  (defn vowel-indices2
    [word]
    (keep-indexed #(when (vowels %2) (inc %1)) word)))
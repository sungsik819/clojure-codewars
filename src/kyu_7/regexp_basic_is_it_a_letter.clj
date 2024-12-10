(ns kyu-7.regexp-basic-is-it-a-letter)

(defn letter? [s]
  ((complement nil?) (re-matches #"[a-zA-Z]{1}" s)))


;; 다른 사람 풀이법
;; boolean으로 하면 true, false로 변환 됨
(defn letter1? [s]
  (boolean (re-matches #"[a-zA-Z]" s)))
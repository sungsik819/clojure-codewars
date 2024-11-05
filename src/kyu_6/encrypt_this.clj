(ns kyu-6.encrypt-this
  (:require [clojure.string :as string]))

;; 앞글자는 아스키 코드로
;; 나머지 문자의 첫째와 마지막 문자를 바꾼다.
(def text "in")

;; 최종
;; drop 했을때 빈 컬렉션이면 nil로 변환 한다.
;; switch 시 값이 1개면 하나만, 여러개면 변환하여 대입 한다.
(defn encrypt-text [text]
  (let [[f & r] text
        check-nil (seq (drop 1 r))
        r-switch (if (nil? check-nil) [(first r)]
                     (flatten [(last r) (drop-last (drop 1 r)) (first r)]))
        f-ascii (int f)]
    (apply str f-ascii r-switch)))

(defn encrypt-this [text]
  (string/join #" " (map encrypt-text
                         (string/split text #" "))))


;; 다른 사람 풀이
;; 처음, 두번째, 나머지로 구조분해 한다.
;; 나머지의 값이 없으면 nil이 된다.
;; butlast로 마지막을 지우되, 값이 하나면 nil을 리턴 한다.
(defn enc [st]
  (let [[f s & r] (map char st)]
    (str (int f) (last r) (string/join (butlast r)) s)))

(defn encrypt-this1 [text]
  (->> (string/split text #" ")
       (map enc)
       (string/join " ")))
(ns kyu-7.composing-squared-strings
  (:require [clojure.string :as string]))

(def s1 "byGt\nhTts\nRTFF\nCnnI")
(def s2 "jIRl\nViBu\nrWOb\nNkTB")

;; 풀이 과정
(string/split s1 #"\n")
(reverse (string/split s2 #"\n"))

(apply str (flatten [(take 1 "byGt")
                     (take 4 "NkTB")]))


(apply str (flatten [(take 2 "hTts")
                     (take 3 "rWOb")]))


;; 최종
(defn compose [s1 s2]
  (let [f (string/split s1 #"\n")
        s (reverse (string/split s2 #"\n"))
        c (+ 1 (count (f 0)))]
    (loop [r []
           fr f
           sr s
           fi 1
           si (dec c)]
      (if (= si 0) (string/join "\n" r)
          (recur (conj r (apply str (flatten [(take fi (first fr))
                                              (take si (first sr))])))
                 (rest fr)
                 (rest sr)
                 (inc fi)
                 (dec si))))))


;; 다른 사람 풀이법
;; take를 사용하여 str을 만드는 과정 보다는 subs를 사용하여 str을 만드는 과정이 단순한듯
(defn compose1 [s1 s2]
  (let [a2 (vec (reverse (string/split s2 #"\n")))
        l (count a2)
        a1 (map-indexed (fn [i itm] (str (subs itm 0 (inc i)) (subs (a2 i) 0 (- l i)))) (string/split s1 #"\n"))]
    (string/join "\n" a1)))
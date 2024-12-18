(ns kyu-7.composing-squared-strings
  (:require [clojure.string :as string]))

(def s1 "byGt\nhTts\nRTFF\nCnnI")
(def s2 "jIRl\nViBu\nrWOb\nNkTB")

;; 풀이 과ㅇ
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
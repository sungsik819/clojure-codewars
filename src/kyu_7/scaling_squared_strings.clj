(ns kyu-7.scaling-squared-strings
  (:require [clojure.string :as str]))

(def strng "abcd\nefgh\nijkl\nmnop")
(def k 2)
(def n 3)

(defn scale [strng k n]
  (if (seq strng)
    (let [n-char (fn [x] (apply str (flatten (map #(repeat k %) x))))
          n-strng (flatten (map #(repeat n %) (str/split strng #"\n")))]
      (str/join "\n" (map n-char n-strng)))
    ""))

;; 다른 사람 풀이법
(defn scale1 [s h v]
  (->> (str/split-lines s)
       (filter seq)
       (map (comp str/join (partial mapcat (partial repeat h))))
       (mapcat (partial repeat v))
       (str/join \newline)))
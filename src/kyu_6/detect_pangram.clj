(ns kyu-6.detect-pangram)

(def s "The quick brown fox jumps over the lazy dog.")

(defn pangram?
  [s]
  (<= 26 (count (set (re-seq #"[a-zA-Z]" s)))))

;; 다른 사람 풀이
(require 'clojure.string)
(require 'clojure.set)

(defn pangram1?
  [s]
  (clojure.set/subset?
   (set "abcdefghijklmnopqrstuvwxyz")
   (set (clojure.string/lower-case s))))
(ns kyu-7.simple-string-characters)

(defn solve [s]
  [(count (re-seq #"[A-Z]" s))
   (count (re-seq #"[a-z]" s))
   (count (re-seq #"[0-9]" s))
   (count (re-seq #"[\W]" s))])
(ns kyu-6.meeting
  (:require [clojure.string :as strg]))

(def s "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn")

(defn meeting [s]
  (->> (strg/split (strg/upper-case s) #";")
       (map #(reverse (re-seq #"\w+" %)))
       (sort-by (juxt first last))
       (map #(str "(" (strg/join ", " %) ")"))
       (strg/join "")))
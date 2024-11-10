(ns kyu-7.band-name-generator
  (:require [clojure.string :as string]))

(def noun "tart")

(defn generate-band-name [noun]
  (if (= (first noun) (first (reverse noun)))
    (string/capitalize (str noun (apply str (rest noun))))
    (str "The " (string/capitalize noun))))



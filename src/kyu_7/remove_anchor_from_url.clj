(ns kyu-7.remove-anchor-from-url
  (:require [clojure.string]))

(def url "https://codewars.com/katas/?page=1#about")

(defn remove-url-anchor [url]
  (first (re-find #"(http(s)?\:\/\/)?(\w+\.)?\w+\.\w+[\/\w+]*[\?\w+\=\d+]*" url)))

;; 다른 사람 풀이법
;; 내 풀이법은 너무 어렵게 생각 했나? 싶다
;; replace 정규식으로 #.*이면 빈값으로 만드는 방법을 사용 하였다.
(defn remove-url-anchor1 [url]
  (clojure.string/replace url #"#.*" ""))
(ns kyu-7.switcheroo)

(def xs "acb")

;; 최종
;; char로 분해 한다. -> 굳이 할 필요는 없는 것 같음
;; a일때는 b로 b 일때는 a로 바꾼다.
;; string으로 합친다.
(defn switcheroo [xs]
  (apply str (map #(cond
                     (= % \a) \b
                     (= % \b) \a
                     :else %) (seq xs))))

;; 다른 사람 풀이
;; string/replace를 사용한다.
;; hash-map을 사용하여 a는 b로 b는 a로 바뀔 수 있도록 지정 한다.
(defn switcheroo2 [xs]
  (clojure.string/replace xs #"a|b" {"a" "b" "b" "a"}))


;; case를 사용한다.
(defn switcheroo3 [xs]
  (->> xs
       (map #(case % \a \b \b \a %))
       (apply str)))
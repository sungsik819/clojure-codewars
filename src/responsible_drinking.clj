(ns responsible-drinking)

(def drink-string "1 shot, 5 beers, 2 shots, 1 glass of wine, 1 beer")

;; 최종
;; 숫자만 가져온다.
;; 숫자를 모두 합친다.
;; 1과 같으면 단수, 아니면 복수로 glass를 표시한다.
(defn hydrate [drink-string]
  (let [total (apply + (map #(Integer/valueOf %) (re-seq #"\d+" drink-string)))
        glass (if (= 1 total) "glass" "glasses")]
    (str total " " glass " of water")))
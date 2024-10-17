(ns printer-errors)

(def s "aaaxbbbbyyhwawiwjjjwwm")
(str (count (apply str (re-seq #"[n-z]+" s))) "/" (count s))

;; 한개씩 분리하여 표시하려면 아래와 같이 한다.
;; 아래와 같이할 경우 apply str은 필요 없음
(re-seq #"[n-z]" s)

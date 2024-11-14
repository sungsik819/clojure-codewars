(ns kyu-6.function-composition)

(defn compose [f g]
  (comp f g))

;; comp라는 함수를 제공 하여 쉽게 풀었지만
;; 원래는 아래 처럼 되어야 한다.
(defn compose1
  ([f g]
   (fn [& args]
     (f (apply g args))))

  ([f g & fs]
   (reduce compose1 (list* f g fs))))
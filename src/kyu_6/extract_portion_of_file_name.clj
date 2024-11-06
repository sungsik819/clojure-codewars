(ns kyu-6.extract-portion-of-file-name)

(def dirty-file-name "1_This_is_an_otherExample.mpg.OTHEREXTENSIONadasdassdassds34")

;; 최종
;; 위와 같은 형태의 파일을 정규식으로 파싱 한다.
(defn extract-file-name [dirty-file-name]
  (re-find #"[^\d+_][\w|\-]+\.\w+" dirty-file-name))
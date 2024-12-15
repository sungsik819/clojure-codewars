(ns kyu-7.all-inclusive)

;; 위치의 조합에 해당하는 값들이 있는가?
(def arr ["bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs"])
(def strng "bsjq")

(defn cc-rotate [cc]
  (apply str (flatten [(rest cc) (first cc)])))

(defn contain-all-rots [strng arr]
  (let [se (set arr)]
    (loop [s strng
           i 0]
      (if (= i (count strng)) true
          (if (contains? se s)
            (recur (cc-rotate s) (inc i))
            false)))))

;; 밑에 방법을 보고 cc-rotate를 사용하여 풀어본 추가적인 방법
(defn gen-rotations [s]
  (take (count s) (iterate cc-rotate s)))

(defn contain-all-rots1 [strng arr]
  (every? (set arr) (gen-rotations strng)))

;; 다른 사람 풀이법
;; rotate 방법
(defn rotate-s [s]
  (str (subs s 1) (subs s 0 1)))

;; iterate로 반복하여 문자열 갯수 만큼의 조합을 생성 한다.
(defn gen-rotations1 [s]
  (take (count s) (iterate rotate-s s)))

(defn contain-all-rots2 [strng arr]
  (every? (set arr) (gen-rotations1 strng)))
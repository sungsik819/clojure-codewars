(ns kyu-7.consecutive-items)

(def arr [1, 2, 3, 4, 5, 6, 7, 8, 9])
(def a 2)
(def b 3)

;; 최종
;; a,b에 해당하는 index를 구한다.
;; 둘중 큰값은 그대로 두고 작은 값을 하나 증가하여 같은지 비교 한다.
(defn consecutive [arr a b]
  (let [ai (.indexOf arr b)
        bi (.indexOf arr a)]
    (if (> bi ai) (= (inc ai) bi)
        (= (inc bi) ai))))

;; 다른 사람 풀이
(defn consecutive1 [arr a b]
  (boolean (some (set [[a b] [b a]]) (partition 2 1 arr))))

;; 위 함수 분해
(->>
 ;; [[1 2] [2 3] [3 4]]의 형태로 생성한다.
 (partition 2 1 arr)
 ;; [2 3] 또는 [3 2]를 가지는 set을 생성한다.
;; set으로 생성된 값이 하나라도 존재하면 그 값을 가져오도록 한다.
 (some (set [[a b] [b a]]))
 ;; 값이 있는 경우 true nil이면 false를 리턴한다.
 (boolean))


;; a,b의 index를 구하여 1과 같은지 검증 한다.(옆인 경우에는 index가 1차이가 있으므로)
;; 둘중 큰 값을 모르므로 절대값으로 계산 한다.
(defn consecutive2 [arr a b]
  (= 1 (Math/abs (- (.indexOf arr a) (.indexOf arr b)))))
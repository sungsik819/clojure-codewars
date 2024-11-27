(ns kyu-5.directions-reduction)

;; 좌표 최적화 하는 문제

;; 소멸되는 부분 찾기
;; NORTH -> SOUTH 또는 SOUTH -> NORTH이면 소멸된다.
;; EAST -> WEST 또는 WEST -> EAST이면 소멸된다.
(def remove-direction {"NORTH" "SOUTH"
                       "SOUTH" "NORTH"
                       "EAST" "WEST"
                       "WEST" "EAST"})

(def arr ["NORTH" "SOUTH" "SOUTH" "EAST" "WEST" "NORTH"])

;; acc에 있는 마지막 값이 소멸되는 값인지 체크하여 v와 같으면 acc의 마지막 값을 제거한다.
(defn dirReduc [arr]
  (seq (reduce (fn [acc v]
                 (if (= (remove-direction (last acc)) v)
                   (pop acc)
                   (conj acc v))) [] arr)))

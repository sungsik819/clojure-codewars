(ns kyu-6.tortoise-racing)

;; b가 a를 잡는데 걸리는 시간은?
;; a가 b 보다 느리다. a < b
;; a는 b보다 먼저 출발하고 g만큼 a가 앞서 있다.

(def v1 720)
(def v2 850)
(def g 70)

;; 속력이 /h이므로 시간은 hour 단위 이다.
(def hour (float (/ g (- v2 v1))))

(def t-hour (int hour))

;; 분단위로 변환하기 위해 60을 곱하고, 60에 대한 나머지 값을 가진다.
(def t-minute (int (rem (* hour 60) 60)))

;; 초단위를 분리하기 위해 3600을 곱하고 60에 대한 나머지 값을 갖는다.
(def t-second (int (rem (* hour 3600) 60)))

;; 결과
[t-hour t-minute t-second]

;; 최종
(defn race [v1 v2 g]
  (if (>= v1 v2) nil
      (let [hours (float (/ g (- v2 v1)))
            minutes (rem (* hours 60) 60)
            seconds (rem (* hours 3600) 60)]
        [(int hours) (int minutes) (int seconds)])))

(race 342 413 84)
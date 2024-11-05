(ns kyu-7.sum-of-odd-numbers)

;; sum of odd numbers
(+ (+ (+ 1 2) 4) 6)

(+ 1 (apply + (take (dec 4) (iterate #(+ % 2) 2))))

(defn start-number [n]
  (loop [i n r 1 d 2]
    (if (= i 1) r
        (recur (dec i) (+ r d) (+ d 2)))))

;; 트라이앵글 시작 값
(defn start-number2 [n]
  (+ 1 (apply + (take (dec n) (iterate #(+ % 2) 2)))))

;; 트라이 앵글 구성
(defn triangle [n]
  (let [s (start-number2 n)
        r (take (* n 2) (iterate inc s))]
    (take n (filter odd? r))))

(def row-num 3)
;; 트라이 앵글의 전체 합
(apply + (triangle row-num))


;; 결국에는 위 값들을 복잡하게 계산 할 필요 없이 세제곱으로 계산 된다.
;; 과정은 아래 참고
(* row-num row-num row-num)

;; 위 계산이 n^3이 되는 과정
;; The triangular number is the standard derivation of partial sums of the
;; natural numbers. These partial sums are used to index into the triangle.
;;
;; 1 + 2 + 3 + ... + n = (n(n+1))/2
;;
;; A similar derivation can be made for the partial sums of the odd numbers,
;; which we'll use to calculate the value of a row.
;;
;;  S = 1 + 3 + 5 + ... + n
;; 2S = 2(1 + 3 + 5 + ... + n)
;; 2S =  1      +  3     +  5     +  ...  +  n
;;     + (2n-1) + (2n-3) + (2n-5) +  ...  +  1
;;    = 2n + 2n + 2n + 2n + ... + 2n
;; 2S = n(2n)
;; 2S = 2n^2
;;  S = n^2
;;
;; We can subtract the partial sum of the entire triangle up to the row before
;; the one we're working with from the partial sum including that row, and this
;; will give us our answer.
;;
;; We can use triangular numbers to find the indices into the triangle and
;; calculate our partial sums.
;;
;; This gives us a final formula of:
;;
;; ((n(n+1))/2)^2 - ((n(n-1))/2)^2
;;
;; This equation can be simplified through the following steps:
;;
;; ((n^2 + n)/2)^2 - ((n^2 - n)/2)^2
;; ((n^2 + n)^2)/4 - ((n^2 - n)^2)/4
;; (n^4 + 2n^3 + n^2)/4 - (n^4 - 2n^3 + n^2)/4
;; (4n^3)/4
;; n^3
(ns kyu-7.easy-wallpaper)

(def numbers
  ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve","thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"])

(def l 6.3) ;; 가로
(def w 4.5) ;; 깊이
(def h 3.29) ;; 세로

(if (zero? (* h w l)) (numbers 0)
    (numbers (int (Math/ceil (/ (* (+ (* l h 2) (* w h 2)) 1.15) 5.2)))))
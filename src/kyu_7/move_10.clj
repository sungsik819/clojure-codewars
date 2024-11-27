(ns kyu-7.move-10)

(def st "testcase")

(defn move-ten [st]
  (apply str (map #(let [new-char (+ 10 (int %))]
                     (if (> new-char 122) (char (+ 96 (- new-char 122)))
                         (char new-char))) (seq st))))
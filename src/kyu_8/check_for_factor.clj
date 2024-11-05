(ns kyu-8.check-for-factor)

(defn check-for-factor [base factor]
  (zero? (mod base factor)))

(check-for-factor 24612 3)
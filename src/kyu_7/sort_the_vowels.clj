(ns kyu-7.sort-the-vowels)

(def s nil)

(def vowel #{\a \A \e \E \i \I \o \O \u \U})

(defn sort-vowels [s]
  (if (not (string? s)) ""
      (apply str (interpose "\n" (map #(if (vowel %)
                                         (str "|" %)
                                         (str % "|")) s)))))

(sort-vowels s)



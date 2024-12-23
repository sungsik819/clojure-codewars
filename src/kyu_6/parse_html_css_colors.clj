(ns kyu-6.parse-html-css-colors
  (:require [clojure.string :as string]))

(def preset-colors {"springgreen" "#00ff7f", "aqua" "#00ffff", "blue" "#0000ff", "olivedrab" "#6b8e23", "lightskyblue" "#87cefa", "greenyellow" "#adff2f", "ivory" "#fffff0", "navajowhite" "#ffdead", "cyan" "#00ffff", "mediumturquoise" "#48d1cc", "darkslateblue" "#483d8b", "lawngreen" "#7cfc00", "saddlebrown" "#8b4513", "white" "#ffffff", "silver" "#c0c0c0", "purple" "#800080", "gainsboro" "#dcdcdc", "plum" "#dda0dd", "midnightblue" "#191970", "magenta" "#ff00ff", "paleturquoise" "#afeeee", "hotpink" "#ff69b4", "mediumorchid" "#ba55d3", "gold" "#ffd700", "powderblue" "#b0e0e6", "papayawhip" "#ffefd5", "bisque" "#ffe4c4", "salmon" "#fa8072", "forestgreen" "#228b22", "blanchedalmond" "#ffebcd", "grey" "#808080", "crimson" "#dc143c", "darkturquoise" "#00ced1", "steelblue" "#4682b4", "mediumvioletred" "#c71585", "aquamarine" "#7fffd4", "darkgoldenrod" "#b8860b", "orange" "#ffa500", "darkgray" "#a9a9a9", "lime" "#00ff00", "cornflowerblue" "#6495ed", "aliceblue" "#f0f8ff", "lightgoldenrodyellow" "#fafad2", "lemonchiffon" "#fffacd", "lightsalmon" "#ffa07a", "deepskyblue" "#00bfff", "lightgreen" "#90ee90", "palegoldenrod" "#eee8aa", "darkred" "#8b0000", "violet" "#ee82ee", "gray" "#808080", "goldenrod" "#daa520", "darksalmon" "#e9967a", "skyblue" "#87ceeb", "darkviolet" "#9400d3", "fuchsia" "#ff00ff", "lightcoral" "#f08080", "moccasin" "#ffe4b5", "darkgreen" "#006400", "lightyellow" "#ffffe0", "lavenderblush" "#fff0f5", "sienna" "#a0522d", "burlywood" "#deb887", "ghostwhite" "#f8f8ff", "coral" "#ff7f50", "linen" "#faf0e6", "lightslategray" "#778899", "azure" "#f0ffff", "darkolivegreen" "#556b2f", "floralwhite" "#fffaf0", "yellow" "#ffff00", "beige" "#f5f5dc", "wheat" "#f5deb3", "slategray" "#708090", "darkmagenta" "#8b008b", "darkcyan" "#008b8b", "dodgerblue" "#1e90ff", "mediumseagreen" "#3cb371", "darkgrey" "#a9a9a9", "mediumblue" "#0000cd", "pink" "#ffc0cb", "mistyrose" "#ffe4e1", "teal" "#008080", "olive" "#808000", "navy" "#000080", "darkkhaki" "#bdb76b", "green" "#008000", "darkblue" "#00008b", "red" "#ff0000", "maroon" "#800000", "limegreen" "#32cd32", "brown" "#a52a2a", "seashell" "#fff5ee", "chocolate" "#d2691e", "antiquewhite" "#faebd7", "tan" "#d2b48c", "seagreen" "#2e8b57", "palevioletred" "#db7093", "rosybrown" "#bc8f8f", "cornsilk" "#fff8dc", "lavender" "#e6e6fa", "mediumpurple" "#9370db", "black" "#000000", "snow" "#fffafa", "lightseagreen" "#20b2aa", "palegreen" "#98fb98", "deeppink" "#ff1493", "dimgray" "#696969", "blueviolet" "#8a2be2", "cadetblue" "#5f9ea0", "slateblue" "#6a5acd", "mediumspringgreen" "#00fa9a", "lightpink" "#ffb6c1", "firebrick" "#b22222", "dimgrey" "#696969", "khaki" "#f0e68c", "royalblue" "#4169e1", "sandybrown" "#f4a460", "orangered" "#ff4500", "darkslategray" "#2f4f4f", "orchid" "#da70d6", "indianred" "#cd5c5c", "darkorchid" "#9932cc", "honeydew" "#f0fff0", "oldlace" "#fdf5e6", "whitesmoke" "#f5f5f5", "mediumaquamarine" "#66cdaa", "lightgrey" "#d3d3d3", "peru" "#cd853f", "chartreuse" "#7fff00", "lightcyan" "#e0ffff", "lightblue" "#add8e6", "tomato" "#ff6347", "mintcream" "#f5fffa", "peachpuff" "#ffdab9", "thistle" "#d8bfd8", "lightsteelblue" "#b0c4de", "mediumslateblue" "#7b68ee", "darkslategrey" "#2f4f4f", "turquoise" "#40e0d0", "slategrey" "#708090", "rebeccapurple" "#663399", "indigo" "#4b0082", "lightslategrey" "#778899", "darkorange" "#ff8c00", "yellowgreen" "#9acd32", "lightgray" "#d3d3d3", "darkseagreen" "#8fbc8f"})

;; 6자리 hex를 decimal로 변환
;; 2자리씩 나누기
;; 변환

;; 3자리인 hex를 6자리로 변환
;; preset에서 선택된 6자리 hex를 decimal로 변환

(def color "#3B7")

;; 6자리 hex를 decimal로 변환
(defn convert-color-hex-to-decimal [color]
  (let [digits-2 (re-seq #"[A-Fa-f0-9]{2}" color)
        decimal (map #(read-string (str "0x" %)) digits-2)]
    {:r (first decimal)
     :g (second decimal)
     :b (last decimal)}))

;; 3자리 hex를 decimal로 변환
(->> (map str (rest color) (rest color))
     (apply str)
     (str "#")
     (convert-color-hex-to-decimal))

(defn parse-html-color [color]
  (cond
    (re-find #"\#[A-Fa-f0-9]{6}" color) (convert-color-hex-to-decimal color)
    (re-find #"\#[A-Fa-f0-9]{3}" color) (->> (map str (rest color) (rest color))
                                             (apply str)
                                             (str "#")
                                             (convert-color-hex-to-decimal))
    :else (->> (get preset-colors (string/lower-case color))
               convert-color-hex-to-decimal)))

(parse-html-color "#80FFA0")
(parse-html-color "#3B7")
(parse-html-color "LimeGreen")


;; 다른 사람 풀이
(defn hex-color [possibly-color-name]
  "Expects color name and returns its hex representation, otherwise garbage-in, garbage-out"
  (get preset-colors (string/lower-case possibly-color-name) possibly-color-name))

(defn hex3->hex6 [hex]
  (let [rgb-char-list (rest hex)]
    (if (= (count rgb-char-list) 3)
      (str "#" (string/join (interleave rgb-char-list rgb-char-list)))
      hex)))

(defn hex->rgb [hex]
  (let [color (java.awt.Color/decode (hex3->hex6 hex))]
    {:r (. color getRed)
     :g (. color getGreen)
     :b (. color getBlue)}))

(defn parse-html-color1 [col]
  (hex->rgb (hex-color col)))
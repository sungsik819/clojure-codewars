(ns kyu-8.grasshopper-terminal-game-move-function)

(def position 3)
(def roll 6)

(defn move [position roll]
  (+ position (* 2 roll)))
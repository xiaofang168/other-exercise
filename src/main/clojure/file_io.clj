(defn readFile [path]
  (def s (slurp path))
  (println s))

(defn writeFile [path]
  (spit path "真好\n" :append true))

(readFile "/Users/fangjie/github/other-exercise/src/main/clojure/macro_test.clj")

(writeFile "/Users/fangjie/Downloads/aa.txt")
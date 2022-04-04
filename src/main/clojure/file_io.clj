(defn readFile [path]
  (def s (slurp path))
  (println s))

(defn writeFile [path]
  (spit path "真好\n" :append true))

(readFile "/Users/fangjie/github/other-exercise/src/main/clojure/macro_test.clj")

(writeFile "/Users/fangjie/Downloads/aa.txt")

;; 管道过程中一个函数的话括号可以省略
(->> "/Users/didi/gc_logs"
     clojure.java.io/file
     file-seq
     (mapv str))

;; doseq是副作用函数，总是返回nil
(doseq [n (->> "/Users/didi/gc_logs"
               (clojure.java.io/file)
               (file-seq)
               (mapv str))]
              (println n))

;; Use the Path utilities to do glob filtering.
(let [grammar-matcher (.getPathMatcher
                        (java.nio.file.FileSystems/getDefault)
                        "glob:*.{zip}")]
     (->> "/Users/didi/dev-tools"
          clojure.java.io/file
          file-seq
          (filter #(.isFile %))
          (filter #(.matches grammar-matcher (.getFileName (.toPath %))))
          (mapv #(.getAbsolutePath %))))
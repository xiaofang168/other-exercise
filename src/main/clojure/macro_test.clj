; 宏编译器从字面上传递Clojure代码，对参数进行替换，不求值
(defmacro assert-equals [actual expected]
			(= expected actual))

(println (assert-equals 2 2))

(println (assert-equals (inc 5) 6))

(def x 1)

(println (assert-equals (+ x 2) 3))


(defmacro assert-equals [actual expected] (list '= expected actual))

(println (assert-equals (inc 5) 6))

; 输出宏替换，即要执行的程序代码
(println (macroexpand '(assert-equals (inc 5) 6)))

(println (= 6 (inc 5)))
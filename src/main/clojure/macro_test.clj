; 并且编写宏的第一条诫命是：如果函数足够，请不要编写宏
; 宏编译器从字面上传递Clojure代码，对参数进行替换，不求值，替换发生在编译期，宏在运行时不存在

(defmacro assert-equals [actual expected]
          (= expected actual))

; true
(println (assert-equals 2 2))

; false
(println (assert-equals (inc 5) 6))

(def x 1)

; false
(println (assert-equals (+ x 2) 3))

; 添加额外的引号（ '= ），以便将=解释为原始符号，而不是函数引用
; 函数和宏都接受数据，但是在宏的情况下，更常见的是使用列表之类的数据结构来表示Clojure源
(defmacro assert-equals [actual expected] (list '= expected actual))

; true
(println (assert-equals (inc 5) 6))

; 输出宏替换，即要执行的程序代码
; 在调试宏时， macroexpand和macroexpand-1选择的武器，优先选择macroexpand-1，因为系统自带一些宏(defn)不需要了解
(println (macroexpand '(assert-equals (inc 5) 6)))
(println (macroexpand-1 '(assert-equals (inc 5) 6)))

; true
(println (= 6 (inc 5)))

; 以下两个函数是等效的
(defmacro assert-equals [actual expected]
          (list 'when-not (list '= actual expected)
                (list 'throw
                      (list 'AssertionError.
                            (list 'str "Expected " expected " but was " actual)))))

; (when-not (= (inc 5) 6) (throw (AssertionError. (str Expected  6  but was  (inc 5)))))
(println (macroexpand-1 '(assert-equals (inc 5) 6)))

; `完成所有引用，~取消部分引用
; syntax quoting会让代码更加简洁
; syntax quoting会返回fully qualified symbol，所以使用syntax quoting能够让我们避免命名冲突
(defmacro assert-equals [actual expected]
          `(when-not (= ~actual ~expected)
                     (throw
                       (AssertionError.
                         (str "Expected " ~expected " but was " ~actual)))))

; 用macroexpand-1来查看宏在编译过程中如何扩展
; macroexpand也可以工作，但是由于when-not也是一个宏（！），它将被递归扩展，从而使输出混乱
(assert-equals 5 5)
(println (macroexpand-1 '(assert-equals (inc 5) 7)))

(defmacro my-plus
          "Another plus for a + b"
          [args]
          (list (second args) (first args) (last args)))

(macroexpand-1 '(my-plus (1 + 1)))
(my-plus (1 + 1))

; 'Simple Quoting和`Syntax Quoting的区别
(defmacro my-print
          [expression]
          (list 'let ['result expression]
                (list 'println 'result)
                'result))

; #不能去掉gensym宏内部使用的符号
(defmacro my-print2
          [expression]
          `(let [result# ~expression]
                (println result#)
                result#))

;; 推荐使用管道方式更容易理解
(reduce + (map #(* 2 %) (filter odd? (range 1 20))))

;; 同上结果一样使用管道方式
(defn pipeline
      [x]
      (->> x (range 1)
           (filter odd?)
           (map #(* 2 %))
           (reduce +)))

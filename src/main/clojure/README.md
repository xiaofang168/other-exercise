# clojure安装
brew install leiningen

# clojure终端
- 进入交互模式：lein repl
- 查看函数或宏文档：(doc when) (doc first)
- 查看类型(class 11) (type 11)

# 类库
类似于python的安装
- Leiningen创建项目：http://wiki.fnil.net/index.php?title=Leiningen教程中文版
- https://www.clojure-toolbox.com/
- https://clojuredocs.org/

# 学习资料
- https://github.com/linpengcheng/PurefunctionPipelineDataflow/blob/master/Readme_Chinese.md
- http://clojure-doc.org/
- https://clojure.org/guides/learn/syntax#_symbols_and_idents
- https://www.tutorialspoint.com/clojure/clojure_basic_syntax.htm
- https://www.bookstack.cn/read/clojure-learning-notes/README.md

# 一些语法
Anonymous function syntax
There is a shorter form for the fn anonymous function syntax implemented in the Clojure reader: #(). 
This syntax omits the parameter list and names parameters based on their position.

- % is used for a single parameter
- %1, %2, %3, etc are used for multiple parameters
- %& is used for any remaining (variadic) parameters

```clojure
;; Equivalent to: (fn [x] (+ 6 x))
#(+ 6 %)

;; Equivalent to: (fn [x y] (+ x y))
#(+ %1 %2)

;; Equivalent to: (fn [x y & zs] (println x y zs))
#(println %1 %2 %&)
```






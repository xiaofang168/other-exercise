# use haskell stack
1、stack ghci
2、:load Test
3、main

# install package
1、cabal install split
2、stack install split

# list the installed packages
cabal list --installed
ghc-pkg list

# 语法
- ::
  
  > 读作“它的类型为”。凡是明确的类型，其首字母必为大写。
  
- \>>= 
	
	> 接受一个 monadic value（也就是具有 context 的值，可以用装有普通值的盒子来比喻）并且把它喂给一个接受普通值的函数，并回传一个 monadic value，也就是拆箱（return装箱）。
	>
	> `=<<` 和上面 `>>=` 功能一样，只是结合顺序相反

# 注释
```
-- 单行注释

{-
 多行注释
-}
```

# run
- 方式1:runghc joinCookies.hs
- 方式1:stack runhaskell joinCookies.hs
- 方式3:
1、stack ghci
2、:load file
3、main

# 命令
- :t 查看类型
- :i Maybe 查看源码信息

# 控制台输入
 :{ // 开始
 :} // 结束


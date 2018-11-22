# use haskell stack
1、stack ghci
2、:load Test
3、main

＃ install package
1、cabal install split
2、stack install split

# list the installed packages
cabal list --installed
ghc-pkg list

# run
方式1:runghc joinCookies.hs
方式1:stack runhaskell joinCookies.hs
方式3:
1、stack ghci
2、:load file
3、main

# 查看类型
:t

# 控制台输入
 :{ // 开始
 :} // 结束


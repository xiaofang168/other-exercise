module Main where
import Data.Char (toUpper)
main :: IO ()
-- 定义函数类型
toUpperCase :: String -> String
-- 函数绑定
toUpperCase = map toUpper
-- main = putStrLn "input something" >>= (\_ -> getLine) >>= putStrLn . toUpperCase
-- main = putStrLn "input something" >> getLine >>= putStrLn . toUpperCase

{-
>>= 接受一个 monadic value（也就是具有 context 的值，可以用装有普通值的盒子来比喻）
并且把它喂给一个接受普通值的函数，并回传一个 monadic value。
-}
main = getLine >>= putStrLn . toUpperCase
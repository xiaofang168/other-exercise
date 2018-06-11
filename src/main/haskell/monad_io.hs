module Main where
import Data.Char (toUpper)
main :: IO ()
toUpperCase :: String -> String
toUpperCase = map toUpper
-- main = putStrLn "input something" >>= (\_ -> getLine) >>= putStrLn . toUpperCase
-- main = putStrLn "input something" >> getLine >>= putStrLn . toUpperCase

main = getLine >>= putStrLn . toUpperCase
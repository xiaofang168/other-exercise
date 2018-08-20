import Data.List.Split
import Data.List
main::IO()

main =  getLine >>= putStrLn . joinChar . withArray . splitChar
    where unionArray input = "'"++ (input!!0) ++ "'" ++ ":" ++ "'" ++ (input!!1) ++ "'"
          withChar str = unionArray (splitOn "=" str)
          withArray input = map withChar input
          joinChar input = intercalate "," input
          splitChar str = splitOn ";" str
    
    
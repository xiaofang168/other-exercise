import Data.List.Split

main::IO()
-- readLines = fmap lines . readFile
-- main = do
    -- putStrLn(show(length (splitOn " " "asdf adfss")))
    -- contents <- readFile "p2p.txt"
    -- let ls = lines contents
    -- mapM_ putStrLn ls
    -- let numberStrArray = map (\x -> (splitOn " " x)!!1) ls
    -- let numberArray = map (\x -> read x :: Integer ) numberStrArray
    -- let s =sum(numberArray)
    -- print((show . sum . map (\x -> read x :: Integer ) . map (\x -> (splitOn " " x)!!1)) ls)
    -- print $ show . sum . map (\x -> read x :: Integer ) . map (\x -> (splitOn " " x)!!1) $ lines contents


-- main = readFile "p2p.txt" >>= (\inpStr -> putStrLn(((show . sum . map (\x -> read x :: Integer ) . map (\x -> (splitOn " " x)!!1)) (lines inpStr))))

main = readFile "p2p.txt" >>= (\inpStr -> (putStrLn . show . sum . map (\x -> read x :: Integer ) . map (\x -> (splitOn " " x)!!1)) (lines inpStr))
    
    
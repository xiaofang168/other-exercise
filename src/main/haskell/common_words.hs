import Data.Char

words2 :: [Char]->[[Char]]
words2 x = ["a"]

sortWords :: [[Char]]->[[Char]]
sortWords x = ["a"]

countRuns :: [[Char]] -> [(Int,[Char])]
countRuns x = [(2,"be")]

sortRuns :: [(Int,[Char])] -> [(Int,[Char])]
sortRuns x = [(2,"be")]

showRun :: (Int,[Char]) -> String
showRun x = "2 a"

commonWords :: Int -> [Char]->[Char]
commonWords n = concat . map showRun . take n . sortRuns . countRuns . sortWords . words2 . map toLower

commonWords2 :: (Int, [Char]) -> [Char]
commonWords2 (n,s) = (concat . map showRun . take n . sortRuns . countRuns . sortWords . words2 . map toLower) s
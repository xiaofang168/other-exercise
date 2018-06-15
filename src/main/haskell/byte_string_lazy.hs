import qualified Data.ByteString.Lazy as L
main::IO()
hasElfMagic :: L.ByteString -> Bool
hasElfMagic content = L.take 4 content == elfMagic
    where elfMagic = L.pack [0x7f, 0x45, 0x4c, 0x46]

isElfFile :: FilePath -> IO Bool
isElfFile path = do
      content <- L.readFile path
      return (hasElfMagic content)
{-
main = do
    b <- isElfFile "p2p.txt"
    let a = b
    putStrLn (show a)
    putStrLn(">>")
-}

main = isElfFile "p2p.txt" >>= putStrLn . show
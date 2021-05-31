{-# LANGUAGE FlexibleInstances #-}
-- 代数数据类型ADT
data Exp = Lit Int | Add Exp Exp
eval :: Exp -> Int
eval (Lit n) = n
eval (Add a b) = eval a + eval b

toString :: Exp -> String 
toString (Lit i) = show i
toString (Add l r) = "(" ++ toString l ++ "+" ++ toString r  ++ ")"
{-
class Visitor a where
  lit :: Int -> a
  add :: a -> a -> a
  

instance Visitor Int where
  lit = id
  add = (+)

instance Visitor String where
  lit = show
  add a b = "(" ++ a ++ " + " ++ b ++ ")"
  
constructAst :: Visitor a => a
constructAst = add (lit 114) (lit 514)
-}

class Something a where
  doSomething :: a -> Integer

instance Something Integer where
  doSomething x = 1

instance Something Char where
  doSomething x = 2

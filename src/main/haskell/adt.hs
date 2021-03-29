-- 定义数据类型 ADT(代数数据类型)
-- 如果在ghci里直接输入Circle 1 2 3是无法正常显示的，要想显示，必须成为Show的实例，只需要使用deriving
data Shape = Circle Float Float Float | Rectangle Float Float Float Float deriving (Show)

-- 取值简化版
data Shape2 = Circle2 {rx :: Float, ry :: Float, r :: Float} | Rectangle2 Float Float Float Float
    deriving (Show)

-- 使用数据类型
area :: Shape -> Float
area (Circle _ _ r) = pi * r * r
area (Rectangle x1 y1 x2 y2) = (abs $ x2 - x1) * (abs $ y2 - y1)
-- 代数
mrx (Circle x _ _ ) = x
mry (Circle _ y _ ) = y
mr (Circle _ _ vr ) = vr

main = do
    let a = area (Rectangle 1 2 3 4)
    let b = area (Circle 1 2 3)
    print a
    print b
    -- 取代数的值
    let c = (Circle 1 2 3)
    print (mrx c)
    let d = (Circle2 1 2 3)
    print (rx d)
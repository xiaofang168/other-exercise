-- 让新类型成为类型类(Type class)的实例，此时这种新类型必然无法使用==判断是否相等，因为==不知道何为相等，
data TrafficLight = Red | Yellow | Green

-- 需要告诉==何为相等，告诉的过程就是新类型成为Eq实例的过程
instance Eq TrafficLight where
  Red == Red = True
  Yellow == Yellow = True
  Green == Green = True
  _ == _ = False

main = do
    print (Red == Red)
    print (Red == Yellow)
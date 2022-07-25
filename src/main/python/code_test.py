# coding=UTF-8
# 字符编码设置

# 字符串格式化 %-formatting(最早 Python 的格式化字串)
# %-formatting、str-format（Python 2.6+）、f-string （Python 3.6+）
str = r"%s-%s.jpg" % (2,4)
print(str)

temp = "I am {first_name} {middle_name}. {last_name}".format(
     first_name='li',
     middle_name='shi',
     last_name='min'
)
print(temp)

# 字符串连接f-string
name = "Django"
age = 4
print(f'My name is {name} and I am {age} years old')

fresh_fruit = {
    'apple': 10,
    'banana': 8,
    'lemon': 5,
}

# :=海象运算符
if (count := fresh_fruit.get('lemon', 0)) >=5:
	print(count)

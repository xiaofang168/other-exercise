# coding=UTF-8
# 导入easyocr
import easyocr
# 创建reader对象
reader = easyocr.Reader(['ch_sim','en']) 
# 读取图像
result = reader.readtext('/Users//Downloads/费曼技巧.jpeg')
print(result)
# 结果不如百度飞桨paddleocr
for i in result:
	word = i[1]
	print(word)
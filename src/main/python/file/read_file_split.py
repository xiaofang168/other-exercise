import re

with open('dk.txt', encoding="utf-8") as f:
	for line in f:
		# 正则表达式空格分隔
		data = re.split('\\s+', line.rstrip(), 2)

		# f格式化字符串
		print(f"{data[1]}, {data[2]}")
f.close()
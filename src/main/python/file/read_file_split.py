with open('dk.txt', encoding="utf-8") as f:
	for line in f:
		# 空格分隔
		source = line.split()
		# f格式化字符串
		print(f"{source[1]}")
f.close()
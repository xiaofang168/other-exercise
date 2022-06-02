import re
import json

m = {}
with open('header.txt', encoding="utf-8") as f:
	for line in f:
		# 正则表达式空格分隔
		data = re.split(': ', line.rstrip())
		m[data[0]]=data[1]
f.close()
# indent正数格式化
json_str = json.dumps(m, indent=4)
print(json_str)
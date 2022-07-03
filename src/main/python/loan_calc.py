# -*- coding: utf-8 -*-
import numpy as np
import pandas as pd
import datetime
from dateutil.relativedelta import relativedelta
#from IPython.display import display, Markdown

# 等额本息每月还款
"""
d贷款日期
c本金;
r年利率;
r/12为月利率;
m月份
"""
d="2016-09-15"
c = 710000
r=0.04655
m=360
mhk = (c*r/12*(1+r/12)**m)/((1+r/12)**m-1)
#print(mhk);
# 还款总额
#total = mhk*m
#print(total)

def p(d,c,r,m):
	# 表头
	col = ['年份','周期','本金','每月还本息','每月还本金','每月还利息','剩余本金','累计还利息','累计还本金']
	dt = datetime.datetime.strptime(d, '%Y-%m-%d')
	df = pd.DataFrame([[0 for i in range(9)] for j in range(m+1)],index = list(range(m+1)),columns=col)
	df.iloc[0,2] = c
	df.iloc[:,3] = (c*r/12*(1+r/12)**m)/((1+r/12)**m-1)
	# 已还利息总和
	interest_sum=0
	# 已还本金总和
	principal_sum=0
	i = 0
	for i in range(m):
		j = i +1
		lixi = df.iloc[i,2]*(r/12)
		df.iloc[i,0] = (dt+relativedelta(months=i+1)).strftime("%Y-%m-%d")
		df.iloc[i,1] = "第{y}年第{m}个月".format(y=int((i)/12)+1,m=i%12+1)
		df.iloc[i,5] = lixi
		df.iloc[i,4] = df.iloc[i,3] - df.iloc[i,5]
		df.iloc[i,6] = df.iloc[i,2] - df.iloc[i,4]
		df.iloc[j,2] = df.iloc[i,6]
		df.iloc[i,7] = interest_sum+lixi
		df.iloc[i,8] = principal_sum+df.iloc[i,4]
		interest_sum = df.iloc[i,7]
		principal_sum = df.iloc[i,8]
		i += 1
	df1 = df.iloc[0:m,:].round(2)
	df1.index = range(1,m+1)
	return df1

df = p(d,c,r,m)
pd.set_option('display.max_rows', None)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_colwidth', None)
pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)

#print(df)
#display(df)
#print(df.to_html())
#print(df.to_string(index=False))
print(df.to_markdown())
# 输出excel
#df.to_csv('loan_house.csv', sep=',', encoding='utf-8',index=False)
df.to_excel('loan_house.xlsx',index=False)

# -*- coding: utf-8 -*-
import numpy as np
import pandas as pd
#from IPython.display import display, Markdown

# c本金;r年利率;r/12为月利率;m月份
# 等额本息每月还款
c = 710000
r=0.04655
m=360
mhk = (c*r/12*(1+r/12)**m)/((1+r/12)**m-1)
#print(mhk);
# 还款总额
#total = mhk*m
#print(total)

def p(c,r,m):
	#表头
	col = ['本金','每月应还本息','应还本金','应还利息','剩余本金']
	df = pd.DataFrame([[0 for i in range(5)] for j in range(m+1)],index = list(range(m+1)),columns=col)
	df.iloc[0,0] = c
	df.iloc[:,1] = (c*r/12*(1+r/12)**m)/((1+r/12)**m-1)
	i = 0
	for i in range(m):
		j = i +1
		lixi = df.iloc[i,0]*(r/12)
		df.iloc[i,3] = lixi
		df.iloc[i,2] = df.iloc[i,1] - df.iloc[i,3]
		df.iloc[i,4] = df.iloc[i,0] - df.iloc[i,2]
		df.iloc[j,0] = df.iloc[i,4]
		i += 1
	df1 = df.iloc[0:m,:].round(2)
	df1.index = range(1,m+1)
	return df1

df = p(c=c,r=r,m=m)
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

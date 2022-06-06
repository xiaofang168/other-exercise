# -*- coding: utf-8 -*-
import pandas as pd  
from pandasql import sqldf

pd.set_option('display.max_columns',10) #a就是你要设置显示的最大列数参数
pd.set_option('display.max_rows',10) #b就是你要设置显示的最大的行数参数
pd.set_option('display.width',800) #x就是你要设置的显示的宽度，防止轻易换行

pysqldf = lambda q: sqldf(q, globals())

df1 = pd.read_excel("test_new.xlsx",sheet_name ="业务和系统指标梳理")
#print(df1)

query1 = """
	select * from df1 t where t.参与盯盘负责人='丁忠燊'
"""

result = pysqldf(query1)

#print(type(result))

print(result)

# DataFrame对象写入Excel
result.to_excel("result.xlsx")
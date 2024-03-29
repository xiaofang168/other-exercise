# -*- coding: utf-8 -*-
import pandas as pd  
from pandasql import sqldf
from pyecharts.charts import Bar, Grid, Page
from pyecharts import options as opts
from pyecharts.globals import ThemeType

page = Page(layout=Page.DraggablePageLayout,interval = 10)

pd.set_option('display.max_columns',10) #a就是你要设置显示的最大列数参数
pd.set_option('display.max_rows',100) #b就是你要设置显示的最大的行数参数
pd.set_option('display.width',800) #x就是你要设置的显示的宽度，防止轻易换行

pysqldf = lambda q: sqldf(q, globals())

df1 = pd.read_excel("test_new.xlsx",sheet_name ="业务和系统指标梳理")
#print(df1)

query1 = """
	select count(*) as task_count, t.参与盯盘负责人 as realname 
	from  df1 t 
	where realname is not null
	group by t.参与盯盘负责人
	order by task_count asc
"""

query2 = """select count(*) as project_count,r.realname from(
	select t.模块系统 as project, t.参与盯盘负责人 as realname 
	from  df1 t 
	where realname is not null
	group by t.模块系统,t.参与盯盘负责人) 
	as r 
	group by r.realname
	order by project_count
"""

result = pysqldf(query1)

result2 = pysqldf(query2)

#print(type(result))

#print(result2)

#print(result['task_count'].tolist())

#print(result['realname'].tolist())

# DataFrame对象写入Excel
#result.to_excel("result.xlsx")

# grid X轴标签太长被截断的解决方案
grid = Grid(init_opts=opts.InitOpts(animation_opts=opts.AnimationOpts(animation_delay=1000, animation_easing="elasticOut"),
	width="1500px",
	height="1000px",
	theme=ThemeType.LIGHT,
	page_title="巡检任务"))

bar = (
    Bar()
    .add_xaxis(result['realname'].tolist())
    .add_yaxis("巡检指标数", result['task_count'].tolist())
    .set_global_opts(title_opts=opts.TitleOpts(title="巡检指标分布", pos_top='5%'),
    	xaxis_opts=opts.AxisOpts(axislabel_opts={"rotate":45,"interval":"0"},is_show=True),
    	legend_opts=opts.LegendOpts(pos_left="25%"))
    # 或者直接使用字典参数
    # .set_global_opts(title_opts={"text": "主标题", "subtext": "副标题"})
)

bar2 = (
    Bar()
    .add_xaxis(result2['realname'].tolist())
    .add_yaxis("巡检模块数", result2['project_count'].tolist())
    .set_global_opts(title_opts=opts.TitleOpts(title="巡检模块分布",pos_top='60%'),
    	xaxis_opts=opts.AxisOpts(axislabel_opts={"rotate":45,"interval":"0"},is_show=True),
    	legend_opts=opts.LegendOpts(pos_left="25%",pos_top='60%'))
    # 或者直接使用字典参数
    # .set_global_opts(title_opts={"text": "主标题", "subtext": "副标题"})
)
#bar.set_series_opts(itemstyle_opts=opts.ItemStyleOpts(color='#99ccff'),label_opts=opts.LabelOpts(is_show=True))

# 并行排列
#grid.add(bar, grid_opts=opts.GridOpts(pos_right="55%",pos_bottom=120))
#grid.add(bar2, grid_opts=opts.GridOpts(pos_left="55%",pos_bottom=120))

# 垂直排列
grid.add(bar, grid_opts=opts.GridOpts(pos_bottom="60%"))
grid.add(bar2, grid_opts=opts.GridOpts(pos_top="60%",pos_bottom="120"))
page.add(grid)
grid.render("test.html")
# 说明
- 适用各种智能化处理
- 当作伪代码来读

# 在线教程
- https://docs.python.org/zh-cn/3/tutorial/index.html

# 使用scrapy爬取开源中国个人收藏夹


> **Note**: 使用了**‘css selector’**，**‘xpath’**，**’urlparse‘处理url参数**，文件写入等技术。


* cookie获取
> 登录网站拷贝浏览器中的cookie字符串，然后使用<code>CookieTrans</code>处理生成scrapy所需要的cookies


# 运行命令
- 避免框架 info debug 日志输出，使用scrapy runspider OSChinaCollSpider.py **-L WARNING**
- 查看版本python -v 或python3 -v (mac中自带python2和python3)
- pip指定版本安装 pip install package_name==1.1.2
- 库的批量安装pip install -r requirements.txt
- 卸载 pip uninstall package_name
- 输出当前环境中所有已安装的包 pip3 freeze  列出非全局安装的软件包，使用 -l/--local
- 查看库信息 pip show -f package_name
- 查看需要升级的库 pip list -o
- 检查兼容性问题 pip check package-name
- 将库下载到本地 pip download PyYAML  -d "/tmp/"

# python内置命令
- 替换telnet：python3 -m telnetlib -d www.baidu.com 443
- 启动web：python3 -m http.server（可以共享当前目录下的资源文件、充当nginx、openresty web服务器）

# 在线安装package
- https://pypi.org/
- pip/pip3 install imageio (pip默认为python2)

# 在线功能
- 搜索python常用函数
- 搜索Python图像PIL设计和GIF动图 pip3 install imageio，mac中可以删除动态中不需要的图
- python >= 3.8 验证码识别 pip install ddddocr
- 生成报表图如echarts
- 七个实用的Python自动化代码，别再重复造轮子了
- pip install moviepy 视频转换gif图
- pandas matplotlib 画图
- [Python这些操作，逆天且实用！]([https://developer.51cto.com/article/709153.html?utm_source=tuicool&utm_medium=referral])
	- 显示WiFi密码
	- 视频转GIF
	- 文本转PDF
	- 生成二维码
	- 提取音频
- [Python装饰器模式](https://www.jdon.com/60619)

# 功能说明
- 截屏为图片screenshot.py
- 录制屏幕gift图make.gift.py
- 给图片增加水印 img_add_watermark.py
- 去除图片水印OpenCV、cv2、numpy
- 去除背景水印remove_bg_woatermark.py
- 增加制定位置的透明水印transparence_watermark.py
- 显示windows wifi密码 show_wifi_password.py
- 生成二维码gen_qrcode.py
- 生成外网短链接gen_shorturl.py(tinyurl.com)
- sql查询excle数据sql_excel.py（可以使用pandas、xlwings、openpyxl等包来对Excel进行增删改查、格式调整等操作，甚至可以使用Python函数来对excel数据进行分析）
- 页面转图片html_image.py
- sql统计excel中的数据然后输出报表sql_excel.py


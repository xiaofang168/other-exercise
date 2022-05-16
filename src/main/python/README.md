# 说明
适用各种智能化处理

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

# 在线安装package
- https://pypi.org/
- pip/pip3 install imageio (pip默认为python2)

# 在线功能
- 搜索python常用函数
- 搜索Python图像PIL设计和GIF动图 pip3 install imageio，mac中可以删除动态中不需要的图
- python >= 3.8 验证码识别 pip install ddddocr
- 生成报表图如echarts
- 七个实用的Python自动化代码，别再重复造轮子了

# 功能说明
- 截屏为图片screenshot.py
- 录制屏幕gift图make.gift.py
- 给图片增加水印 img_add_watermark.py


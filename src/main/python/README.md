# 使用scrapy爬取开源中国个人收藏夹


> **Note**: 使用了**‘css selector’**，**‘xpath’**，**’urlparse‘处理url参数**，文件写入等技术。


* cookie获取
> 登录网站拷贝浏览器中的cookie字符串，然后使用<code>CookieTrans</code>处理生成scrapy所需要的cookies




* 运行命令
> 避免框架 info debug 日志输出，使用scrapy runspider OSChinaCollSpider.py **-L WARNING**




# coding=UTF-8
from selenium import webdriver
# 加载谷歌浏览器驱动

driver = webdriver.Chrome()

# 打开百度搜索网址首页
driver.get('http://www.baidu.com')
print(driver.title)
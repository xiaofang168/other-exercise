# coding=UTF-8
from time import sleep
from PIL import ImageGrab
# 截屏时间1分钟
m = 1 * 60
n = 1
while n < m:
    sleep(0.02)
    im = ImageGrab.grab()
    im = im.convert('RGB')
    local = (r"%s.jpg" % (n))
    im.save(local, 'jpeg')
    n = n + 1

print("截屏结束...")
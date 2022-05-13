# coding=UTF-8
import imageio
from PIL import Image
from time import sleep
from PIL import ImageGrab

images = []

# 截屏时间10秒
m = 10
n = 2
while n < m:
	sleep(0.02)
	im = ImageGrab.grab()
	images.append(im)
	n = n + 1

print("录制屏幕生成gift图结束...")
imageio.mimsave("screenshot.gif",images,fps=1)
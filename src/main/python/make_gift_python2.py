# coding=UTF-8
from PIL import Image
from time import sleep
from PIL import ImageGrab

images = []
dest = Image.open("1.jpg")
# images.append(Image.open('2.jpg'))
# images.append(Image.open('3.jpg'))

# 截屏时间10秒
m = 10
n = 2
while n < m:
	sleep(0.02)
	local = (r"%s.jpg" % (n))
	print(local)
	images.append(Image.open(local))
	n = n + 1

print("录制屏幕生成gift图结束...")
dest.save('screen.gif', save_all=True, append_images=images, loop=1, duration=1, comment=b"aaabb")
# coding=UTF-8
from PIL import Image
from itertools import product

img_path='add_watermarked.png'
img = Image.open(img_path)

width, height = img.size  # 获取图片宽高
for p in product(range(2051,width), range(1460,height)):
	rgb = img.getpixel(p)[:3]
	#print(f">>>{rgb}")
	# 127,177,142 进行阈值筛选
	if (rgb[0] > 225 or rgb[1] > 225 or rgb[2]> 225):
		img.putpixel(p, (255, 255, 255))
#img.save('_OK'.join(splitext('eliminate_water.png')))
img.save('eliminate_water.png')
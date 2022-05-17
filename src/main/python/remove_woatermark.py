# coding=UTF-8
import cv2
import numpy as np
from PIL import Image
import os
dir = os.getcwd()

path = "add_watermarked.png"
newPath = "eliminate_water.png"

img=cv2.imread(path,1)
hight,width,depth=img.shape[0:3]

#截取
# cropped = img[int(hight*0.8):hight, int(width*0.7):width]  # 裁剪坐标为[y0:y1, x0:x1]
cropped = img[1460:hight, 2051:width]
cv2.imwrite(newPath, cropped)
imgSY = cv2.imread(newPath,1)

#图片二值化处理，把[200,200,200]-[250,250,250]以外的颜色变成0
thresh = cv2.inRange(imgSY,np.array([219,137,91]),np.array([225,225,225]))
#创建形状和尺寸的结构元素
kernel = np.ones((3,3),np.uint8)
#扩展待修复区域
hi_mask = cv2.dilate(thresh,kernel,iterations=10)
specular = cv2.inpaint(imgSY,hi_mask,5,flags=cv2.INPAINT_TELEA)
cv2.imwrite(newPath, specular)

#覆盖图片
imgSY = Image.open(newPath)
img = Image.open(path)
img.paste(imgSY, (2051,1460,width,hight))
img.save(newPath)

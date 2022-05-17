# coding=UTF-8
import cv2
import numpy as np
import os

dir = os.getcwd()
print(dir)
   

img = cv2.imread("add_mark/WX20220302-202232@2x.jpg")

# alpha(对比度) beta(亮度)
alpha = 2.0
beta = -160

new = alpha * img + beta
new = np.clip(new, 0, 255).astype(np.uint8)

cv2.imwrite("cleaned.png", new)
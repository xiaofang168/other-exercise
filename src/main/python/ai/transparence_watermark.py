# coding=UTF-8
from PIL import Image, ImageDraw, ImageFont

#Opening Image
img = Image.open(r'WX20220302-202232@2x.png') 

# Creating draw object
draw = ImageDraw.Draw(img) 

#Creating text and font object
text = "测试"
# 支持中文的字体
font = ImageFont.truetype('SimHei.ttf', 82)

# Positioning Text
textwidth, textheight = draw.textsize(text, font)
width, height = img.size 
x=width-textwidth
y=height-textheight

# 新建一个和原图大小一样的水印覆盖层
text_overlay = Image.new('RGBA', img.size, (255, 255, 255, 0))
# 创建一个画图对象
image_draw = ImageDraw.Draw(text_overlay)
# 在指定位置画上文字水印，160就是透明度
image_draw.text((x-100, y-10), text, font=font, fill=(76, 234, 124, 160))
# 实现透明图像和一张背景不透明图像的合成
marked_img = Image.alpha_composite(img, text_overlay)

#Saving the new image
marked_img.save(r'add_transparence_watermarked.png')



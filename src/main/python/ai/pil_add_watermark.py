# coding=UTF-8
from PIL import Image, ImageDraw, ImageFont

#Opening Image
img = Image.open(r'WX20220302-202232@2x.png') 

# Creating draw object
draw = ImageDraw.Draw(img) 

# Creating text and font object
text = "www.baidu.com"
# 英文字体
font = ImageFont.truetype('Arial.ttf', 82)

# Positioning Text
textwidth, textheight = draw.textsize(text, font)
width, height = img.size 
x=width-textwidth
y=height-textheight

# Applying text on image via draw object
# fill为颜色
draw.text((x, y-10), text, font=font, fill=(76, 234, 124, 80)) 
img.save(r'add_watermarked.png')



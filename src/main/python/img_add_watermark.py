# coding=UTF-8
# 给图片加水印
from watermarker.marker import add_mark
# opacity 透明度 angle 倾斜角度 space空格数
add_mark(file=r"WX20220302-202232@2x.png", out=r"add_mark", mark="快学Python", opacity=0.2, angle=45, space=80)
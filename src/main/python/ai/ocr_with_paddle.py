from paddleocr import PaddleOCR, draw_ocr
# Paddleocr supports Chinese, English, French, German, Korean and Japanese.
# You can set the parameter `lang` as `ch`, `en`, `fr`, `german`, `korean`, `japan`
# to switch the language model in order.
ocr = PaddleOCR(use_angle_cls=True, lang='ch') # need to run only once to download and load model into memory
img_path = '/Users/fangjie/Downloads/WechatIMG46.jpeg'
result = ocr.ocr(img_path, cls=True)
for line in result:
	word = line[1]
	#print(line)
	print(word[0])
   
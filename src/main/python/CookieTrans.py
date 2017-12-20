class CookieTrans:
	
	def __init__(self, cookie):
		self.cookie = cookie
		
	def stringToDict(self):
		itemDict = {}
		items = self.cookie.split(';')
		for item in items:
			key = item.split('=')[0].replace(' ', '')
			value = item.split('=')[1]
			itemDict[key] = value
		return itemDict
	
if __name__ == "__main__":
	# copy from chrome
	cookie = ""
	trans = CookieTrans(cookie)
	print trans.stringToDict()
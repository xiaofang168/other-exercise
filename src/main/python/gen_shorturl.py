#import library  
import pyshorteners
#creating object
s=pyshorteners.Shortener()
#type the url 外网的url
url = "https://docs.microsoft.com/zh-cn/learn/modules/intro-to-blockchain/3-how-blockchain-works"
#print the shortend url
print(s.tinyurl.short(url))
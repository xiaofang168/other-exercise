#!/usr/bin/python
#coding:utf-8
import scrapy
import urlparse
import logging

logger = logging.getLogger(__name__)

# scrapy runspider OSChinaCollSpider.py -L WARNING

class OSChinaCollSpider(scrapy.Spider):

	name = 'oschina'
	headers = {
 					'Referer':'https://www.oschina.net',
 					'User-Agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36'
 	}
	# gen by CookieTrans
	cookies = {}
	
	def start_requests(self):
 		return [scrapy.FormRequest(
 				url= 'https://my.oschina.net/xiaofang168/favorites',
 				headers=self.headers,
 				cookies=self.cookies,
				callback=self.parse)]

	def parse(self, response):
		# logging.warning(response.css('div.favorites-item.layout-flex'))
		for favorite in response.css('div.favorites-item.layout-flex'):
			link = favorite.css('div.flex-grow').xpath('.//a/@href').extract_first()
			text = favorite.css('div.flex-grow').xpath('.//a/text()').extract_first()
			data = '<a href=\"'+link+'\" target=\"_blank\">'+text.replace('\n', '').strip()+'</a><br/>\n'
			logging.warning(data)
			filename = 'oschina.html'
			with open(filename, 'a') as f:
				f.write(u''.join(data).encode('utf-8'))

		next_page = response.css('ul.paging').xpath(u"//a[contains(., '下一页')]/@href").extract_first()
		
		if next_page is not None:
			next_page = response.urljoin(next_page)
			parsed = urlparse.urlparse(next_page)
			params = urlparse.parse_qs(parsed.query)
			page_num = params['p'][0]
			if int(page_num) < 7 :
				logging.warning(next_page)
				yield scrapy.Request(
					url=next_page,
					headers=self.headers,
					cookies=self.cookies,
					callback=self.parse)
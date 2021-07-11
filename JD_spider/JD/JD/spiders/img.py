import scrapy

class ImgSpider(scrapy.Spider):
    name = 'img'
    allowed_domains = ['JD.com']
    start_urls = ['https://item.jd.com/100009077475.html']
    img_list = []

    def parse(self, response):
        img_list = response.xpath('//div[@class="preview-wrap"]//ul[@class="lh"]/li/img/@src').extract()
        print(img_list)
        # response.body


def geturl():
    id = 'https://item.jd.com/100009077475.html'
    yield scrapy.Request(id)
    return ImgSpider.img_list
    print(ImgSpider.img_list)


geturl()
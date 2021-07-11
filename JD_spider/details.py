from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from pyquery import PyQuery
import time
import csv
import subprocess
from bs4 import BeautifulSoup as bs
import requests
import urllib3

header = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"}
# Chrome 开启无窗口模式
chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument('--headless')

driver = webdriver.Chrome(chrome_options=chrome_options)
driver.implicitly_wait(10)
res = requests.get('https://item.jd.com/100009077475.html', headers=header)
soup = bs(res.content, 'lxml')

detail_list = []
weight_list = []
img_list = []
temp_list1 = []
temp_list2 = []

def index_page(id):

    print('正在爬取'+str(id)+'的详细信息')
    try:
        # url = 'https://item.jd.com/'+str(id)+'.html'
        url = 'https://item.jd.com/100009077475.html'
        driver.get(url)
        # return get_products(url)
        # print(get_products(url))
        get_products()
    except TimeoutException:
        index_page(id)

def get_products():
    """
    提取商品数据
    """
    html = driver.page_source
    doc = PyQuery(html)
    items = doc('.product-intro').items()

    for item in items:
        img_list.append(item.find('.preview div ul img').attr.src)
        weight_list.append(item.find('.itemInfo-wrap #summary-weight .dd').text())

    items2 = soup.find_all('div', class_='Ptable-item')
    for item2 in items2:
        contents1 = item2.findAll('dt')
        contents2 = item2.findAll('dd')
        for i in range(0, len(contents1)):
            temp1 = contents1[i].string
            temp_list1.append(temp1)
            temp2 = contents2[i].string
            temp_list2.append(temp2)
        # print(type(contents1))
        # print(len(temp_list1), len(temp_list2))
    for i in range(0, len(temp_list1)):
        detail_list.append(temp_list1[i] + ":")
    for i in range(0, len(temp_list2)):
        if temp_list2[i] is None:
            temp_list2[i] = " "
    for i in range(0, len(detail_list)):
        detail_list[i] = (detail_list[i] + temp_list2[i])


    # items3 = soup.find_all('div', id='summary-weight')
    # for item3 in items3:
    #     weight = item3.findAll(class_='dd')
    #     print(weight)


def main():
    id = 100009077475
    index_page(id)
    print(img_list)
    print(detail_list)
    # print(weight_list)
    # print(detail_list)


if __name__ == '__main__':
    main()

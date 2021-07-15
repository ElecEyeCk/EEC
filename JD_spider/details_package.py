from selenium.common.exceptions import TimeoutException
from pyquery import PyQuery
from bs4 import BeautifulSoup as bs
import requests
import json


def browser(url):
    header = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"}
    res = requests.get(url, headers=header)
    soup = bs(res.content, 'lxml')
    index_page(url, soup)


def index_page(url, soup):
    print('正在爬取'+str(id)+'的详细信息')
    try:
        get_products(soup)
    except TimeoutException:
        index_page(id)


def get_products(driver, soup):
    """
    提取商品数据
    """
    detail_list = []
    img_list = []
    temp_list1 = []
    temp_list2 = []
    html = driver.page_source
    doc = PyQuery(html)
    items = soup.find_all('div', class_='jqzoom main-img')
    for item in items:
        img = item.find_all('img')
        for t in img:
            img_list.append(t.get('data-origin'))

    items2 = soup.find_all('div', class_='Ptable-item')
    for item2 in items2:
        contents1 = item2.findAll('dt')
        contents2 = item2.findAll('dd')
        for i in range(0, len(contents1)):
            temp1 = contents1[i].string
            temp_list1.append(temp1)
            temp2 = contents2[i].string
            temp_list2.append(temp2)
    for i in range(0, len(temp_list1)):
        detail_list.append(temp_list1[i] + ":")
    for i in range(0, len(temp_list2)):
        if temp_list2[i] is None:
            temp_list2[i] = " "
    for i in range(0, len(detail_list)):
        detail_list[i] = (detail_list[i] + temp_list2[i])
    dic = {'img': img_list, 'detail': detail_list}
    dic_js = json.dumps(dic)
    return dic_js

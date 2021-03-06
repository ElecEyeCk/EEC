import json
from selenium.common.exceptions import TimeoutException
from bs4 import BeautifulSoup as bs
import requests

header = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"}
res = requests.get('https://item.jd.com/100009077475.html', headers=header)
soup = bs(res.content, 'lxml')

detail_list = []
weight_list = []
img_list = []
temp_list1 = []
temp_list2 = []


def index_page(url):
    try:
        get_products()
    except TimeoutException:
        index_page(url)


def get_products():
    """
    提取商品数据
    """
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


def main():
    url = 'https://item.jd.com/100009077475.html'
    index_page(url)
    dic = {'img': img_list, 'detail': detail_list}
    dic_js = json.dumps(dic)
    print(dic_js)


if __name__ == '__main__':
    main()

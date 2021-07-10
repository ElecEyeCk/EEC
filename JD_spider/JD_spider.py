from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from pyquery import PyQuery
import time
import csv
import os

# Chrome 开启无窗口模式
# chrome_options = webdriver.ChromeOptions()
# chrome_options.add_argument('--headless')

driver = webdriver.Chrome()
driver.implicitly_wait(10)

adr_list = []
price_list = []
name_list = []
commit_list = []
shop_list = []
icons_list = []
img_list = []

# 按需替换路径
file_path = "C:/Users/王羽钧/Desktop/大三下/软件工程课设/数据集/JD_Comput9.csv"


def login():
    print("尝试登录")
    try:
        url = 'https://search.jd.com/Search?keyword=电脑'
        driver.get(url)
        time.sleep(10)
    except TimeoutException:
        login()


def index_page(page, opt):
    """
    抓取索引页
    :param opt: 页面种类
    :param page: 页码
    """
    print('正在爬取第', str(page), '页数据')
    try:
        if page == 1 and opt == 1:
            url = 'https://search.jd.com/Search?keyword=电脑'
            driver.get(url)
        if page == 1 and opt == 2:
            url = 'https://search.jd.com/search?keyword=手机'
            driver.get(url)
        if page == 1 and opt == 3:
            url = 'https://search.jd.com/Search?keyword=%E7%94%B5%E5%99%A8&enc=utf-8&wq=' \
                  'dian%27qi&pvid=1f0eea62444a46b78a1ac87f08e265d3'
            driver.get(url)
        if page > 1 and opt == 1:
            url = 'https://search.jd.com/Search?keyword=%E7%94%B5%E8%84%91&suggest=2.his.0.0&wq=' \
                  '%E7%94%B5%E8%84%91&pvid=9da644f91a3d48818f64bb614f1ac5fc&page=' + str(2 * page - 1)
            driver.get(url)
        if page > 1 and opt == 2:
            url = 'https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&suggest=1.def.0.base&wq=' \
                  '%E6%89%8B%E6%9C%BA&pvid=f616fe6060be41d0ade5c677558afede&page=' + str(2 * page - 1)
            driver.get(url)
        if page > 1 and opt == 3:
            url = 'https://search.jd.com/Search?keyword=%E7%94%B5%E5%99%A8&qrst=1&wq=' \
                  '%E7%94%B5%E5%99%A8&stock=1&pvid=1f0eea62444a46b78a1ac87f08e265d3&page=' + str(2 * page - 1)
            driver.get(url)
        get_products()
    except TimeoutException:
        index_page(page, opt)


def get_products():
    """
    提取商品数据
    """
    js = '''
    timer = setInterval(function(){
       var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
       var ispeed=Math.floor(document.body.scrollHeight / 100);
       if(scrollTop > document.body.scrollHeight * 90 / 100){
           clearInterval(timer);
       }
       console.log('scrollTop:'+scrollTop)
       console.log('scrollHeight:'+document.body.scrollHeight)
       window.scrollTo(0, scrollTop+ispeed)
    }, 20)
    '''
    driver.execute_script(js)
    time.sleep(2.5)
    html = driver.page_source
    doc = PyQuery(html)
    items = doc('#J_goodsList .gl-item .gl-i-wrap').items()

    for item in items:
        # img_list.append(item.find('.p-img a img').attr('src'))
        adr_list.append(item.find('.p-img a').attr('href'))
        price_list.append(item.find('.p-price i').text())
        name_list.append(item.find('.p-name em').text())
        commit_list.append(item.find('.p-commit strong a').text())
        shop_list.append(item.find('.p-shop a').text())
        icons_list.append(item.find('.p-icons .goods-icons').text())


def main():
    login()
    for i in range(1, 101):
        index_page(i, 1)
        print("已爬取"+str(len(adr_list))+"条信息")
    for i in range(0, len(commit_list)):
        name_list[i] = name_list[i].replace("\n", "")
        idx = commit_list[i].find(" ")
        idx2 = str(price_list[i]).find(" ")
        idx3 = str(icons_list[i]).find(" ")
        if idx != -1:
            commit_list[i] = commit_list[i][:idx]
        if idx2 != -1:
            price_list[i] = str(price_list[i])[:idx2]
        if idx3 != -1:
            if icons_list[i][idx3 + 1] == "自":
                icons_list[i] = str(icons_list[i])[:idx3]
        commit_list[i] = commit_list[i].strip("+")
        commit_list[i] = commit_list[i].strip('')
        if "万" in commit_list[i]:
            commit_list[i] = commit_list[i].strip("万")
            commit_list[i] = float(commit_list[i]) * 10000
        else:
            pass
    with open(file_path, 'w', newline='', encoding='utf-8-sig')as f:
        fieldnames = ["adr", "name", "price", "commit", "shop", "icons"]
        # fieldnames = ["adr", "img"]
        f_csv = csv.DictWriter(f, fieldnames=fieldnames)
        f_csv.writeheader()
        for i in range(0, len(adr_list)):
            f_csv.writerow(
                {"adr": adr_list[i],
                 # "img": img_list[i]
                 "name": name_list[i],
                 "price": price_list[i],
                 "commit": commit_list[i],
                 "shop": shop_list[i],
                 "icons": icons_list[i]
                 }
            )
    f.close()
    # os.system("python test.py")


if __name__ == '__main__':
    main()

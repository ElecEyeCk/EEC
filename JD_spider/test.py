import pandas as pd
import csv

file_path = "C:/Users/王羽钧/Desktop/大三下/软件工程课设/数据集/7-6/JD_Comput6.csv"

csv_file = pd.read_csv(file_path)
commit_list = csv_file['commit'].copy()
name_list = csv_file['name'].copy()
adr_list = csv_file['adr'].copy()
price_list = csv_file['price'].copy()
shop_list = csv_file['shop'].copy()
icons_list = csv_file['icons'].copy()

for i in range(0, len(commit_list)):
    # idx = commit_list[i].find(" ")
    # idx2 = str(price_list[i]).find(" ")
    idx3 = str(icons_list[i]).find(" ")
    # if idx != -1:
    #     commit_list[i] = commit_list[i][:idx]
    # if idx2 != -1:
    #     price_list[i] = str(price_list[i])[:idx2]
    if idx3 != -1:
        print(icons_list[i][idx3+1])
        if icons_list[i][idx3+1] == "自":
            icons_list[i] = str(icons_list[i])[:idx3]
    # commit_list[i] = commit_list[i].strip("去看二手")
    # commit_list[i] = commit_list[i].strip("+")
    # commit_list[i] = commit_list[i].strip('')
    #
    # if "万" in commit_list[i]:
    #     commit_list[i] = commit_list[i].strip("万")
    #     commit_list[i] = float(commit_list[i]) * 10000
    # else:
    #     commit_list[i] = commit_list[i]

    # print(idx3)

with open(file_path, 'w', newline='', encoding='utf-8-sig')as f:
    fieldnames = ["adr", "name", "price", "commit", "shop", "icons"]
    f_csv = csv.DictWriter(f, fieldnames=fieldnames)
    f_csv.writeheader()
    for i in range(0, len(commit_list)):
        f_csv.writerow(
            {
             "adr": adr_list[i],
             "name": name_list[i],
             "price": price_list[i],
             "commit": commit_list[i],
             "shop": shop_list[i],
             "icons": icons_list[i]
             }
        )
f.close()

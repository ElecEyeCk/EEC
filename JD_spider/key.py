import csv
import hashlib
import pandas as pd

file_path = "C:/Users/王羽钧/Desktop/大三下/软件工程课设/店家.txt"
outfile_path = "C:/Users/王羽钧/Desktop/大三下/软件工程课设/店家.csv"
csv_file = pd.read_table(file_path)

name_list = csv_file['name'].copy()
key_list = []

def trans():
    # str = '你好'
    # hl = hashlib.md5()
    # hl.update(str.encode(encoding='utf-8-sig'))
    for i in range(0, len(name_list)):
        hl = hashlib.md5()
        hl.update(str(name_list[i]).encode(encoding='utf-8-sig'))
        key_list.append(hl.hexdigest())
    print(key_list)


def main():
    trans();
    with open(outfile_path, 'w', newline='', encoding='utf-8-sig')as f:
        fieldnames = ["name", "key"]
        f_csv = csv.DictWriter(f, fieldnames=fieldnames)
        f_csv.writeheader()
        for i in range(0, len(name_list)):
            f_csv.writerow(
                {"name": name_list[i],
                 "key": key_list[i]
                 }
            )
    f.close()

if __name__ == '__main__':
    main()
# **Round2 - Nối mạng toàn cầu**
🚀 Phần hướng dẫn này sẽ giải thích cách tạo ra các bộ đề tương ứng và một số đoạn script hỗ trợ.

## **Đề bài**

[![Watch the video](https://img.youtube.com/vi/Z5k0B4TF8Mg/maxresdefault.jpg)](https://youtube.com/embed/P8LFF1Z0ECI?start=118&end=199)

## Chương trình đoán chuyển đổi bin -> hex

```bash
./binary/bin2hex
```
## Chương trình đoán chuyển đổi hex -> ascii

```bash
./binary/hex2ascii
```
## Tạo bộ đề tương ứng

### File Structure:
Chuẩn bị cây thư mục như mô tả
```
this folder
│   readme
│   
└───src
│      raw2msg.py
│      export_cipher_csv.py
│      ...

└───binary
│      readme
│      msg2cipher
│      ...
|
└───example
│      inp.txt
│      ...

```

### **Chuyển từ định dạng chữ sang teencode**
#### Instruction
```bash
python ./src/raw2msg.py --inp <path/to/raw/input/file> --out <path/to/msg/file> 
```

*input*
```
<inp seq1>
<inp seq2>
...
<inp seqN>
```
*output*
```
<encode seq1>
<key1>
...
<encode seqN>
<keyN>
0 # this is ending file character
```
#### **Expected output**
*runing command*
```bash
python src/raw2msg.py --inp ./example/inp.txt --out ./example/ans.txt
```
*inp.txt* 

[demo file](example/inp.txt)

*ans.txt*

[demo file](example/ans.txt)

### **Chuyển từ định dạng teencode sang ciphertext**
#### Instruction
*running command*
```bash
./binary/msg2cipher < <path/to/input/file> > <path/to/output/file>
```
*input*
```
<encode seq1>
<key1>

...

<encode seqN>
<keyN>
0 # this is ending file character
```

*output*
```
Cipher: <cipher1>
Key: <key1>
Answer: <teencode msg1>

...

Cipher: <cipherN>
Key: <keyN>
Answer: <teencode msgN>
```

#### **Expected output**
*runing command*
```bash
./binary/msg2cipher < ./example/ans.txt > ./example/msg.txt
```
*ans.txt*

[demo file](example/ans.txt)

*msg.txt*

[demo file](example/msg.txt)

### **Xuất ra định dạng csv**
#### Instruction
```bash
python ./src/export_cipher_csv.py <path/to/cipher/file> <path/to/csv/table/file>
```

*input*
```
Cipher: <cipher1>
Key: <key1>
Answer: <teencode msg1>

...

Cipher: <cipherN>
Key: <keyN>
Answer: <teencode msgN>
```

*output* (csv file)
```
-----------------
| | | | | | | | |
...
| | | | | | | | |
-----------------

Key: 
Answer: 
```
#### **Expected output**
*runing command*
```bash
python src/export_cipher_csv.py --inp ./example/msg.txt --out ./example/result.csv
```
*msg.txt*

[demo file](example/msg.txt)

*result.csv*

[demo file](example/result.csv)

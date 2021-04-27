## Môi trường chạy

Chương trình được chạy dựa trên leJOS NXJ trên hệ điều hành Windows 10.

http://www.lejos.org/nxj.php

## Cài đặt môi trường

Chi tiết cài đặt: [Getting Started on Microsoft Windows](http://www.lejos.org/nxt/nxj/tutorial/Preliminaries/GettingStartedWindows.htm)

Bước đầu tiên cần làm là cài đặt JDK (Java Development Kit). Chọn các JDK có phiên bản 32-bit để cài đặt.

Tải chương trình cài đặt leJOS NXJ tại [đây](http://www.lejos.org/nxj-downloads.php) (nên chọn leJOS_NXJ_\<version\>_win32_setup.exe để dễ cài đặt).

Kết nối NXT với máy tính qua cổng USB hoặc Bluetooth, sau đó chạy nxjflash để tải leJOS firmware lên NXT.

## Dịch và chạy chương trình

Mở command line, di chuyển vào thư mục src, chạy:
```
nxjc *.java # dịch chương trình
nxj [-r] [-b] Robot # link, upload [chạy] [qua bluetooth] chương trình lên NXT
```

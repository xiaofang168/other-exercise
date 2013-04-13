@ echo off
set workPath=D:\ckfinder_java_2.3.1\ckfinder
for /r "%workPath%\" %%i in (*.java) do (
iconv -f GBK -t UTF-8 %%i > %%i_utf8
del  %%i
rename %%i_utf8 %%~nxi
)
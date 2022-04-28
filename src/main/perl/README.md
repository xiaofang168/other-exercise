## 学习资料
- 两个半小时学会Perl https://qntm.org/perl_cn

## 可能会和安装的oracle perl冲突解决
- 把环境变量中的PERL5LIB 去掉
- 在线安装会出现问题，改为手动下载编译安装

## 检查某个模块是否安装
- 方法一：perl -MPerl6::Slurp -e "print\"module installed\""
- 方法二：perldoc module_name 例：perldoc IO::ALL,perldoc -f open

## 在线安装模块
- 模块搜索 https://metacpan.org/
- cpan module_name 例：cpan IO::ALL
- 自动安装依赖的命令: cpanm module_name 例：sudo cpanm module_name
- 强制安装,解决安装失败问题: sudo cpanm --force install BSON::Raw
- 强制安装跳过测试,加速安装过程和避免测试失败导致安装不成功: sudo cpanm --force install BSON::Raw --notest   

## 使用代理在线安装模块
https://metacpan.org/

```shell
cpan
cpan> o conf #(查看设置提示)
cpan> o conf http_proxy http://127.0.0.1:8087
cpan> o conf commit
cpan> o conf use_sqlite 0
cpan> o conf commit
cpan> reload index
cpan> install CPAN::SQLite
cpan> o conf use_sqlite 1
cpan> o conf commit
cpan> install Bundle::CPAN
```

reload CPAN即可正常通过命令行install MODULES

## 数据库安装模块
- DBI
- DBD::Oracle
- Data::ShowTable

## 用sublime 开发
- Decode error - output not utf-8

解决办法，打开
C:\Users\用户名\AppData\Roaming\Sublime Text 2\Packages\User\您的编译配置文件 
增加"encoding":"cp936" 

- 当前代码文件在中文目录时候，编译出错时

1. 打开： C:\Users\liqun\AppData\Roaming\Sublime Text 2\Packages\Default\exce.py
修改 proc_env[k] = os.path.expandvars(v).encode(sys.getfilesystemencoding())为  proc_env[k] = os.path.expandvars(v.decode(sys.getfilesystemencoding())).encode(sys.getfilesystemencoding()) 

2. 在 self.proc = subprocess.Popen(arg_list, stdout=subprocess.PIPE, 
   前增加 
   for index in range(len(arg_list)):  
    arg_list[index]=arg_list[index].encode(sys.getfilesystemencoding()) 


## 语法
- 在文件头部加上如下代码print自动换行

```perl
#!/usr/bin/perl -l

```
### 符号解释
- =~  读作does match，表示正则表达式匹配
- $_ 表示Perl中的“老地方”，即在没有特殊指定变量的情况下，编译器会默认使用$_变量的内容参与程序运算。
```perl
$_ = "aaa4zzz7bbb";
$_ =~ /(\d)z{3}(\d)/;
print "$1\t$2\n";

$_ = "hello world!";
print; #默认读取$_

```
### 正则表达式
- r 不替换原字符串，返回替换的新字符串（默认替换原串，返回替换次数） $new = $str =~ s/l/L/r

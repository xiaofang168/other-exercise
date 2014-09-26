#!/usr/bin/perl
use strict;
use warnings;

#my $_="ABCDEFGHIGKLMN";
#my $str = $& if /(?<=C).*(?=L)/;

my $t ="ABCDEFGHIGKLMN";
my $str = $& if($t =~/(?<=C).*(?=L)/);
print $str."\n";



#my @a = split(/(\d+)/, "as12f31jd");
#my @b = split(/([a-z])/,"jd");
#print $_,"\n" for @a;
#print $_,"\n" for @b;
#(?<=\d):逆向肯定预查。匹配数字(后面是数字)
#(?!\d):正向否定预查。匹配不是数字(前面不是数字)
#(?<=\d)(?!\d)匹配as12 f31 jd

#(?<!\d):逆向否定预查。匹配不是数字(后面不是数字)
#(?=.):正向肯定预查。匹配任意字符(前面是任意字符)
#(?<!\d)(?=.)匹配a s 12f 31j d

#对as12 f31 jd 进行(?<!\d)(?=.)匹配得到最后的结果
my @a=split/(?<!\d)(?=.)/,"jd";
print $_,"\n" for @a;

# 输出数组长度
my $nu=@a;
print(($#a+1)."\n");
print($nu."\n");
print scalar(@a)."\n";
#my @a=split/(?<=\d)(?!\d)|(?<!\d)(?=.)/,"as12f31jd";
#print $_,"\n" for @a;

#### 简化后的方法。分割成匹配正则表达式的字符段作为分隔的条件

# 非数字开头或非数字结尾
#my @a = split(/(?!\d)|(?<!\d)/, "35abc833fa88gf");
#print $_,"\n" for @a;

# 分隔符是 c (结尾不能是数字)
#my @a = split(/(?<!\d)/, "c833");
#print $_,"\n" for @a;


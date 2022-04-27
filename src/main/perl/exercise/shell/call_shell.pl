#!/bin/perl -w -l
use strict;
use warnings;

# 需要在shell中用perl命名执行
=pod
system "http v2-static.etouch.cn/apis/holiday-in-law.json --ignore-stdin > bb.json"; 
返回值也是它调用的命令的退出状态

perl的system函数和awk的一样不能够返回命令的输出.
要得到命令的输出,就得使用和shell本身一样的命令: ` `

exec
最后,perl还可以使用exec来调用shell的命令. exec和system差不多,不同之处在于,
调用exec之后,perl马上就退出,而不会去继续执行剩下的代码

在bash中，$()与``（反引号）都是用来作命令替换的
=cut

my $s = "--ignore-stdin";
my $answer= `echo `.$(.`http v2-static.etouch.cn/apis/holiday-in-law.json $s`;
#print $answer;

# 为避免shell命令的特殊符号，采用先变量定义的方法
my $command = "`http v2-static.etouch.cn/apis/holiday-in-law.json --ignore-stdin`";
my $result = `echo $command`;
print $result;
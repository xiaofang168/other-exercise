#!/usr/bin/perl
use strict;
use warnings;
use Encode;

use IO::All;
use autodie; 
use Tie::File;

# die if problem reading or writing a file
#my $io = io('D:\fangj\ln_workspace\qingbao-entities\src\main\java\com\egf\qingbao\csyj\entities\ZdryZcjydbzlGzjlfk.java'); 
#print $io->name,"\n"; 
#while (my $line = $io->getline){
	#print encode("gbk", decode("utf8", "读取一行:".$line));
	#print encode("gb2312",decode("utf8",$line));
#}

# 文件关联数组
my @lines;                                                       
my $filename='ZdryZcjydbzlGzjlfk.java';
# 将记录文件同数组关联，默认为文本型文件
 # 记录分隔符使用"\r\n"或"\n" 
tie(@lines,'Tie::File',$filename) or die; 
#splice(@lines,0,0,"insert");
my $tmp="";
my $count=-1;
foreach $tmp (@lines){
	$count++;
	my $l=encode("gb2312",decode("utf8",$tmp));
	my $str1="private String";
	my $str2="static";
	if($l=~/$str1/&&!($l=~/$str2/)){
		#判断是否存在注解
		my $previous=encode("gb2312",decode("utf8",$lines[$count-1]));
		my $str3="FieldExchange";
		if(!($previous=~/$str3/)){
			#添加注解
			#提取字段
			my $st=$lines[$count];
			$st =~s/(private String )(.*)(;)/$1;$2;$3/;
			my $column=uc($2);
			my $addRow="\@FieldExchange(columnName=\"".$column."\")";
			#print $addRow."\n";
			#print $count."\t".($count-1)."\n";
			splice(@lines,$count,0,"\t".$addRow);
			#print $column."\n";
		}
	}
}

                                            

# $lines[0]="Hello"; # 这里对数组内容的操作就直接反映到文件中去了                   
# $lines[1]="world!"; # 增加一条新记录                                              
# splice(@lines,1,0,"insert another line"); # 在老记录之间插入记录                                                      
# delete $lines[0]; # 删除记录                                                     

# untie(@lines); # 解除文件同数组的关联



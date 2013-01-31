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
my %className_tableName = (
    ZdryZcjydbzlScczfk  => "ZCJYDBZL_SCCZFK ",
    ZdryZcjydbzlYqsq => "ZCJYDBZL_YQSQ",
    ZdryZcjydbzlGzjlfk=> "ZCJYDBZL_GZJLFK",
    ZdryZcjydbzlRdfzxyrxxbc=> "ZCJYDBZL_RDFZXYRXXBC",
    ZdryZcjydbzlYpbcxx=> "ZCJYDBZL_YPBCXX",
    ZdryGxr=> "GXR",
    ZdryGxrZp=> "GXR_ZP",
    ZdryTary=> "TARY",
    ZdryTaryZp=> "TARY_ZP",
    ZdryTaryXjz=> "TARY_XJZ",
    ZdryTaryDbz=> "TARY_DBZ",
    ZdryTxgxr=> "TXGXR",
    ZdryWsxnsf=> "WSXNSF",
    ZdryYhzh=> "YHZH",
    ZdryJzj=> "JZJ",
    ZdrySzzw=> "SZZW",
    ZdryDnabh=>"DNABH",
    ZdryZp=> "ZP",
    ZdryXjz=> "XJZ",
    ZdryDbz=> "DBZ",
    ZdryTxgj=> "TXGJ",
    ZdryCl=> "CL",
    ZdryClZp=> "CL_ZP",
    ZdryKywp=> "KYWP",
    ZdryKywpZp=> "KYWP_ZP",
    ZdryZagj=> "ZAGJ",
    ZdryZagjZp=> "ZAGJ_ZP",
    ZdryQtxx=> "QTXX",
    ZdryJcxxsjgzzlZlqs=>"JCXXSJGZZL_ZLQS",
    ZdryJcxxsjzlGzzlxd=>"JCXXSJGZZL_ZLXD",
    ZdryJcxxsjgzzlYpbcxx=> "JCXXSJGZZL_YPBCXX",
    ZdryCsyjdxdcqksbSb=>"CSYJDXDCQKSB_SB",
    ZdryCsyjdxdcqksbBc=>"CSYJDXDCQKSB_BC",
    ZdryCsyjdxdcqksbYpbc=>"CSYJDXDCQKSB_YPBC"
);

my @classNames = keys %className_tableName;  
my @tableNames = values %className_tableName;
my $className;
my $n=-1;

foreach $className(@classNames){
	my $path='D:\fangj\ln_workspace\qingbao-entities\src\main\java\com\egf\qingbao\csyj\entities';                                        
	my $filename=$path."\\".$className.".java";
	$n++;
	handle($filename,$tableNames[$n]);
}

#处理方法
sub handle{
	#接收参数
    my($filename,$tableName)=@_;  
    my @lines; 
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
		my $str0="class";
		#类增加注解
		if ($l=~/$str0/) {
			my $previous=encode("gb2312",decode("utf8",$lines[$count-1]));
			my $str4="\@ClassExchange";
			if(!($previous=~/$str4/)){
				my $addRow="\@ClassExchange(tableName=\"".$tableName."\")";
				splice(@lines,$count,0,"\t".$addRow);
			}
		}
		#增加字段注解
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
				print $addRow."\n";
				#print $count."\t".($count-1)."\n";
				#splice(@lines,$count,0,"\t".$addRow);
				#print $column."\n";
			}
		}
	}
	# 解除文件同数组的关联
	untie(@lines); 
}

# $lines[0]="Hello"; # 这里对数组内容的操作就直接反映到文件中去了                   
# $lines[1]="world!"; # 增加一条新记录                                              
# splice(@lines,1,0,"insert another line"); # 在老记录之间插入记录                                                      
# delete $lines[0]; # 删除记录                                                     
# untie(@lines); # 解除文件同数组的关联



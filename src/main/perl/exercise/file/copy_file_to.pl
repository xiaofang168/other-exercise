use strict;
use warnings;

use Path::Class;
use File::Find;
use File::Copy;


#my $str4="FileEditor";

sub wanted{if(/\.java$|\.jsp$|\.xml$/){  
		#print $File::Find::name."\n";#输出路径跟文件名  #你要进行的操作 
		my $folder=$File::Find::dir;
		
		my $str="target";
		if(!($folder =~/\./)&&!($folder =~/$str/)){
			my $file_name=$File::Find::name;
			open (INFILE, $file_name);
			while(<INFILE>){
				my $strf=$file_name;
				#替换中文字符
				$strf=~ s/D:\\tj_new_workspace\\workspace/D:\\tj\\workspace/g;
				#$strf=~ s/utils_script/utils_script\\copy_pro/g;
				print "copty to:".$strf."\n";
				copy($file_name,$strf) or die "Copy failed: $!";
				last; #只要找到匹配就输出1并退出此次循环
			}   
			close(INFILE);
		}
	}}
find \&wanted,'D:\tj_new_workspace\workspace';
#find \&wanted,'D:\utils_script\egf-common';
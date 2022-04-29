#!/usr/bin/perl -l
use strict;
use warnings;

use IO::All;
use autodie; 
use Tie::File;

my $origin = "hikk";
my $target = "Fangj";

sub scan_file {
	my @files = glob($_[0]."*");
	foreach my $file (@files) {
		my @lines; 
		tie(@lines,'Tie::File',$file) or die; 
		my $count=-1;
		foreach my $line (@lines){
			$count++;
			my $str="site: http://www.$origin.com";
			# 构造表达式对象，origin忽略大小写
			my $regex = qr/(?i:$origin)/;
			# 替换头中的compay为Fangj
			if($line =~ /(Copyright).*($regex).*/){
				$line =~ s/$2/Fangj/;
			}
			# 删除类中的compay
			if ($line=~/$str/) {
				# 删除该行
				splice(@lines,$count,1);
			}
			# 修改package 中的company 为 fangj
			if($line =~ /(package com\.)($origin)/){
				$line =~ s/$2/$target/;
			}
			if($line =~ /package/){
				print "遇到package退出循环，循环次数：",$count+1,">>>";
				last;
			}
		}
		# 解除文件同数组的关联
		untie(@lines); 
	}
}
scan_file("/Users/fangjie/exception/");
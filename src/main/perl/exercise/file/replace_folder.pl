#!/bin/perl
use strict;
use warnings;

use Path::Class;
use File::Find;

use Tie::File;

my @lines;

sub wanted{
		my $folder=$File::Find::dir;
		# print $folder."\n";
		#print $file_name."\n";
		my $str="demo";
		my $destStr="ivms";
		my $file_name=$File::Find::name;
		# 替换import package错误的包名称
		if($file_name =~/\.java/){
			print $file_name."\n";
			tie(@lines,'Tie::File',$file_name) or die; 
			foreach (@lines){
				if ($_ =~ /import|package .*.demo.*/) {
					s/demo/ivms/g;
					print "find ".$_."\n";
					last;
				}
			}
			untie(@lines); 
		}
		if($folder = $str){
			rename $folder, $destStr;
		}
	}
# 自下而上查找
finddepth (\&wanted,'E:\workspaces\train\L201\src\main\java');
#!/usr/bin/perl
use strict;
use warnings;
use File::Basename;
use File::Copy;

sub scan_file {
	my $count = 0;
	my $base;
	my $dir;
	my $ext;
	
	my $folder_base;
	
	my @files = glob($_[0]);
	foreach (@files){
		if(-d $_){
			my $path = "$_/*";
			scan_file($path);
		}elsif(-f $_){
			$count = $count+1;
			$base = basename($_);
			$dir  = dirname($_);
			($base, $dir, $ext) = fileparse($_,".jpg");
			
			$folder_base =basename($dir);
			
			#print "$dir\n";
			#print "$folder_base\n";
			my $newfile = $dir.$folder_base."_".$count.".jpg";

			# 获取文件名称
			#print "$_ \n";
			#print "$newfile \n";
			rename "$_", "$newfile" or die "Cannot rename file: $!";
			
			# move to new folder
			move($newfile, "/Users/fangjie/Downloads/post_images");
		}
	}
}
scan_file("/Users/fangjie/Downloads/我的眼睛会说话/帖子图片");


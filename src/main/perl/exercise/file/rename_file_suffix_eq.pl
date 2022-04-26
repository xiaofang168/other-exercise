#!/usr/bin/perl
use strict;
use warnings;
use File::Basename;
use File::Copy;

sub scan_file {
	my $base;
	my $dir;
	my $ext;
	
	my @files = glob($_[0]);
	foreach (@files){
		if(-d $_){
			my $path = "$_/*";
			scan_file($path);
		}elsif(-f $_){
			$base = basename($_);
			$dir  = dirname($_);
			($base, $dir, $ext) = fileparse($_,".svga");
			# 文件后缀相等判断
			if($ext eq '.svga'){
				my $filename = basename($_,  ".svga");
				my $newfile = $dir.$filename."_ani.svga";
				print "$newfile \n";
				rename "$_", "$newfile" or die "Cannot rename file: $!";
			}
		}
	}
}
scan_file("/Users/fangjie/Downloads/蘑菇1.0.0礼物/gifts");
#!/bin/perl
use strict;
use warnings;
# ~~可以完全代替=~进行匹配，而且比=~更强大
# my @array = ("abcd", "xyz", "123", 456) ;
# print "found match!\n" if @array ~~ /xyz/ ;

# 命令替换
# perl -n -i -e 'print unless m/git/' a.txt

my $strTemp = "";
open IN, "a.txt" or die $!; 
while (<IN>) {
	chomp;
	if ($_=~ /git/) {
		# 整行替换
		print($_."\n");
		$_=~ s/$_//g;
	}
	$strTemp = $strTemp.$_;
}
open FF,">aa.txt" or die $!;
print FF $strTemp;
close FF;
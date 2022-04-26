#!/usr/bin/perl
use strict;
use warnings;
my $str ="ID=CCG000163.1;source_id=CUFF5.37.1";
#$str=~ s/ID/$1/;
#$str=~ s/(ID=)(.*)(;)/$1;$2;$3/;
#$content=~s/,([^,]*)$/$1/;
#键值对方式提取
my %hash = $str =~ m/(\w+)=([^;]*)/g;
#print join("\n",my @k = keys %hash);
foreach(keys %hash){
	print "$_ => $hash{$_}\n";
}
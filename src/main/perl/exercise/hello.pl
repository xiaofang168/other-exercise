#!/usr/bin/perl -l
use strict;
use warnings;
use 5.014;
use Data::Dumper;
# defined
my ($col,$row) = 0;

print "Hello World";

# qw定义数组
my @array=qw(print these strings out for me);
print $array[0];

#foreach 
foreach(@array){
	print $_;
}
#out length
print "length:".(scalar @array)."\n";
print "length method 2".(@array),"\n";
# "最后一个索引的号码是 5"
print "The last populated index is ".$#array,"\n";


#Perl 脚本捕获的命令行参数被保存在内置的数组变量 @ARGV 中
# "print these strings out for me"
print "@array";

#
print "Hello \$string","\n"; # "Hello $string"
print 'Hello $string',"\n";  # "Hello $string"
print "\@array","\n";        # "@array"
print '@array',"\n";         # "@array"

#for
for(my $i = 0; $i < scalar @array; $i++) {
	print $i, ": ", $array[$i], "\n";
}
#使用负数索引来检索从后往前的元素：
print	($array[-1]);
print "hello word" x 2; 

my @list1 = (4..9,'d'..'w');
my @list2 = (0..9,'a'..'z');
my %hash = map {$_ => 1} @list1;

print Dumper \%hash;

# 数组过滤(hash中存在的)
my @sss = grep { $hash{$_} } @list2;
# 循环遍历
say for @sss;

my @names = qw(Foo Bar Baz);
my %is_invited = map {$_ => 1} @names;

# Dumper友好的查看数据结构
print Dumper \%is_invited;

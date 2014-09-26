#!/usr/bin/perl
use strict;
use warnings;

print "Hello World\n";

my @array=("print","these","strings","out","for","me");
print  $array[0];
print   "\n";
#foreach 
foreach(@array){
	print $_."\n";
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
print "Hello \$string"; # "Hello $string"
print 'Hello $string';  # "Hello $string"
print "\@array";        # "@array"
print '@array';         # "@array"

#for
for(my $i = 0; $i < scalar @array; $i++) {
	print $i, ": ", $array[$i];
}
#使用负数索引来检索从后往前的元素：
print	($array[-1]);
print "hello word" x 2; 

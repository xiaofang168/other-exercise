#!/bin/perl
use strict;
use warnings;

$a=[qw(a b c)];
#$a=["a","b","c"];
print $a->[0],"\n";
unshift @$a,"A";
#unshift $a,"A";
print $a->[0],"\n";

my @array = (1, 2, 3, 4, 5); 
my $array_r = \@array; 
#拷贝了数组
my @array2 = @{$array_r};

my @names=qw/fred barney betty dino wilma pebbles bamm-bamm/;
my $result = &which_element_is("dino",@names);
print $result;
sub which_element_is{
	my($what,@array)=@_;
	print($what."\n");
	print(@array."\n");
	# $#array 是数组的最后一个元素的下标索引
	foreach(0..$#array){
		if($what eq $array[$_]){
			return $_;
		}
	}
	-1;
}




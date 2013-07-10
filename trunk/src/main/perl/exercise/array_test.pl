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


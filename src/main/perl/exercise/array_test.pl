#!/bin/perl
use strict;
use warnings;

$a=[qw(a b c)];
#$a=["a","b","c"];
print $a->[0],"\n";
unshift @$a,"A";
#unshift $a,"A";
print $a->[0],"\n";
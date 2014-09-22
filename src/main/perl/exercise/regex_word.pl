#!/usr/bin/perl
use strict;
use warnings;
my $_="ABCDEFGHIGKLMN";
my $str = $& if /(?<=C).*(?=L)/;
print $str."\n"
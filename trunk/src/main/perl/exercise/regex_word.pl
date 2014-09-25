#!/usr/bin/perl
use strict;
use warnings;


my $_="ABCDEFGHIGKLMN";
my $str = $& if /(?<=C).*(?=L)/;
print $str."\n";
#my @a = split(/(\d+)/, "as12f31jd");
#my @b = split(/([a-z])/,"jd");
#print $_,"\n" for @a;
#print $_,"\n" for @b;
my @a=split/(?<=\d)(?!\d)|(?<!\d)(?=.)/,"as12f31jd";
print $_,"\n" for @a;



#!/bin/perl
use strict;
use warnings;

my $str = "AAAT&TTTA";
#my $b = "TTTA&AAAT";
print join(' ', sort{$a cmp $b} split /\&/,$str), "\n";
my $c = "2";
my $d = "4";
print $c cmp $d;



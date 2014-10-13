#!/usr/bin/perl
use strict;
use warnings;

my $scalar = 1 ;
my @array = (1, 2, 3) ;
print $array[2]."\n\n";
my %hash = ('zdd' => 30, 'autumn' => 27) ;

my $sref = \$scalar ;   # scalar reference
my $aref = \@array ;    # array reference
my $href = \%hash ;     # hash reference



# 方法二
print ${$sref}, "\n" ;
print @{$aref}, "\n" ;
print %{$href}, "\n" ;
print ${$aref}[2], "\n" ;
print ${$href}{'zdd'}, "\n" ;
print "\n";
# 方法三，不适用于标量
print $aref->[0], "\n" ;
print $href->{'zdd'}, "\n" ;
#!/usr/bin/perl
use strict;
use warnings;
my @arrayRef = ();
#print \@arrayRef;
push @arrayRef, "one";
print @arrayRef;
#push @arrayRef, "two";
print "\n";
my $username = "12d34dd235";
my $pwd = $username;
$username =~ s/[a-z]//g;
#print($1);
print "$username\n";
print "$pwd";

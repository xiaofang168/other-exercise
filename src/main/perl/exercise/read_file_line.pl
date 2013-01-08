#!/usr/bin/perl
use strict;
use warnings;


use IO::All;
use autodie; # die if problem reading or writing a file
my $io = io('column.txt'); 

print $io->name,"\n"; 
while (my $line = $io->getline){
	print "读取一行：",$line;
}

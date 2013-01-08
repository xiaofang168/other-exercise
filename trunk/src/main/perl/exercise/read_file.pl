#!/usr/bin/perl
use strict;
use warnings;

use Perl6::Slurp;
use autodie; 
# die if problem reading or writing a file
#my $file = 'column.txt';    
#my $text = slurp $file;   
#print $text, "\n";


# Slurp file by handle    
my $text_file = 'column.txt';   
open my $text, '<', $text_file or die $!;   
my $content = slurp $text;    
print $content, "\n";


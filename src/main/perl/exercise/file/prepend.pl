use strict;
use warnings;
 
my $str = "text to prepend\n";
my $filename = "/Users/fangjie/Downloads/aa.txt";
 
open my $in,  '<:encoding(utf8)', $filename or die "Could not open '$filename' for reading";
# turn on "slurp mode"
local $/ = undef;  
my $content = <$in>;
close $in;
 
open my $out, '>:encoding(utf8)', $filename or die "Could not open '$filename' for writing";
print $out $str;
print $out $content;
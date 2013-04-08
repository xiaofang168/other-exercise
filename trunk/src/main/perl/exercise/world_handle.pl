use strict;
use warnings;
use Encode;

use IO::All;
use autodie; # die if problem reading or writing a file
my $io = io('world.txt'); 

print $io->name,"\n"; 
my $handle_str;
while (my $line = $io->getline){
	my $str=$line;
	#替换中文字符
	$str=~ s/([\x80-\xFF]+)|\(|\)|\[|\]//g;
	#$str=~ s/(\])//g;
	$handle_str=$handle_str.$str;
}
$handle_str=~ s/\n//g;
print $handle_str."\n";
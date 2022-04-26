use strict;
use warnings;
my $str="/A/B/C/D/E.jsp";
#$str = m/[^\/]+$/;
my @myarray=($str =~ /[^\/]+$/g);
#print join(",", @myarray);
#print($str."\n"); 

$str =~ s/([^\/]+$)/$1/g;
#print($1);


#$str2 = split("/",$str2);
my @array = split("/",$str);
print $array[-1];
#foreach (@array){
#	print($_."\n");
#}



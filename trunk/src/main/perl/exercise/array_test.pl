#!/bin/perl
use strict;
use warnings;

$a=[qw(a b c)];
#$a=["a","b","c"];
print $a->[0],"\n";
unshift @$a,"A";
#unshift $a,"A";
print $a->[0],"\n";

my @array = (1, 2, 3, 4, 5); 
my $array_r = \@array; 
#拷贝了数组
my @array2 = @{$array_r};

my @names=qw/fred barney betty dino wilma pebbles bamm-bamm/;
my $result = &which_element_is("dino",@names);
print $result;
sub which_element_is{
	my($what,@array)=@_;
	print($what."\n");
	print(@array."\n");
	# $#array 是数组的最后一个元素的下标索引
	foreach(0..$#array){
		if($what eq $array[$_]){
			return $_;
		}
	}
	-1;
}

my @w=(1,2,3,4);
my @k=(6,7,8,9);
# 如果你不想用全局变量的话，也可以传引用。
#&da(\@w,\@k);
my @f = &shift(\@w,\@k);
#print(@f.">>");
#如果你的sub 跟系统内置的同名了, 就加& 否则可不加.
#print "#$_" for (my @f = &da(\@w,\@k));
sub shift
{
	#my $m = shift @_;
	#my $n = shift @_;

	my ($m,$n) = @_;
	print("\n\n\n");
	my $x = @$m;
	my $y = @$n;
	print($x);
	print($y);
	print("\n\n\n");
	my $z = ($x < $y) ? $y : $x;    
	my @e = map {@$m[$_] + @$n[$_]} 0 .. $z-1;
	return @e;
}
=cut
for my $i (0..$#a) {
  $c[$i] = $a[$i] + $b[$i];
}
=cut
my @a = (1, 2, 3);
my @b = (1, 2, 3);

my @c = map { $a[$_] + $b[$_] } 0..$#a;
print @c."\n";

# \ 是引用
print \(scalar(@a));
# 加上之前的@ $ %({}) 是解引用
print ${\(scalar(@a))};
print "\n";
my $t = \@a;

print(@{$t});

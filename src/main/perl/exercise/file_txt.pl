use strict;
use warnings;


my $array_new=[];
open(IN,"text.txt") or die "Cant't open file $!";
open(OUT,">text2.txt");
while(<IN>){
	chomp;
	my($a1,$a2)=split(/\t/,$_);
	my @array=($a1,$a2);
	@array=sort(@array);
	push $array_new,[@array];
	print OUT join("\t",sort(@array)),"\n";
}
close IN;
close OUT;
print "finish!","\n";

#遍历新数组元素

#print scalar(@{$array_new});
my @array =@{$array_new};
print "Remove duplicate ago\n";
printArray (@array);
print "\n";


my %hash;
#grep 保存符合条件的元素
@array = grep { ++$hash{$_->[0].$_->[1]} < 2 } @array;
print "Remove duplicate after\n";
printArray (@array);
print "\n";

sub printArray{
	my $tmp;
	foreach $tmp (@_){
	 	print $tmp->[0]."\t".$tmp->[1]."\n";
	}
}
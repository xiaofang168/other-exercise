#!/bin/perl
use strict;
use warnings;
use Template;
use Encode;
use DBI;
use Perl6::Slurp;
use autodie; 

our @array;
# connect
my $dbh = DBI->connect("DBI:mysql:mysql:172.55.3.30", "root", "sa");

my $sth = $dbh->prepare("SELECT lower(column_name) FROM information_schema.COLUMNS WHERE TABLE_NAME = 'user'");
$sth->execute();
# iterate through resultset
# print values
while(my @data = $sth->fetchrow_array()) {
	$data[0]=~ s/_(.)/\U$1/g;
	push @array, $data[0];
}
=pod
print "\n\n";
my $a ="QQ";
# \u \l 将后一位转换为大(小)写 \U \L将后面的所有转换成大(小)写
=cut
foreach (@array) {
	# 正则表达式处理
	#$_=~ s/_//g;
	#$_=~ s/_(.)/\U$1/g;
	print "private var $_ = _;\n";
}

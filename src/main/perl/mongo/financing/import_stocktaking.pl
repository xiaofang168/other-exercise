#!/usr/bin/perl 
use strict; 
use warnings;
use diagnostics;
use Spreadsheet::Read;
use MongoDB;
use Encode;
use Encode qw/encode/;
use utf8;
use open ":encoding(gbk)", ":std";

my $client = MongoDB->connect('mongodb://localhost:27017');
my $db = $client->get_database('mydb');
my $robots = $db->get_collection('import_stocktaking');

my $file = "/Users/fangjie/Downloads/stocktaking.xls"; #需要处理的文件
my $path = encode("gbk",$file);

my $workbook = ReadData($path); 
my $sheet_count = $workbook->[0]{sheets} or die "No sheets in $file\n"; #记录有几个sheet
for my $sheet_index (1 .. $sheet_count) {
	my $sheet = $workbook->[$sheet_index] or next; 
	for my $row (2 .. $sheet->{maxrow}) {
			my @d = map {
				$sheet->{cell}[$_][$row];
			}1 .. $sheet->{maxcol};
			my %a = (_id => $d[0], targetId => $d[1], date=> $d[2], amount=> $d[3], income=> $d[4], rate=>$d[6], createTime=>$d[8]);
			# 存在空值无字段
			if($d[5]) {
				$a{'totalIncome'}=$d[5];
			}
			# 存在空值无字段
			if($d[7]){
				$a{'comment'}=$d[7];
			}
			# hash reference,传递引用
			$robots->insert_one(\%a);
		};
}
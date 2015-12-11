#!/usr/bin/perl 
use strict; 
use warnings; 
use Spreadsheet::Read;
use MongoDB;
use Encode;
use Encode qw/encode/;
use utf8;
use open ":encoding(gbk)", ":std";


my $client = MongoDB->connect('mongodb://localhost:37017');
my $db = $client->get_database('singpk');
my $robots = $db->get_collection('robot');

my $file = "D:\\机器人\\test.xlsx"; #需要处理的文件
my $path = encode("gbk",$file);

my $workbook = ReadData($path); 
my $sheet_count = $workbook->[0]{sheets} or die "No sheets in $file\n"; #记录有几个sheet
for my $sheet_index (1 .. $sheet_count){
	my $sheet = $workbook->[$sheet_index] or next; 
	for my $row (2 .. $sheet->{maxrow}) {
			my @d = map {
				$sheet->{cell}[$_][$row];
			}1;
			$robots->insert_one( { user_id => "566964010b0000110056603c", username => $d[0] } );
			#foreach my $num (@d){
			#	print "$num \n"
			#}
		};
	}
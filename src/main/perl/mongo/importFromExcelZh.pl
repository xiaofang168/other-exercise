#!/usr/bin/perl 
use strict; 
use warnings; 
use Spreadsheet::Read;
use Spreadsheet::WriteExcel;
use Spreadsheet::ParseExcel;
use Spreadsheet::ParseExcel::FmtUnicode;
use Encode;
use MongoDB;
use 5.014;
use Encode qw/encode/;
use utf8;


my $client = MongoDB->connect('mongodb://localhost:27017');
my $db = $client->get_database('singpk');
my $robots = $db->get_collection('robot');

my $oExcel = Spreadsheet::ParseExcel->new();
my $oFmtC = Spreadsheet::ParseExcel::FmtUnicode->new(Unicode_Map=>"CP936");

my $file = "D:\\机器人\\包含用户id导出\\50200个用户(到深爱是谋杀).xls"; #需要处理的文件
my $path = encode("gbk",$file);

my $workbook = $oExcel->Parse($path, $oFmtC );

for my $worksheet ( $workbook->worksheets() ) {
	my ($row_min, $row_max) = $worksheet->row_range();
	for my $row (1 .. $row_max) {
		my $idCell = $worksheet->get_cell( $row, 0 );
		my $usernameCell = $worksheet->get_cell( $row, 1 );
		my $id = $idCell -> value();
		my $username = $usernameCell -> value();
		$robots->insert_one( { user_id => $id, username => decode("gbk", $username)});
	}
}








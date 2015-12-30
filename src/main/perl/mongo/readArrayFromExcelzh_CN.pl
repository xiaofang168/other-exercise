#!/usr/bin/perl 
use strict; 
use warnings; 
use Spreadsheet::Read;
use Spreadsheet::WriteExcel;
use Spreadsheet::ParseExcel;
use Spreadsheet::ParseExcel::FmtUnicode;
use Encode;
use MongoDB;
use Encode qw/encode/;
use utf8;

my $oExcel = Spreadsheet::ParseExcel->new();
my $oFmtC = Spreadsheet::ParseExcel::FmtUnicode->new(Unicode_Map=>"CP936");

my $file = "D:\\机器人\\aa.xls"; #需要处理的文件
my $path = encode("gbk",$file);
print $path . "\n";
my $workbook = $oExcel->Parse($path, $oFmtC );

my $prefix = [];
my $suffix =[];

for my $worksheet ( $workbook->worksheets() ) {
	my ( $row_min, $row_max ) = $worksheet->row_range();
	my ( $col_min, $col_max ) = $worksheet->col_range();
	#print $row_min . '....' .$row_max;
	#print $col_min . '....' .$col_max;
	for my $row (1 .. 1105 ) {
		my $prefixCell = $worksheet->get_cell( $row, 0 );
		next unless $prefixCell;
		push @$prefix, $prefixCell->value();
	}
	for my $row (1 .. 1004) {
		my $suffixCell = $worksheet->get_cell( $row, 1 );
		next unless $suffixCell;
		push @$suffix, $suffixCell->value();
	}
}

print "@$prefix\n";



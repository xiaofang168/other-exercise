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

my $oExcel = Spreadsheet::ParseExcel->new();
my $oFmtC = Spreadsheet::ParseExcel::FmtUnicode->new(Unicode_Map=>"CP936");

my $file = "D:\\机器人\\aa.xls"; #需要处理的文件
my $path = encode("gbk",$file);

my $workbook = $oExcel->Parse($path, $oFmtC );

my $prefix = [];
my $suffix = [];
my $usernames = [];

for my $worksheet ( $workbook->worksheets() ) {
	my ( $row_min, $row_max ) = $worksheet->row_range();
	my ( $col_min, $col_max ) = $worksheet->col_range();
	#print $row_min . '....' .$row_max;
	#print $col_min . '....' .$col_max;
	# the perfix max row num is 1105
	# the suffix max row num is 1004
	for my $row (1 .. 50 ) {
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
foreach my $pf (@{$prefix}) {
	foreach my $sf (@{$suffix}) {
		push @$usernames, $pf . $sf;
	}
}
#print "@$usernames\n";
#print "@$prefix\n";
#print "@$suffix\n";

# Create a new Excel workbook
my $workbook2 = Spreadsheet::WriteExcel->new('D:\perl.xls');

# Add a worksheet
my $worksheet2 = $workbook2->add_worksheet();

 #  Add and define a format
my $format = $workbook2->add_format(); # Add a format
$format->set_bold();
$format->set_color('red');
$format->set_align('center');

# Add header
$worksheet2->write(0, 0, "用户名", $format);
$worksheet2->write(0, 1, "密码", $format);

while (my ($index, $element) = each(@{$usernames}))
{
	$worksheet2->write_string($index+1, 0, decode("gbk", $element));
	$worksheet2->write_string($index+1, 1, "123456");
}

# Close Workbook
$workbook2->close();






#!/usr/bin/perl -w
use strict;
use MongoDB;
use Spreadsheet::WriteExcel;
use Encode;

# Create a new Excel workbook
my $workbook = Spreadsheet::WriteExcel->new('/Users/fangjie/Downloads/stocktaking.xls');

# Add a worksheet
my $worksheet = $workbook->add_worksheet();

 #  Add and define a format
my $format = $workbook->add_format(); # Add a format
$format->set_bold();
$format->set_color('red');
$format->set_align('center');

# Add header
$worksheet->write(0, 0, decode("utf8", "id"), $format);
$worksheet->write(0, 1, decode("utf8", "标的id"), $format);
$worksheet->write(0, 2, decode("utf8", "盘点时间"), $format);
$worksheet->write(0, 3, decode("utf8", "金额"), $format);
$worksheet->write(0, 4, decode("utf8", "收益"), $format);
$worksheet->write(0, 5, decode("utf8", "总收益"), $format);
$worksheet->write(0, 6, decode("utf8", "利率"), $format);
$worksheet->write(0, 7, decode("utf8", "备注"), $format);
$worksheet->write(0, 8, decode("utf8", "创建时间"), $format);

my $client = MongoDB->connect('mongodb://localhost:27017');
my $db = $client->get_database('mydb');

my $flowColl = $db->get_collection('stocktaking');
# \@ids is reference 
my $flows = $flowColl->find;
my $i = 1;
while (my $doc = $flows->next) {
	my $id = $doc->{'_id'};
	my $targetId = $doc->{'targetId'};
	my $date = $doc->{'date'};
	my $amount = $doc->{'amount'};
	my $income = $doc->{'income'};
	my $totalIncome = $doc->{'totalIncome'};
	my $rate = $doc->{'rate'};
	my $comment = $doc->{'comment'};
	my $createTime = $doc->{'createTime'};
	# Add Data
	$worksheet->write($i, 0, $id);
	$worksheet->write($i, 1, $targetId);
	$worksheet->write($i, 2, $date);
	$worksheet->write($i, 3, $amount);
	$worksheet->write($i, 4, $income);
	$worksheet->write($i, 5, $totalIncome);
	$worksheet->write($i, 6, $rate);
	$worksheet->write($i, 7, $comment);
	$worksheet->write_string($i, 8, $createTime);
	$i++;
}
# Close Workbook
$workbook->close();
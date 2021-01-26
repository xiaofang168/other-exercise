#!/usr/bin/perl -w
use strict;
use MongoDB;
use Spreadsheet::WriteExcel;
use Encode;

# Create a new Excel workbook
my $workbook = Spreadsheet::WriteExcel->new('/Users/fangjie/Downloads/flow.xls');

# Add a worksheet
my $worksheet = $workbook->add_worksheet();

 #  Add and define a format
my $format = $workbook->add_format(); # Add a format
$format->set_bold();
$format->set_color('red');
$format->set_align('center');

# Add header
$worksheet->write(0, 0, decode("utf8", "id"), $format);
$worksheet->write(0, 1, decode("utf8", "平台"), $format);
$worksheet->write(0, 2, decode("utf8", "类别"), $format);
$worksheet->write(0, 3, decode("utf8", "状态"), $format);
$worksheet->write(0, 4, decode("utf8", "金额"), $format);
$worksheet->write(0, 5, decode("utf8", "标的"), $format);
$worksheet->write(0, 6, decode("utf8", "开始时间"), $format);
$worksheet->write(0, 7, decode("utf8", "结束时间"), $format);

my $client = MongoDB->connect('mongodb://localhost:27017');
my $db = $client->get_database('mydb');

my $flowColl = $db->get_collection('flow');
# \@ids is reference 
my $flows = $flowColl->find;
my $i = 1;
while (my $doc = $flows->next) {
	my $id = $doc->{'_id'};
	my $platform = $doc->{'platform'};
	my $category = $doc->{'category'};
	my $state = $doc->{'state'};
	my $amount = $doc->{'amount'};
	my $target = $doc->{'target'};
	my $startDate = $doc->{'startDate'};
	my $endDate = $doc->{'endDate'};
	# Add Data
	$worksheet->write($i, 0, $id);
	$worksheet->write($i, 1, $platform);
	$worksheet->write($i, 2, $category);
	$worksheet->write($i, 3, $state);
	$worksheet->write($i, 4, $amount);
	$worksheet->write($i, 5, $target);
	$worksheet->write($i, 6, $startDate);
	$worksheet->write($i, 7, $endDate);
	$i++;
}
# Close Workbook
$workbook->close();
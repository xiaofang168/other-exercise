#!/usr/bin/perl -w
use strict;
use MongoDB;
use Spreadsheet::WriteExcel;
use Encode;

# Create a new Excel workbook
my $workbook = Spreadsheet::WriteExcel->new('D:\perl.xls');

# Add a worksheet
my $worksheet = $workbook->add_worksheet();

 #  Add and define a format
my $format = $workbook->add_format(); # Add a format
$format->set_bold();
$format->set_color('red');
$format->set_align('center');

# Add header
$worksheet->write(0, 0, decode("utf8", "用户名"), $format);
$worksheet->write(0, 1, decode("utf8", "密码"), $format);

my $client = MongoDB->connect('mongodb://localhost:37017');
my $db = $client->get_database('singpk');
my $users = $db->get_collection('user');
my $all_users = $users->find;
my $i = 1;
while (my $doc = $all_users->next) {
	my $username = $doc->{'username'};
	# Add Data
	$worksheet->write($i, 0, $username);
	$worksheet->write($i, 1, $username);
	$i++;
}
# Close Workbook
$workbook->close();
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
my $users = $db->get_collection('user');

my $workbook2 = Spreadsheet::WriteExcel->new('D:\perl.xls');

# Add a worksheet
my $worksheet2 = $workbook2->add_worksheet();

 #  Add and define a format
my $format = $workbook2->add_format(); # Add a format
$format->set_bold();
$format->set_color('red');
$format->set_align('center');

# Add header
$worksheet2->write(0, 0, "id", $format);
$worksheet2->write(0, 1, "username", $format);

my $all_users = $users->find;
my $i = 1;
while (my $doc = $all_users->next) {
	my $id = $doc->{'_id'};
	my $username = $doc->{'username'};
	# Add Data
	$worksheet2->write_string($i, 0, $id);
	$worksheet2->write_string($i, 1, $username);
	$i++;
}

# Close Workbook
$workbook2->close();







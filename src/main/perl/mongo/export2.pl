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
$worksheet->write(0, 0, decode("utf8", "id"), $format);
$worksheet->write(0, 1, decode("utf8", "用户名"), $format);

my $client = MongoDB->connect('mongodb://localhost:37017');
my $db = $client->get_database('singpk');

#my @numbers = (100000001 .. 100020000);
#my @numbers = (110000001 .. 110020000);
#my @numbers = (600001 .. 655000);
#my @numbers = (500001 .. 550000);
my @numbers = (700100000 .. 700130000);
my @ids = map {$_ . ''} @numbers;
my $users = $db->get_collection('user');
# \@ids is reference 
my $all_users = $users->find({'username' => {'$in'=> \@ids}});
my $i = 1;
while (my $doc = $all_users->next) {
	my $id = $doc->{'_id'};
	my $username = $doc->{'username'};
	# Add Data
	$worksheet->write($i, 0, $id);
	$worksheet->write($i, 1, $username);
	$i++;
}
# Close Workbook
$workbook->close();
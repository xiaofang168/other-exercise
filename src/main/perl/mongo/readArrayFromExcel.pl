#!/usr/bin/perl 
use strict; 
use warnings; 
use Spreadsheet::Read;
use Spreadsheet::WriteExcel;
use Encode;
use MongoDB;
use Encode qw/encode/;
use utf8;
use open ":encoding(gbk)", ":std";


# Create a new Excel workbook
my $writebook = Spreadsheet::WriteExcel->new('D:\perl.xls');

# Add a worksheet
my $worksheet = $writebook->add_worksheet();

 #  Add and define a format
my $format = $writebook->add_format(); # Add a format
$format->set_bold();
$format->set_color('red');
$format->set_align('center');

# Add header
$worksheet->write(0, 0, "id", $format);
$worksheet->write(0, 1, "用户名", $format);

my $client = MongoDB->connect('mongodb://localhost:27017');
my $db = $client->get_database('singpk');
my $users = $db->get_collection('user');


my $file = "D:\\机器人\\5万个用户(2100001-2150000,混入一个随机字母).xls"; #需要处理的文件
my $path = encode("gbk",$file);
my $usernames = [];
my $workbook = ReadData($path); 
my $sheet_count = $workbook->[0]{sheets} or die "No sheets in $file\n"; #记录有几个sheet
for my $sheet_index (1 .. $sheet_count){
	my $sheet = $workbook->[$sheet_index] or next; 
	for my $row (2 .. $sheet->{maxrow}) {
			my @d = map {
				$sheet->{cell}[$_][$row];
			}1;
			push @$usernames, $d[0];
		};
	}
#print "@$usernames\n";
#foreach(@$usernames){
#	print $_."\n";
#}
my $all_users = $users->find({'username' => {'$in'=> $usernames}});
my $i = 1;
while (my $doc = $all_users->next) {
	my $id = $doc->{'_id'};
	my $username = $doc->{'username'};
	# Add Data
	$worksheet->write_string($i, 0, $id);
	$worksheet->write_string($i, 1, $username);
	$i++;
}
# Close Workbook
$writebook->close();
use strict;
use warnings;
use JSON;

my $filename = 'adx.txt';
my @adxArray;

open(my $fh, '<', $filename)
	or die "Could not open file '$filename' $!";

while (my $row = <$fh>) {
  chomp $row;
  $row =~ m/\((\d+)\)/;
  my $appKey = $1;
  my $adxObj = {"app" => "wltt",  "value" => $row,  "platform" => "ios",  "key" => $appKey};
  push(@adxArray, $adxObj);
  #print "$row>>>$appKey \n";
}

my $json_text  = to_json \@adxArray ,{pretty => 1};

print $json_text;






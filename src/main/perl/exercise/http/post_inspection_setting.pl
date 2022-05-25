#!/usr/bin/perl -l
use strict;
use warnings;
use autodie; 
use utf8;
use JSON;

use Perl6::Slurp;
use Net::HTTP::Client;
use Data::Dumper;

use Encode qw(decode encode);
use utf8::all;
binmode(STDIN, ':encoding(utf8)');
binmode(STDOUT, ':encoding(utf8)');
binmode(STDERR, ':encoding(utf8)');


# die if problem reading or writing a file
my $file = '其它巡检配置_done.json';    
my $json_text = slurp $file;

my $json_array = JSON->new->utf8->decode($json_text);
#print ref @$json_array;

#print Dumper $json_array;

for my $obj (@$json_array) {
	my $value = to_json $obj;
	#print $value;
	# 一定要utf8编码
	my $txt = encode("utf8", $value);
	my $res2 = Net::HTTP::Client->request(POST => 'localhost:8080/inspection/settings', 'Content-Type' => 'application/json',  $txt);
	if ($res2->is_success) {
		print $res2->decoded_content, "\n";
	} else {
		warn $res2->status_line, "\n";
	}
}





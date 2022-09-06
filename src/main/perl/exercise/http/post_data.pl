#!/bin/perl
use strict;
use warnings;
use JSON;

use Net::HTTP::Client;

my $client = Net::HTTP::Client->new(Host => 'v2-static.etouch.cn', KeepAlive => 0);
 
my $res = $client->request(GET => '/apis/holiday-in-law.json');

#if ($res->is_success) {
 # print $res->decoded_content;
#} else {
#  warn $res->status_line, "\n";
#}

my %data = ('source'=>'pay_center_dk', 'ext'=>'{"count":230}', 'create_time'=>1650888000000,'ip'=>'');

# json转换
my $json_text  = to_json \%data;

print $json_text, "\n";

my $res2 = Net::HTTP::Client->request(POST => 'localhost:8083/data/commit', 'Content-Type' => 'application/json', $json_text);

if ($res2->is_success) {
  print $res2->decoded_content, "\n";
} else {
  warn $res2->status_line, "\n";
}


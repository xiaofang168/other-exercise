#!/bin/perl -l
use strict;
use warnings;
use JSON;
use Date::Parse;
use Data::Dumper;
use Net::HTTP::Client;

# 定义天
my @days = ("2022-04-27");

# 定义小时
my @times = ("07:30","11:30","15:30","19:30");

# 成功数数组
my @count_list = qw(100 200 400 500 80 90 300 600 200);

# 构造单条数据
foreach my $day (@days) {
	while (my ($index, $time) = each(@times)) {
		my $day_time = "$day $time";
		# 字符串时间转化为时间戳
		my $start_time = str2time($day_time)*1000;
		my $end_time = str2time($day_time)*1000 + 40*60*1000;

		# 随机抽取一个成功数
		my $count = $count_list[rand @count_list];

		# 开始和结束的两次构造
		my %start_ext = ("times"=>$index+1,"count"=> 0,"state"=>0);
		my %end_ext = ("times"=>$index+1,"count"=>int $count,"state"=>1);

		# JSON转换
		my $start_ext_json  = to_json \%start_ext;
		my $end_ext_json  = to_json \%end_ext;

		my %start_row = (source=>'', ext=>$start_ext_json, create_time=>$start_time, ip=>'');
		my %end_row = (source=>'', ext=>$end_ext_json, create_time=>$end_time, ip=>'');

		# post json
		my $start_row_json  = to_json \%start_row;
		my $end_row_json  = to_json \%end_row;

		my @data = ($start_row_json, $end_row_json);

		# http post
		foreach (@data) {
			print $_;
			my $result = Net::HTTP::Client->request(POST => ':8083/data/commit', 'Content-Type' => 'application/json', $_);
			if ($result->is_success) {
			  print $result->decoded_content;
			} else {
			  warn $result->status_line, "\n";
			}
		}
	}
}


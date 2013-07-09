#!/bin/perl
use strict;
use warnings;
use Template;
use Encode;
use DBI;

#defin typeMap
my %filed_type = (
"int" => "Serial",
"varchar" => "String",
"tinyint"=> "Boolean",
"date"=> "Date"
);


our $array=[];
# connect
my $dbh = DBI->connect("DBI:mysql:test:localhost:3306", "root", "");

my $sth = $dbh->prepare("SELECT column_name,data_type,column_default,is_nullable FROM information_schema.COLUMNS WHERE TABLE_NAME = 'menu'");
$sth->execute();
# iterate through resultset
# print values
while(my @data = $sth->fetchrow_array()) {
   push $array, {col_name=>$data[0],col_type=>$filed_type{$data[1]},col_default=>$data[2],col_nullable=>$data[3]};
}
# 建一个 TT 的对象
my $tt = Template->new({ INCLUDE_PATH => '.',  INTERPOLATE  => 1, }) || die "$Template::ERROR\n";       
my $vars = {       
	table_name => "Menu", 
	teams=>$array
};   
# 使用 
my $templateFile = 'module.tt'; 
my $outputContent=""; 
$tt->process($templateFile, $vars, "Menu.rb") || die $tt->error();
$tt->process($templateFile, $vars, $outputContent) || die $tt->error();
#print $outputContent;

my $test="a,b,c,d,e,end";
#$test=~s/,$//;
#$test=~s/,([^,]*)$/$1/;
#$test=~s/,end$//;
#$outputContent=~s/(.+),/$1/s;
$outputContent=~s/,\n*end\n*$//;
print $outputContent;
print ">>>\n"
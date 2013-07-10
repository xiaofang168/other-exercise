#!/bin/perl
use strict;
use warnings;
use Template;
use Encode;
use DBI;
use Perl6::Slurp;
use autodie; 

#defin typeMap
my %filed_type = (
"int" => "Serial",
"varchar" => "String",
"tinyint"=> "Boolean",
"date"=> "Date"
);


our @array=();
# connect
my $dbh = DBI->connect("DBI:mysql:test:localhost:", "", "");

my $sth = $dbh->prepare("SELECT column_name,data_type,column_default,is_nullable FROM information_schema.COLUMNS WHERE TABLE_NAME = 'resource'");
$sth->execute();
# iterate through resultset
# print values
while(my @data = $sth->fetchrow_array()) {
   push @array, {col_name=>$data[0],col_type=>$filed_type{$data[1]},col_default=>$data[2],col_nullable=>$data[3]};
}

for my $element (@array) {  
  		#print $element->{col_name}."\n";
}

# 建一个 TT 的对象
my $tt = Template->new({ INCLUDE_PATH => '.',  INTERPOLATE  => 1, }) || die "$Template::ERROR\n";       
my $vars = {       
	table_name => "Menu", 
	teams=>\@array
};   
# 使用 
my $templateFile = 'module.tt'; 
my $outputContent; 
$tt->process($templateFile, $vars, "Menu.rb") || die $tt->error();
#$tt->process($templateFile, $vars, $outputContent) || die $tt->error();
my $text_file = 'Menu.rb';   
open my $text, '<', $text_file or die $!;   
my $content = slurp $text;  
#replace last , 
#[^,]匹配除了,以外的任意字符
$content=~s/,([^,]*)$/$1/;

open(HANDLE, ">",$text_file) or die "Can't open $text_file $!";
print HANDLE $content;  
close(HANDLE);  

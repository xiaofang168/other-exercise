#!/usr/bin/perl 
use strict; 
use warnings; 
use Spreadsheet::Read; 
use Encode;

my $file = "test.xlsx"; #需要处理的文件
my $workbook = ReadData($file); 
my $sheet_count = $workbook->[0]{sheets} or die "No sheets in $file\n"; #记录有几个sheet
for my $sheet_index (1 .. $sheet_count){
  my $sheet = $workbook->[$sheet_index] or next; 
  printf("%s - %2d: [%-s] %3d Cols, %5d Rows\n", $file,$sheet_index,$sheet->{label},$sheet->{maxcol},$sheet->{maxrow});
  for my $row (1 .. $sheet->{maxrow}) {
						print join "\t" => map {
                                my $data = $sheet->{cell}[$_][$row] ;
								defined $data ?encode("gbk", decode("utf8", $data)) : "-";
                }1 .. $sheet->{maxcol};
				 print "\n";
              };
   }
#方式二遍历
# my $sheet = $workbook->[$sheet_index] or next; 
# for my $row (1 .. $sheet->{maxrow}) {
#		print join "\t" => map {$sheet->{cell}[$_][$row] // "-" } 1 .. $sheet->{maxcol};
#	print "\n"
# };
#print $workbook->[1]{A3} . "\n"; 
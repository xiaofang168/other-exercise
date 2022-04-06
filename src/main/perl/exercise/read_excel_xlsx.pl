#!/usr/bin/perl -w
use warnings;
use strict;
use Spreadsheet::ParseExcel;
use Spreadsheet::XLSX;

my $excel = Spreadsheet::XLSX->new('test.xlsx');

foreach my $sheet (@{$excel->{Worksheet}}) {

    printf("Sheet: %s\n", $sheet->{Name});

    foreach my $row ($sheet->{MinRow} .. $sheet->{MaxRow}) {

        foreach my $col ($sheet->{MinCol} ..  $sheet->{MaxCol}) {

            my $cell = $sheet->{Cells}[$row][$col];
            my $value="";

            if ($cell) {
                $value = $cell->{Val};
                printf("%s", $value);
                print "--";
            }else {
                print $value;
                print "--空--";
            }
        }
        print "\n\n";
    }

}
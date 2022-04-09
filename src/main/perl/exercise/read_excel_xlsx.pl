#!/usr/bin/perl -w
use warnings;
use strict;
use Spreadsheet::ParseExcel;
use Spreadsheet::XLSX;

my $excel = Spreadsheet::XLSX->new('test.xlsx');
=pod
对@array的解引用：
$$reference[element];
$reference->[element];
@$reference; #to access the whole array
@{reference}

对%hash的解引用：
$$reference{'key'};
$reference->{'key'};
%$reference; #to access the whole hash
=cut

# 遍历数组中的hash引用(引用本身是标量)
# 对象只是一个引用（也就是一个scalar变量），它恰好知道自己属于哪个类。要告诉一个引用它所指向的内容属于哪个类
# scalar变量能包含：
# undef（对应Python中的None、PHP中的null）
# 数值（Perl不区分整形和浮点类型）
# 字符串
# 其他变量的引用
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
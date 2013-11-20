#!/usr/bin/perl 
use strict; 
use warnings; 
use Spreadsheet::Read; 
use Spreadsheet::WriteExcel;
use Encode;
#需要处理的文件
my $file = "test.xlsx"; 
# 定义导出列、标题
my %column_title=(
    "邮编" => 0,
    "公司" => 1 ,
    "地址" => 2,
    "联系人" => 3,
    "电话" => 4,
    "手机" => 5,
    "传真" => 6,
    "Email" => 7,
    "QQ" => 8,
    "网址" => 9,
    "主营项目" => 10
);

#print $column_title{'公司'};

my $workbook = ReadData($file); 

my $wb = Spreadsheet::WriteExcel->new('perl.xls');

my $format = $wb->add_format();
$format->set_align('center');
 # Add a worksheet
my $ws = $wb->add_worksheet();
$ws->set_column('A:A', 20);
$ws->set_column('B:B', 20);
$ws->set_column('C:C', 50);
$ws->set_column('D:D', 20);
$ws->set_column('E:E', 20);
$ws->set_column('F:F', 20);
$ws->set_column('G:G', 20);
$ws->set_column('H:H', 20);
$ws->set_column('I:I', 20);
$ws->set_column('J:J', 20);
$ws->set_column('K:K', 100);

my $key;
my $value;
while (($key, $value) = each(%column_title)){
   $ws->write(0,$value, decode("utf8", $key), $format);
}

my $sheet_count = $workbook->[0]{sheets} or die "No sheets in $file\n"; #记录有几个sheet
for my $sheet_index (1 .. $sheet_count){
  my $sheet = $workbook->[$sheet_index] or next; 
  for my $row (1 .. $sheet->{maxrow}) {
						 map {
                my $data = $sheet->{cell}[$_][$row];
                #my $mydata= "传真:Email:517751665";
                
                $data =~ s/(\n|\r)+//g;
                my @array = split(/(\S*?：)/,$data);
           
                #my @myarray=($data =~ m/(\S*?：)/g);
                #print join(",", @myarray);
                #foreach (@myarray){
                 # print encode("gbk", decode("utf8", $_)).","
                #}untie(@myarray); 
                my $i = 1;
                my $count = 0;
                while ($i < @array-1) { 
                    if($count%2==0){#标题
                      # 获取列
                      my $t = $array[$i];
                      $t =~ s/(\d*)|(\.*)|：//g;
                      print $row.">>".$count.">>".$t.">>"."\n";
                      $ws->write($row, $column_title{$t}, decode("utf8", $array[$i+1]), $format);
                    }
                    $i++;
                    $count++;
                } 
                #foreach (@array){
                 #my col = $column_title{};
                 #$ws->write($row,$value, decode("utf8", $key));
                 #print $_."\n"
                #}untie(@array); 
                }1 .. $sheet->{maxcol};
				        print "\n\n";
              };
   }
  $workbook->close();
  $wb->close() or die "Error closing file: $!";
   

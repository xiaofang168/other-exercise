use strict;
use warnings;
use HTML::Template;
use Encode;


require "read_oracle_table.pl";
our $array;
#print $array->[2]->{'td1'};
#print $array;
#print $::array;
my $template = HTML::Template->new(filename => 'form_add.tmpl');

my $items = [];
push $items, {td1=>'姓名',td2=>'o.xm',td2id=>'xm',td3=>'性别',td4=>'o.xb',td4id=>'xb'};
push $items, {td1=>'作案手段',td2=>'o.zasd',td2id=>'zasd',td3=>'高危类型',td4=>'o.gwlx',td4id=>'gwlx'};
push $items, {td1=>'案件类别',td2=>'o.ajlb',td2id=>'ajlb',td3=>'小案类别',td4=>'o.xalb',td4id=>'xalb'};


$template->param(title        => encode("gb2312", decode("utf8", "测试标题")));
$template->param(entityClass   => 'com.egf.fangj.Test');
$template->param(items  => $array);

print encode("gb2312", decode("gb2312", $template->output()));

#写文件
my $html_file = 'form_add.jsp';

#open(HANDLE, ">test.html") or die "Can't open $html_file $!";
open(HANDLE, ">",$html_file) or die "Can't open $html_file $!";
print HANDLE $template->output();  
close(HANDLE);  
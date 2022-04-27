#!/usr/bin/perl -w -l
use warnings;

$x = 12345;
print $x;
@hits = (25, 30, 40);  
print \@hits;
# 引用    
$aref = \@hits ;
print @{$aref};
print @$aref;

print @hits ;

print "\n";
my @b = qw/google taobao runoob/;

@names = ("google", "runoob", "taobao", \@b);
my $n = \@names;
my $r = @names;
print $r;

print ">>";
print $n;
print "<<";
# 解引用
print @$n[0];

=pod
使用$hits[0]而不是@hits[0]是因为数组元素是标量，所以必须使用标量前缀$
在Perl中规则是前缀代表您想要获得的东西，而不是您拥有的东西
=cut
print $hits[0];
print $names[3];

# 取数组中的引用(数组数据)
print @{$names[3]}[0];

my @array1 = ();
my @nestedArray = ("one", "two");
my @nestedArray2 = ("five", "seven", "three");
#push @array1, @nestedArray;
my $nestedArray = \@nestedArray2;
push @array1, $nestedArray;
push @array1, \@nestedArray;
print @array1;

my $c = @{$array1[1]}[0];
print $c;
foreach $e (@array1){
  print @{$e}[0];        #依次打印三个列表元素
}
 
my %data = ('google'=>'google.com', 'runoob'=>'runoob.com', 'taobao'=>'taobao.com');
my $d = \%data;
print $data{'google'};

# 遍历时候解引用用法
print $d->{google};
print $d->{'google'};





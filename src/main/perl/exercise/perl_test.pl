#!/usr/bin/perl
use warnings;


$x = 12345;
print $x . "\n";
@hits = (25, 30, 40);  
print \@hits;
print "\n";
# 引用    
$aref = \@hits ;
print @{$aref};
print "\n";
print @$aref;

print "\n";

print @hits ;

print "\n";
my @b = qw/google taobao runoob/;

@names = ("google", "runoob", "taobao", \@b);
my $n = \@names;
my $r = @names;
print "???\n";
print $r;

print ">>\n";
print $n;
print "\n<<\n";
# 解引用
print @$n[0];
print "\n";
=pod
使用$hits[0]而不是@hits[0]是因为数组元素是标量，所以必须使用标量前缀$
在Perl中规则是前缀代表您想要获得的东西，而不是您拥有的东西
=cut
print $hits[0] . "\n";
print $names[3];
print "\n";

# 取数组中的引用(数组数据)
print @{$names[3]}[0];

my @array1 = ();
print "\n";
print "\n";
my @nestedArray = ("one", "two");
my @nestedArray2 = ("five", "seven", "three");
#push @array1, @nestedArray;
my $nestedArray = \@nestedArray2;
push @array1, $nestedArray;
push @array1, \@nestedArray;
print @array1;
print "\n";
my $c = @{$array1[1]}[0];
print $c;
print "\n\n";
foreach $e (@array1){
  print @{$e}[0] . "\n";        #依次打印三个列表元素
}

 
my %data = ('google'=>'google.com', 'runoob'=>'runoob.com', 'taobao'=>'taobao.com');
my $d = \%data;
print $data{'google'} . "\n";

# 遍历时候解引用用法
print $d->{google} . "\n";
print $d->{'google'} . "\n";





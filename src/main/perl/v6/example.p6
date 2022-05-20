use v6;
 
# start by printing out the header. 
say "Tournament Results:\n";
 
my $file  = open 'scores.txt'; # get filehandle and... 
my @names = $file.get.words;   # ... get players. 

#my @names = 'Beth', 'Ana','Charlie Dave';

say @names,"\n";
 
my %matches;
my %sets;
my $a = ":";
 
for $file.lines -> $line {
    say $line;
    # ignore any empty lines
    next unless $line; 
 
    my ($pairing, $result) = $line.split(' | ');
    my ($p1, $p2)          = $pairing.words;
    my ($r1, $r2)          = $result.split(':');
 
    %sets{$p1} += $r1;
   
    %sets{$p2} += $r2;
     
    # 字符串连接
    say %sets, $a, ' >>';
 
    if $r1 > $r2 {
        %matches{$p1}++;
    } else {
        %matches{$p2}++;
    }
}

my @sorted = @names.sort({ %sets{$_} }).sort({ %matches{$_} }).reverse;
 
for @sorted -> $n {
    my $match-noun = %matches{$n} == 1 ?? 'match' !! 'matches';
    my $set-noun   = %sets{$n} == 1 ?? 'set' !! 'sets';
    say "$n has won %matches{$n} $match-noun and %sets{$n} $set-noun";
}

"\nhello world".say;

# 字符串拼接
sub say-hello (Str $name) {
    say "Hello " ~ $name ~ "!!!!"
}
say-hello "Paul";
say-hello "Paula";

# 方法重载
multi greet($name) {
    say "Good morning $name";
}
multi greet($name, $title) {
    say "Good morning $title $name";
}

greet "Johnnie";
greet "Laura","Mrs.";


# 高阶函数编程
my @array = <1 2 3 4 5>;
sub squared($x) {
    $x ** 2
}
say map(&squared, @array);

# 匿名函数
say map(-> $x {$x ** 2}, @array);

# 链式调用
my @array2       = <7 8 9 0 1 2 4 3 5 6 7 8 9 >;
my @final-array = @array2.unique.sort.reverse;
say @final-array;

# Feed 操作符，管道操作
my @array3 = <7 8 9 0 1 2 4 3 5 6>;
@array3 ==> unique()
       ==> sort()
       ==> reverse()
       ==> my @final-array3;
say @final-array3;

class Human {
  has $.name;
  has $.age;
  has $.sex;
  has $.nationality;
}

my $john = Human.new(name => 'John', age => 23, sex => 'M', nationality => 'American');
say $john.age;

# 如果存在就返回age属性
say .age with $john; 

if 'Rakudo is a Perl 6 compiler' ~~ m/:s Perl 6/ {
    say "匹配的内容是：" ~ $/;
    say "匹配之前的字符串：" ~ $/.prematch;
    say "匹配之后的字符串：" ~ $/.postmatch;
    say "匹配从字符串此处开始：" ~ $/.from;
    say "匹配从字符串此处结束：" ~ $/.to;
}

# 具名 regex 是使用 my regex 表达式名 { regex 定义 } 定义的。具名 regex 可以使用 <表达式名> 来调用
my $email = 'john.doe@perl6.org';
my regex 多个字母 { <:L>+ };
my regex 点 { \. };
my regex at { \@ };
my regex 多个字母与数字 { <:L+:N>+ };

if $email ~~ / <多个字母> <点> <多个字母> <at> <多个字母与数字> <点> <多个字母> / {
  say $/ ~ " 是一个合法的Email地址";
} else {
  say "这不是合法的Email地址";
}


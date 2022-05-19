use v6;
 
# start by printing out the header. 
say "Tournament Results:\n";
 
my $file  = open 'scores.txt'; # get filehandle and... 
my @names = $file.get.words;   # ... get players. 

say @names;
 
my %matches;
my %sets;
my $a = ":";
 
for $file.lines -> $line {
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
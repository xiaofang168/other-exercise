#!/usr/bin/perl
use strict;
use warnings;

use Data::Dumper qw(Dumper);
use IO::All;
use Tie::File;
use autodie; # die if problem reading or writing a file

my $io = io('wluser_mysql_host.txt'); 
my $hostFile = "resource_host.txt";
my @lines;

while (my $line = $io->getline){
    my @hosts = split ' ', $line;
    my $oldHost = $hosts[0];
    my $newHost = $hosts[1];
    my $replaceText = "//${oldHost}";
    my $newText = "//${newHost}";

    tie(@lines,'Tie::File',$hostFile) or die; 
    foreach (@lines){
        if($_ =~/$replaceText/){
            # 替换oldHost为newHost
            s/$replaceText/$newText/; 
            print $_; 
            last;
        }
    }
	untie(@lines); 
    #print "oldHost:". $oldHost . " newHost:" . $newHost . "\n";
	#print Dumper \@hosts;
}
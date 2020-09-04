#!/bin/perl
use strict;
use warnings;

use Path::Class;
use File::Find;

use Tie::File;

my @lines;

sub wanted{
		my $folder=$File::Find::dir;
		my $file_name=$File::Find::name;
		my $count=-1;
		if($file_name =~/\.scala/){
			print $file_name."\n";
			tie(@lines,'Tie::File',$file_name) or die; 
			foreach (@lines){
				$count++;
				my $hand_text="object |trait ";
				if($_ =~/$hand_text/){
my $addRow = <<"END_MESSAGE";
/**
* \@author fangjie
* \@date Created in 下午3:50 20/1/4.
*/
END_MESSAGE
					splice(@lines,$count,0,$addRow);
					print $_; 
					last;
				}
			}
			untie(@lines); 
		}
	}
# 自下而上查找
finddepth (\&wanted,'/Users/fangjie/Downloads/test');
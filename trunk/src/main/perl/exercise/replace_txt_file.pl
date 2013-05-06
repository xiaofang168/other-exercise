#!/usr/bin/perl
use strict;
use warnings;

use Path::Class;
use File::Find;
use Tie::File;

my @lines; 

sub wanted{if(/\.java$/){  
		my $folder=$File::Find::dir;
		my $str="target";
		if(!($folder =~/\./)&&!($folder =~/$str/)){
			my $file_name=$File::Find::name;
			tie(@lines,'Tie::File',$file_name) or die; 
			foreach (@lines){
				my $hand_text="Revision: 1.0";
				if($_ =~/$hand_text/){
					s/\$Revision: 1.0/\$Revision: 2.0/; 
					print $_; 
					last;
				}

			}
			untie(@lines); 
		}
	}}
find \&wanted,'D:\base-workspace\db_migration';




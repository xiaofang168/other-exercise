#!/usr/bin/perl -w
use strict;
use warnings;
use HTML::Template;
use Perl6::Slurp;
use autodie; 
# open the html template
my $template = HTML::Template->new(filename => 'test.tmpl');

# fill in some parameters
$template->param(HOME => $ENV{HOME});
$template->param(PATH => $ENV{PATH});

# send the obligatory Content-Type and print the template output

#写文件
my $html_file = 'test.html';

#open(HANDLE, ">test.html") or die "Can't open $html_file $!";
open(HANDLE, ">",$html_file) or die "Can't open $html_file $!";
print HANDLE $template->output;  
close(HANDLE);  

#print "Content-Type: text/html\n\n", $template->output;

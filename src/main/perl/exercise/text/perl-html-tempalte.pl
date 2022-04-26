#!/usr/bin/perl -w
use strict;
use warnings;
use HTML::Template;
use Encode;

my $template = HTML::Template->new(filename => 'test2.tmpl');

$template->param(title        => 'HTML Template Example');
$template->param(is_english   => '');
$template->param(is_chinese   => '0');
$template->param(english_text => 'It is Englist');
$template->param(chinese_text => '这是汉语。');
$template->param(loop         => [
    {title => [
        {is_english   => '1'},
        {english_text => ''},
    ]},
    {title => [
        {is_chinese   => ''},
        {chinese_text => '这是汉语。'},
    ]}
]);
print "Content-type: text/html\n\n";
print encode("gbk", decode("utf-8", $template->output()));


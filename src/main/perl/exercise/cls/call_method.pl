#!/usr/bin/perl 
use warnings;
use strict;
# 引入类文件，采用相对路径
use lib ".";

use Person;
my $object = new Person();

$object->foo(POST => ':8083/data/commit', 'Content-Type' => 'application/json','dddd');
print "\n\n";

# 和上面的写法一样
$object->foo('POST',':8083/data/commit', 'Content-Type','application/json','dddd');
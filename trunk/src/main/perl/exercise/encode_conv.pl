use strict;
use warnings;
use Encode;
use Encode::CN;
use Encode::Detect::Detector;
use Win32::File;
use Path::Class;
use File::Find;
sub wanted{if(/\.java$/){  
    #print $File::Find::name."\n";#输出路径跟文件名  #你要进行的操作 
    my $file=$File::Find::name;
    my $attr;
    Win32::File::GetAttributes($file, $attr);
    my $flag = 1;
    my $newfile = $file.".tmp";
    open OLD, $file or die "open $file failed: $!";
    open NEW, ">$newfile" or die "open $newfile failed: $!";
    while (my $line = <OLD>) {
        if(detect($line) eq "UTF-8") {
            $flag = 0;
            last;
        }
        $line = decode("gb2312", $line);
        print NEW encode("utf8", $line);
    }
    close OLD;
    close NEW;
    if($flag == 1) {
        unlink $file;
        rename $newfile, $file;
        Win32::File::SetAttributes($file, $attr) or die "set attribute failed: $!";
        print "$file change to utf8\n";
    } else {
        unlink $newfile;
        print "$file no change\n";
    }
    }}
sleep 1;
find \&wanted,'D:\ckfinder_java_2.3.1\ckfinder\_sources\CKFinder for Java';

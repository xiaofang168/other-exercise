use strict;
use warnings;

use Path::Class;
use File::Find;

my $dir = dir('D:\360安全浏览器下载\ckfinder_java_2.3.1\ckfinder\_sources\CKFinder for Java'); # foo/bar

# Iterate over the content of foo/bar
while (my $file = $dir->next) {
    
    # See if it is a directory and skip
    next if $file->is_dir();
    
    # Print out the file name and path
    print $file->stringify . "\n";
}

my $str4="FileEditor";
sub wanted{if(/\.java$/){  
		#print $File::Find::name."\n";#输出路径跟文件名  #你要进行的操作 
		my $file_name=$File::Find::name;
		open (INFILE, $file_name);
		while(<INFILE>){
		    if ($_=~/$str4/ ){
		            print "查找到的文件位置：".$file_name."\n";
		            last; #只要找到匹配就输出1并退出此次循环
		    } 

		}   
		close(INFILE);
	}}
find \&wanted,'D:\360安全浏览器下载\ckfinder_java_2.3.1\ckfinder\_sources\CKFinder for Java';
use strict;
use warnings;
use File::Copy;

sub copyfile{
	my($source,$dest)=@_;
	copy($source,$dest)
	#print $source.">>".$dest."\n";
}

sub open_display_file
{
	# the filename should be passed in as a parameter
	my $filename = shift;
	# open file to the handle <FILE>
	open(FILE, $filename) || die "Could not read from $filename, program halting.";
	# read the first line, and chomp off the newline
	#chomp(my $firstline = <FILE>);
	#print $firstline;
	# read other into array
	my @all = <FILE>;
	my $line = "";
	my $count = 0;
	foreach $line (@all){
		#去掉换行符;
		my $s = chomp($line);
		# 用正则表达式抓取路径字符串
		if($line =~ /path=\"(.*?jar)\"/){
			#print $&."\n";
			#$count = $count + 1;
			#print $1.">>>".$count."\n"
			# 调用copy 函数
			copyfile($1,"C:\\Users\\fangjie1\\Desktop\\spray-extjs\\lib")
			#print $1."\n";
		}
		
	}
	close FILE;
}
# a test to show how to call my function
&open_display_file('path.txt');
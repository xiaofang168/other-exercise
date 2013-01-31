#!usr/bin/perl
#perl script used to connect to Oracle
use strict;
use warnings;
use DBI;
use Encode;

my $tnsname="yppt";
my $username="jxyppt";
my $password="jxyppt";

my $dbh=DBI->connect("dbi:Oracle:$tnsname", $username, $password) or die "Cannot conenct db: $DBI::errstr\n";
print "I have connected to the Oracle database!\n";

$dbh->{LongReadLen} = 1048576;
my $sth=$dbh->prepare("select t.comments,t.column_name from user_col_comments t   where t.table_name='QKRY'");
#my $fields = $sth->{NUM_OF_FIELDS}; 
#获得当前表的字段数
#for(my $i=0;$i<$fields;$i++){ 
	#my $col_name=$sth->{NAME}->[$i]; #字段名称 
	#my $col_type=$sth->{TYPE}->[$i]; #字段类型
	#print encode("gbk", decode("utf-8","字段名称：".$col_name." 字段注释：".$col_type));
	#print "\n";
#}
#my $names = $sth->{'NAME'};
#my $numFields = $sth->{'NUM_OF_FIELDS'};
#for (my $i = 0;  $i < $numFields;  $i++) {
   	#printf("%s%s", $$names[$i], $i ? "," : "");
#}

$sth->execute();
my @recs;

#for ($x=0; $x<11; $x++) {
	#print $nums[$x];
#}
#while (@recs = $sth->fetchrow_array()) {
	  #print $recs[0].":".$recs[1]."\n";
#}
my $matrix_ref = $sth->fetchall_arrayref(); 

my $rows= (!defined($matrix_ref)?0:scalar(@{$matrix_ref}));
my $cols= ($rows == 0 ? 0:scalar(@{$matrix_ref->[0]}));

#define array
our $array=[];
#print each row
for(my $i = 0; $i < $rows; $i++){ 
	if($i%2==0){
		my $td1=$matrix_ref->[$i-2][0];
		my $td2=lc("o.".$matrix_ref->[$i-2][1]);
		my $td2id=lc($matrix_ref->[$i-2][1]);
		my $td3=$matrix_ref->[$i-1][0];
		my $td4=lc("o.".$matrix_ref->[$i-1][1]);
		my $td4id=lc($matrix_ref->[$i-1][1]);
		push $array, {td1=>$td1,td2=>$td2,td2id=>$td2id,td3=>$td3,td4=>$td4,td4id=>$td4id}; 
		#print $td1.":".$td2."  ".$td2id."  ".$td3.$td4." ".$td4id;
	}
}


$dbh->disconnect;
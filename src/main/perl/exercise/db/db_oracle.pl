#!usr/bin/perl
#perl script used to connect to Oracle
use strict;
use warnings;
use DBI;

my $tnsname="yppt";
my $username="jxyppt";
my $password="jxyppt";

my $dbh=DBI->connect("dbi:Oracle:$tnsname", $username, $password) or die "Cannot conenct db: $DBI::errstr\n";
print "I have connected to the Oracle database!\n";

$dbh->{LongReadLen} = 1048576;
#my $sth = $dbh->prepare(qq{select * from infos});
my $sth=$dbh->prepare(" select * from infos" );
$sth->execute();
my @recs;
while (@recs = $sth->fetchrow_array()) {
    # print $recs[0].":".$recs[1].":".$recs[2]."\n";
	#print $recs[10];
	$dbh->do("insert into testf (id,content) values ($recs[0],EMPTY_CLOB())");  
    my $sth2=$dbh->prepare("select content from testf where id = ? for update",{ ora_auto_lob => 0 }); 
    $sth2->execute($recs[0]); 
    my $char_locator=$sth2->fetchrow_array(); 
    #通过主键定位要插入CLOB数据的记录，并获取指针 
    $dbh->ora_lob_write($char_locator,1,$recs[10]);
}
$dbh->disconnect;
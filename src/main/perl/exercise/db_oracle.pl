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
	 print $recs[10];
}
$dbh->disconnect;

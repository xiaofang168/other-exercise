#!/usr/bin/perl
use strict;
use warnings;
use feature 'say';

my $regex = qr/(?=\p{Lu})(?i:daisy|john|fred|june)/;

my $test = 'Later John said blah and JOHN said ignore john .....';

while( $test =~ /($regex)/g ) {
	say $1;
}
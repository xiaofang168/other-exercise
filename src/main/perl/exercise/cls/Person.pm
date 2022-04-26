#!/usr/bin/perl 

package Person;

sub new {
    my $class = shift;
}

sub foo {
	# self是本身的对象，不占传递的参数位置
	my ($self, $method, $uri, @headers) = @_;
    print $self,"\n";
	print $method,"\n";
	print $uri,"\n";
	print scalar @headers,">>>\n";
	print $headers[0],"\n";
	print $headers[1],"\n";
	my $content = (@headers % 2) ? pop @headers : '';
	print $content . "????\n";
}
# 1;必须写
1;
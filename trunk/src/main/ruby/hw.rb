#引入类文件
require_relative "Test"

puts "hello world"
x=10
y=11
z= if x<y
	true
else
	false
end
=begin
	puts z
=end

puts nil||2008
puts false||2008
puts "ruby"||2008


@variable ||="default value" 
puts @variable 

var1='2'
var2='5'
puts var2+var1

def sys_hello param
	puts param
end

sys_hello "hello world"

test=Test.new
puts (test.test "test")

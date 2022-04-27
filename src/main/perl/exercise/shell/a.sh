#!/bin/bash
return_value(){
	#=号一定要挨着
	response=$(http v2-static.etouch.cn/apis/holiday-in-law.json --ignore-stdin)
	echo $response
}
return_value
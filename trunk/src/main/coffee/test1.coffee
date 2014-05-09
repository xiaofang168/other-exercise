square = (x) -> x * x
cube   = (x) -> square(x) * x
console.log cube(5)

[PAREN, BRACKET, CURVE, LIST, STATEMENT_LIST, WRAP_BLOCK, BLOCK, MAYBE, STATEMENT, CLAUSE] =  [1...100]


tokenNameMap = {PAREN, BRACKET, CURVE, LIST, STATEMENT_LIST, WRAP_BLOCK, BLOCK, MAYBE, STATEMENT, CLAUSE}

console.log PAREN

window.sumX = (form) ->
	input1 = form.input1.value
	input2 = form.input2.value
	document.getElementById("result").innerHTML = parseInt(input1, 10) + parseInt(input2, 10)
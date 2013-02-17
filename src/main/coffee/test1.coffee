square = (x) -> x * x
cube   = (x) -> square(x) * x
#console.log cube(5)

window.sumX = (form) ->
    input1 = form.input1.value
    input2 = form.input2.value
    document.getElementById("result").innerHTML = parseInt(input1, 10) + parseInt(input2, 10)
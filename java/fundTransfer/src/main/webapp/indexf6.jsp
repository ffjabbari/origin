<!DOCTYPE html>
<html>
<body>

<p>The toString() method returns the function as a string:</p>
<div class="entry foreground-color">
     <form>
         <input type="text" id="fred" size="60"/>
     </form>
 </div>

<button onclick="myFunction(1,2)">Try it</button>

<p id="demo"></p>

<script>

var x = 10;
var o = { x: 15 };
 
function f()
{
    alert(this.x);
}
 
f();
f.call(o);
 


function myFunction(a, b) {
	
	document.getElementById("demo").innerHTML = myFunction.toString();
	alert(f());
	//alert(foo.toString());
	
    return a * b;
}

</script>

</body>
</html>

<!DOCTYPE html>
<html>
<body>
<H1>Hi Tom</H1>
<p>Click the button to perfom a global (/g) search for the letters "ain" (/ain) in a string , and display the matches.</p>
<p>The rain in SPAIN stays mainly in the plain</p>

<div class="entry foreground-color">
     <form>
         <input type="text" id="fred" size="60"/>
     </form>
 </div>

<button onclick="myFunction()">Try it</button>
<button onclick="myFunctionn(2,3)">Try it Again</button>
<button onclick="myFunctionnn(2,3)">Try it Again Sam</button>
 
<p id="demo"></p>
<p id="demoo"></p>

<script>
function myFunction() {
    var str1 = "The rain in SPAIN stays mainly in the plain"; 
    var str2 = document.forms[0].elements[0].value;
    var str = document.getElementById("fred").value;
    //alert(str);
    var res = str.match(/ain/g);
    document.getElementById("demo").innerHTML = res;
}
function myFunctionn(a, b) {
	document.getElementById("demoo").innerHTML = myFunctionn.toString() + " if executed, value is " + a * b;
    return a * b;
}
function myFunctionnnn() {
	return "hi";
}
function myFunctionnn(a, b) {
	//var bbb = myFunctionnnn.toString();
	var bbb = myFunctionnnn.toString();
	alert("aaa" + bbb);
	return "sss";
}


</script>

</body>
</html>
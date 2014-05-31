<!DOCTYPE html>
<html>
<body>

<p>Click the button to perfom a global (/g) search for the letters "ain" (/ain) in a string , and display the matches.</p>
<p>The rain in SPAIN stays mainly in the plain</p>

<div class="entry foreground-color">
     <form>
         <input type="text" id="fred" name="commands" size="60"/>
     </form>
 </div>

<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>

<script>
function myFunction() {
    var str1 = "The rain in SPAIN stays mainly in the plain"; 
    var str2 = document.forms[0].elements[0].value;
    var str = document.getElementById("fred").value;
    //alert(str);
    var res = str.match(/ain/g);
    document.getElementById("demo").innerHTML = res;
}
</script>

</body>
</html>
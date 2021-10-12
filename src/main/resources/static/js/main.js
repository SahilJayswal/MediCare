var firstname =fname.toUpperCase();
var lastname=lname.toUpperCase();
var fullname=firstname+" "+lastname;
alert("Welcome "+fullname);
var id = document.getElementById("id").value;
console.log(id);
localStorage.setItem("id1", id);
var userId = localStorage.getItem("id");



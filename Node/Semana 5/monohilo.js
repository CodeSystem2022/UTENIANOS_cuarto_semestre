console.log('Hola cohorte 2022')
var i = 0;
var z = 0;

setInterval(function() {
  console.log(i);
  i++;
  if (i > 5) {
    console.log('Forzamos un error');
    var a = 3 + z;
  }
}, 1000);

//Ejecución:
//1
//2
//3
//4
//5
//Forzamos un error

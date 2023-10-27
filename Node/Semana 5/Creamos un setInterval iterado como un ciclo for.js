// Imprimimos un mensaje de bienvenida
console.log("Hola a toda la cohorte 2022");

// Declaramos una variable `i` e inicializamos a 0
var i = 0;

// Creamos un setInterval que ejecuta una función cada 1000 milisegundos (1 segundo)
setInterval(function() {
  // Imprimimos el valor de la variable `i` en la consola
  console.log(i);

  // Incrementamos el valor de `i` en 1
  i++;
}, 1000);

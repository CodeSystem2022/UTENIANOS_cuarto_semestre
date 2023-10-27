function soyAsincrona() {
  // Declaramos una variable para el callback
  let miCallback;

  // Llamamos a la función `setTimeout()`
  setTimeout(() => {
    // Definimos el callback
    miCallback = () => {
      console.log("Hola, soy una función asíncrona");
      console.log("Iniciando el proceso...");
    };

    // Llamamos a la función `soyAsincrona()` con el callback
    soyAsincrona(miCallback);
  }, 1000);

  console.log("Terminando el proceso...");
}

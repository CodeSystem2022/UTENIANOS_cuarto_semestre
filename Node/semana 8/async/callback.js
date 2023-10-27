function soyAsincrona() {
  console.log("Hola, soy una función asíncrona");
  console.log("Iniciando el proceso.");

  // Llamamos a la función `soyAsincrona()` de forma asíncrona
  setTimeout(soyAsincrona, 1000);

  console.log("Terminando el proceso...");
}


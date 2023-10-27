//Ejemplo de eventloop

const eventloop = require("events").EventEmitter;

// Añadimos un manejador de eventos
eventloop.on("tick", () => {
    console.log("¡Es hora!");
});

// Iniciamos el eventloop
eventloop.run();

//const eventloop = require("events").EventEmitter;: Importamos el módulo events que proporciona la clase EventEmitter.
//eventloop.on("tick", () => { ... });: Añadimos un manejador de eventos al eventloop. El manejador se ejecuta cada segundo.
//eventloop.run();: Iniciamos el eventloop.

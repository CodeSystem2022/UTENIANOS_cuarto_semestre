function hola(nombre) {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            console.log('Hola, ' + nombre);
            resolve(nombre);
        }, 1000);
    });
}

function hablar() {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            console.log('Bla bla bla bla...');
            resolve();
        }, 1000);
    });
}

function adios(nombre) {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            console.log('Adios, ' + nombre);
            reject('Hay un error');
        }, 1000);
    });
}

console.log('Iniciando el proceso.');

hola('Ariel')
    .then(hablar)
    .then(hablar)
    .then(hablar)
    .then(adios)
    .then((nombre) => {
        console.log('Terminando el proceso');
    })
    .catch((error) => {
        console.log('Ha habido un error:');
        console.log(error);
    });


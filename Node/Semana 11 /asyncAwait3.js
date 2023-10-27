async function hola(nombre){
    return new Promise(function(resolve,reject){
        setTimeout(function(){
            console.log('Hola '+ nombre);
            resolve(nombre);
        },1500);
    });
}

async function hablar(nombre){
    return new Promise((resolve,reject)=>{
        setTimeout(function(){
            console.log('Bla bla bla bla...');
            resolve(nombre);
        },1000);
    });
}

async function adios(nombre){
    return new Promise((resolve,reject)=>{
        setTimeout(function(){
            console.log('Adios '+ nombre);
            resolve();
        },1000);
    });
}

async function main(){
    let nombre = await hola('Carlos');
    await hablar();
    await hablar();
    await hablar();
    await adios(nombre);
    console.log('Terminamos el proceso');
}

console.log('Empezamos el proceso');
main();
console.log('Va a ser la segunda instruccion que se ejecute');


// Language: english
function sayHello(name){
    return new Promise((resolve,reject)=>{
        setTimeout(function(){
            console.log('Hello '+ name);
            resolve(name);
        },1500);
    });
}

function talk(name){
    return new Promise((resolve,reject)=>{
        setTimeout(function(){
            console.log('Bla bla bla bla...');
            resolve(name);
        },1000);
    });
}

function bye(name){
    return new Promise((resolve,reject)=>{
        setTimeout(function(){
            console.log('Bye '+ name);
            resolve();
        },1000);
    });
}

async function conversation(name) {
    console.log("Starting async conversation...");
    await sayHello(name);
    await talk();
    await talk();
    await talk();
    await bye(name);
    console.log("process finished");
}

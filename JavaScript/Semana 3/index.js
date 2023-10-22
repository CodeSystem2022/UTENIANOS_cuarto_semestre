const shopContent = document.getElementById("shopContent");
const cart = [ ]; // este es nuestro carrito, un array vacío lo creamos en semana dos//
productos.forEach((product) =>{
    const content= document.createElement("div");
    content.innerHTML = `
    <img src="${product.img}">
    <h3>${product.productName}</h3>
    <p>${product.price} $</p>
    `;
    shopContent.append(content);
    const buyButton = document.createElement("Button"); //se crea botón de compras en semana 2//
    buyButton.innerText = "Comprar";

content.append(buyButton);
    buyButton.addEventListener("click", () =>{
        const repeat = cart.some((repeatProduct) => repeatProduct.id ===product.id);
        if(repeat){
           cart.map((prod)=> {
                if (prod.id === product.id) {
                 prod.quanty++;
                }
            });
        }else{
        }
        cart.push({
            id: product.id,
            productName:product.productName,
            price:product.price,
            quanty: product.quanty,
            img: product.img,
        });
    console.log(cart);
    });
});
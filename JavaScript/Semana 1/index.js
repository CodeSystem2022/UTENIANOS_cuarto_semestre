const shopContent = document.getElementById("shopContent");
productos.forEach((product) => {
    const content = document.createElement("div");
    content.innerHTML = `
    <img src="${product.img}"/>
    <h3>${product.title}</h3>
    <p>${product.price} $</p>
    `;
    shopContent.append(content);
});
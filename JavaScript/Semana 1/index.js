const shopContent = document.getElementById("shopContent");
product.forEach((product) => {
    const content = document.createElement("div");
    content.innerHTML = `
    <img src="${product.img}"/>
    <h3>${product.productName}</h3>
    <P>${product.price} $</P>
     `;
    shopContent.append(content);
});
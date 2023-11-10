const { create } = require("domain");

const modalContainer =document.getElementById("modal-container");
const modalOverlay =document.getElementById("modal-overlay");

const cartBtn = document.getElementById("cart-btn");
const cartCounter = document.getElementById("cart-counter");
const displayCart = () => {
       modalContainer.innerHTML = "";
     modalContainer.style.display = "block";
     modalOverlay.style.display = "block";
     //modal header
     const modalHeader = document.createElement("div");
     const modalClose = document.createElement ("div");
     modalClose.innerText = "❌"
     modalClose.className = "modal-close";
     modalHeader.append(modalClose)

     modalClose.addEventListener("click", () => {
        modalContainer.style.display = "none";
        modalOverlay.style.display = "none";
    })
     
     const modalTitle = document.createElement("div");
     modalTitle.innerText = "cart";
     modalTitle.className = "modal-title";
     modalHeader.append(modalTitle);

     modalContainer.append(modalHeader);
     //modal Body
     if (cartLength > 0){
     cart.forEach((product) => {
        const modalBody = document.createElement("div");
        modalBody.className = "modal-body"
        modalBody.innerHTML = `
        <div class="product">
           <img class="product-img" src="${product.img}" />
           <div class="product-info">
               <h4>${product.productname}</h4>
           <div> 
          <div class= "quantity">
            <span class="quantity-btn-decrese"></span>
            <span class="quantity-input">${product.quanty}</span>
            <span class="quantity-btn-increse">+</span>
           </div>
             <div class="price">${product.price*product.quanty}$</div>
             <div class="delete-product">❌</div>
            </div>
            `;
    modalContainer.append(modalBody); 
    
   

  
    const decrese = modalBody.querySelector(".quantity-btn-decrese");
    decrese.addEventListener("click", () => {
        if (product.quanty !== 1) {
            product.quanty -- ;
            displayCart();
        }
    });
    const increse = modalBody.querySelector(".quantity-btn-increse");
    increse.addEventListener("click", () => {
        product.quanty++; 
        displayCart();
    });  
        //Delete product
         const deleteProduct = modalBody.querySelector(".delete-product");
         deleteProduct.addEventListener("click", () => {
        })
       });
       

      
      
      
      
      
      
       //modal fotter
      const total = cart.reduce((acc, el) => acc + el.price * el.quanty, 0);
      
      const modalFooter = document.createElement("div");
      modalFooter.className = "modal-footer"
      modalFooter.innerHTML = `
        <div class="total-price">${total}</div>
        <button class="btn-primary" id=checkout-btn">go to checkout</button>
        <div id="button-checkout" -</div>
        `;
       modalContainer.append(modalFooter);
       //mp;
       const mercadopago = new MercadoPago("public_key",{
        locale: "es-AR",//The most common are: 'pt-BR', 'es-AR' SND 'en-US' lo mas común en moneda brasileña y estadounidense
      });   
      const checkoutButton = modalFooter.querySelector("#chekout-btn");
      checkoutButton.addEventListener("click", function (){
        checkoutButton.remove();
// orden de pedido con monto total de mercado pago
        const orderData ={ 
          quantity: 1,
          description: "compra de ecomerce",
          price: total, 
        };
        fetch("https://localhost:8080/create_preference", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
       }; 
        body: JSON.stringify(orderData),
      })
      .then(function(response){ 
        return response.json();
      })
      .then(function(response){ 
       createCheckoutButton(preference.id);
      })  
      .catch(function(){ 
        alert("Unexpected error");
      });
    });     
      
    
    function createCheckoutButton(preferenceId) {
     //Initializa the checkout
      const bricksBuilder =mercadopago.bricks();
      
      const renderComponent = async (bricksBuilder) => {
        //if (windows.checkoutButton) checkoutButton.unmount(),
         
        await bricksBuilder.create(
          "wallet",
          "button-checkout", // class/id where the payment button will be displayed
          { 
            initialization: { 
              preferenceId: preferenceId,
            };
            callbacks: {  
              onError: (error) => console.error(error),
              onReaDY: () => {},
            },
          }
        },
      }, 
      window.checkoutButton = renderComponent(bricksBuilder);
    }
  } else {
    const modalText = document.createElement("h2");
    modalText.className = "modal-body";
    modalText.innerText = "your cart is empty";
    modalContainer.append(modalText);
    }
};

cartBtn.addEventListener("click",displayCart);






const deleteProduct =()=>{
  const foundId = cart.findIndex((Element) => Element.id === id);
  cart.splice(found, 1);
  displayCart();
};






const displayCartCounter= () => {
    const cartLength = cart.reduce((acc, el) => acc + el.quanty, 0);
    if (cartLength > 0) {
      cartCounter.style.display = "block";
      cartCounter.innerText = cartLength;
    } else {
      cartCounter.style.display = "none";
    }
};
   
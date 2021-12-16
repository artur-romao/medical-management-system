function keydownEvent(event) {
    if (event.key === "Enter") {
        let text = event.target.value
        event.target.value = ""
        let messageFeed = document.querySelector("#messageFeed")
        let message = document.createElement("p")
        message.classList.add("chatWindow")
        message.innerText = text
        messageFeed.appendChild(message)
    }
}

function enviar(){
    let texto = document.getElementById("texto");
    texto.value='';
}
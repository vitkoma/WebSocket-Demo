var websocket;

function login() {

    var wsUri = "ws://" + window.location.host + window.location.pathname + "hello/"  + nameField.value;

    websocket = new WebSocket(wsUri);

    websocket.onopen = function(evt) {
        printMessage("CONNECTED");
    };

    websocket.onmessage = function(evt) {
        printMessage(evt.data);
    };

}

function sendMessage() {
    websocket.send(messField.value);
}

/**
 * Helper function for printing messages
 * @param message
 */
function printMessage(message) {
    var att = document.createAttribute("class");
    att.value = "alert alert-info";
    var e = document.createElement("div");
    e.setAttributeNode(att);
    e.innerHTML = message;
    document.getElementById("output").appendChild(e);
}

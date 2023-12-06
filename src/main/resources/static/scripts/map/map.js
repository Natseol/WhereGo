function navBold() {
    document.getElementById("navigation-map-button").style.fontWeight = "bold";
}
navBold();

Array.from(document.getElementsByClassName("event-box")).forEach(item => {
    item.onclick = function() {
        commonModal.show();
    };
});
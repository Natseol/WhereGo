function navBold() {
    document.getElementById("navigation-map-button").style.fontWeight = "bold";
}
navBold();

Array.from(document.getElementsByClassName("event-box")).forEach(item => {
    item.onclick = function() {
        commonModal.show();
    };
});

let mapOptions = {
    center: new naver.maps.LatLng(37.5726241, 126.9760053),
    zoom: 15
};

// let map = new naver.maps.Map('map-img', mapOptions);

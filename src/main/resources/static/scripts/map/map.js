function navBold() {
    document.getElementById("navigation-map-button").style.fontWeight = "bold";
}
navBold();

let mapOptions = {
    center: new naver.maps.LatLng(mapLot, mapLat),
    zoom: 18
};

let map = new naver.maps.Map('map-img', mapOptions);

var infoWindow = new naver.maps.InfoWindow({
    content: '<div style="width:150px;text-align:center;padding:10px;">The Letter is <b>"g"</b>.</div>'
});

let latN = map.getBounds()._max.y;
let latS = map.getBounds()._min.y;
let lotW = map.getBounds()._min.x;
let lotE = map.getBounds()._max.x;

const getEvents = async () => {
    const list = (await axios({
        method: 'post',
        url: '/map',
        data: {
            latN: map.getBounds()._max.y,
            latS: map.getBounds()._min.y,
            lotW: map.getBounds()._min.x,
            lotE: map.getBounds()._max.x
        }
    })).data;
    console.log(list);

    const eventContainer = document.getElementById("event-container");
    eventContainer.innerHTML = "";
    list.forEach(item => {
        eventContainer.appendChild(createEventBox(item));
        marker(item);
    })
};

function marker(item) {
    new naver.maps.Marker({
    position: new naver.maps.LatLng(item.lot, item.lat),
    map: map
})
};

function createEventBox(item) {    
    let eventBox = document.createElement('div');
    eventBox.className = 'event-box rounded-4 shadow-style';
    eventBox.onclick = function() {modalShow(item)};

    let imgBox = document.createElement('div');
    imgBox.className = 'event-img-box';
    let img = document.createElement('img');
    img.className = 'event-img';
    img.src = item.mainImg
    imgBox.appendChild(img);
    eventBox.appendChild(imgBox);

    let contentBox = document.createElement('div');
    contentBox.className = 'event-content-box';

    let titleBox = document.createElement('div');
    titleBox.className = 'event-title-box';
    let eventTitle = document.createElement('div');
    eventTitle.className = 'event-title';
    eventTitle.textContent = item.title
    let eventCodename = document.createElement('div');
    eventCodename.className = 'event-codename';
    eventCodename.textContent = item.codename
    titleBox.appendChild(eventTitle);
    titleBox.appendChild(eventCodename);
    contentBox.appendChild(titleBox);

    let eventPlace = document.createElement('div');
    eventPlace.className = 'event-place';
    eventPlace.textContent = item.place
    contentBox.appendChild(eventPlace);

    contentBox.appendChild(document.createElement('br'));

    let eventDate = document.createElement('div');
    eventDate.className = 'event-date';
    eventDate.textContent = item.date
    contentBox.appendChild(eventDate);

    let eventFee = document.createElement('div');
    eventFee.className = 'event-free';
    eventFee.textContent = item.isFree
    contentBox.appendChild(eventFee);

    eventBox.appendChild(contentBox);

    return eventBox;
}

getEvents();
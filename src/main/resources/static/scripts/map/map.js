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

let date = new URL(location.href).searchParams.get("date");

const getEvents = async () => {
    const list = (await axios({
        method: 'post',
        url: '/map',
        data: {
            latN: map.getBounds()._max.y,
            latS: map.getBounds()._min.y,
            lotW: map.getBounds()._min.x,
            lotE: map.getBounds()._max.x,
            date: date
        }
    })).data;

    const eventContainer = document.getElementById("event-container");
    eventContainer.innerHTML = "";
    markers=[];
    infoWindows=[];
    list.forEach(item => {
        eventContainer.appendChild(createEventBox(item));
        markers.push(marker(item));
        infoWindows.push(info(item.title));
    })
};

var bounds = map.getBounds(),
    southWest = bounds.getSW(),
    northEast = bounds.getNE(),
    lngSpan = northEast.lng() - southWest.lng(),
    latSpan = northEast.lat() - southWest.lat();

var markers = [],
    infoWindows = [];

function info(text) {
    var infoWindow = new naver.maps.InfoWindow({
        content: text
    });
    return infoWindow;
}

for (var i = 0, ii = markers.length; i < ii; i++) {
    naver.maps.Event.addListener(markers[i], 'click', getClickHandler[i]);
}

// 해당 마커의 인덱스를 seq라는 클로저 변수로 저장하는 이벤트 핸들러를 반환합니다.
function getClickHandler(seq) {
    return function (e) {
        var marker2 = markers[seq],
        infoWindow2 = infoWindows[seq];
        if (infoWindow2.getMap()) {
            infoWindow2.close();
        } else {
            infoWindow2.open(map, marker2);
        }
    }
}

function marker(item) {
    let marker1 = new naver.maps.Marker({
        position: new naver.maps.LatLng(item.lot, item.lat),
        map: map
    })
    return marker1;
};

naver.maps.Event.addListener(map, 'idle', function() {
    updateMarkers(map, markers);
});

function updateMarkers(map, markers) {

    var mapBounds = map.getBounds();
    var marker, position;

    for (var i = 0; i < markers.length; i++) {

        marker = markers[i]
        position = marker.getPosition();

        if (mapBounds.hasLatLng(position)) {
            showMarker(map, marker);
        } else {
            hideMarker(map, marker);
        }
    }
}

function showMarker(map, marker) {

    if (marker.getMap()) return;
    marker.setMap(map);
}

function hideMarker(map, marker) {

    if (!marker.getMap()) return;
    marker.setMap(null);
}


function createEventBox(item) {
    let eventBox = document.createElement('div');
    eventBox.className = 'event-box rounded-4 shadow-style';
    eventBox.onclick = function () { modalShow(item) };

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
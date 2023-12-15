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
let now = new Date();
let today = now.getFullYear() +"-"+ (now.getMonth()+1) +"-"+ now.getDate();

var bounds = map.getBounds(),
    southWest = bounds.getSW(),
    northEast = bounds.getNE(),
    lngSpan = northEast.lng() - southWest.lng(),
    latSpan = northEast.lat() - southWest.lat();

var markers = [],
    infoWindows = [];

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

    markers.forEach(marker=>{
        marker.onRemove();
    })
    markers=[];
    infoWindows=[];
    list.forEach(item => {
        if (date==null) {date=today}
        eventContainer.appendChild(createEventBox(item, date));
        infoWindows.push(info(item.title));
        markers.push(marker(item));
    })

    for (var i = 0, ii = markers.length; i < ii; i++) {    
        naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i));
    }        
};

function info(text) {
    var infoWindow = new naver.maps.InfoWindow({
        content: text
    });
    return infoWindow;
}

// 해당 마커의 인덱스를 seq라는 클로저 변수로 저장하는 이벤트 핸들러를 반환합니다.
function getClickHandler(seq) {
    return function (e) {
        var marker = markers[seq],
        infoWindow = infoWindows[seq];
        if (infoWindow.getMap()) {
            infoWindow.close();
        } else {
            infoWindow.open(map, marker);
        }
    }
}

function checkIcon(item) {    
    if (item.codename=="문화교양/강좌") return "/images/문화.png";
    if (item.codename=="전시/미술") return "/images/전시.png";
    if (item.codename=="뮤지컬/오페라") return "/images/뮤지컬.png";
    if (item.codename=="연극") return "/images/연극.png";
    if (item.codename=="무용") return "/images/무용.png";
    if (item.codename=="영화") return "/images/영화.png";
    if (item.codename=="국악") return "/images/국악.png";
    if (item.codename=="콘서트") return "/images/콘서트.png";
    if (item.codename=="클래식") return "/images/클래식.png"
    if (item.codename=="독주/독창회") return "/images/독주.png";
    if (item.codename=="축제-시민화합") return "/images/축제-시민화합.png";
    if (item.codename=="축제-자연/경관") return "/images/축제-자연.png";
    if (item.codename=="축제-전통/역자") return "/images/축제-전통.png";
    if (item.codename=="축제-문화/예술") return "/images/축제-문화.png";
    if (item.codename=="축제-기타") return "/images/축제-기타.png";
    if (item.codename=="기타") return "/images/기타.png";    
    return "/images/기타.png";
}

function marker(item, index) {
    let marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(item.lot, item.lat),
        map: map,
        title: item.title,
        // draggable: true,
        icon: {
            url: checkIcon(item),
            size: new naver.maps.Size(50, 50),
            scaledSize: new naver.maps.Size(50, 50),
            origin: new naver.maps.Point(0, 0),
            anchor: new naver.maps.Point(25, 0)
        }
    })    
    return marker;
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


function createEventBox(item, date) {
    let eventBox = document.createElement('div');
    eventBox.className = 'event-box rounded-4 shadow-style';
    eventBox.onclick = function () { modalShow(item, date) };

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

    let eventDate = document.createElement('div');
    eventDate.className = 'event-date';
    eventDate.textContent = item.date
    contentBox.appendChild(eventDate);

    let eventFee = document.createElement('div');
    eventFee.className = 'event-free';
    eventFee.textContent = item.isFree
    contentBox.appendChild(eventFee);

    eventBox.appendChild(contentBox);

    let eventIcon = document.createElement('img');
    eventIcon.className = 'event-icon';
    eventIcon.src = checkIcon(item);
    eventBox.appendChild(eventIcon);

    return eventBox;
}

getEvents();
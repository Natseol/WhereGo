function locateMap() {
    window.location.href="/map"
}

function locateCalendar() {
    window.location.href="/calendar"
}

function locateBookmark() {
    if (userId=="") {
        alert("로그인 후 이용가능합니다");        
    } else {
        window.location.href="/bookmark"
    }
}
function navBold() {
    document.getElementById("navigation-bookmark-button").style.fontWeight = "bold";
}
navBold();

const eventForm = document.querySelectorAll(".event-form");
eventForm.forEach(item => {
    item.onsubmit = (e) => {
        e.preventDefault();
        var checkAdd = confirm("즐겨찾기에서 삭제합니다");
        if (checkAdd) {
            e.target.submit();
        } else {
            location.reload();
        };
    };
});

eventForm.forEach(item => {
    item.onclick = function () {
        const addBook = async () => {
            const event = (await axios({
                method: 'post',
                url: '/event',
                data: {
                    eventId: this.querySelector("input").value
                }
            })).data;
            modalShow(event, event.endDate);
        }
        addBook();
    };
});
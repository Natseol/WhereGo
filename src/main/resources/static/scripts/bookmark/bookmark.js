function navBold() {
    document.getElementById("navigation-bookmark-button").style.fontWeight = "bold";
}
navBold();

const eventBox = document.querySelectorAll(".event-box");
eventBox.forEach(item => {
    item.onclick=function() {
        const addBook = async() => {            
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

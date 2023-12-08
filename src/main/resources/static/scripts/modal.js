const commonModal = new bootstrap.Modal(document.getElementById('commonModal'))
function modalShow(item) {
    document.getElementById("modal-img").src = item.mainImg
    document.getElementById("modal-codename").innerHTML = item.codename
    document.getElementById("modal-title").innerHTML = item.title
    document.getElementById("modal-guname").innerHTML = item.guname
    document.getElementById("modal-place").innerHTML = item.place
    document.getElementById("modal-date").innerHTML = item.date
    document.getElementById("modal-trgt").innerHTML = item.useTrgt
    document.getElementById("modal-free").innerHTML = item.useFree
    document.getElementById("modal-map-button").onclick = function () {
        location.href = "map?id=" + item.id;
    }
    document.getElementById("modal-link-button").onclick = function () {
        window.open(item.hmpgAddr);
    }
    document.getElementById("modal-star-button").onclick = function () {
        console.log("클릭");
        const addBook = async () => {            
            const list = (await axios({
                method: 'post',
                url: '/bookmark/add',
                data: {
                    userId: userId,
                    eventId: item.id
                }
            })).data;
            console.log(list);
        }
        addBook();
    }
    commonModal.show();
}
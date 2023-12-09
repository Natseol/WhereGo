const commonModal = new bootstrap.Modal(document.getElementById('commonModal'))
function modalShow(item, date) {
    document.getElementById("modal-img").src = item.mainImg
    document.getElementById("modal-codename").innerHTML = item.codename
    document.getElementById("modal-title").innerHTML = item.title
    document.getElementById("modal-guname").innerHTML = item.guname
    document.getElementById("modal-place").innerHTML = item.place
    document.getElementById("modal-date").innerHTML = item.date
    document.getElementById("modal-trgt").innerHTML = item.useTrgt
    document.getElementById("modal-free").innerHTML = item.useFree
    document.getElementById("modal-map-button").onclick = function () {
        location.href = "map?id=" + item.id + "&date=" + date;
    }
    document.getElementById("modal-link-button").onclick = function () {
        window.open(item.hmpgAddr);
    }
    document.getElementById("modal-star-button").onclick = function () {        
        const addBook = async () => {            
            const msg = (await axios({
                method: 'post',
                url: '/bookmark/add',
                data: {
                    userId: userId,
                    eventId: item.id
                }
            })).data;
            if (msg=='add') {
                alert('즐겨찾기에 추가되었습니다')
            } else {
                alert('이미 등록돼있습니다')
            }            
        }
        addBook();
    }
    commonModal.show();
}
const adminMsg = document.getElementById("admin-msg");
const adminCount = document.getElementById("admin-count");
const adminForm = document.getElementById("admin-form");
const updateCheck = async () => {
    const getData = (await axios({
        method: 'get',
        url: '/add'
    })).data;    
    adminMsg.innerText = getData.message;
    adminCount.innerText = getData.count;
}

const dataAdd = async () => {
    const result = (await axios({
        method: 'post',
        url: '/add',
        data: {

        }
    })).data;
    if (result > 0) {
        alert(result + '개의 자료가 업데이트 되었습니다')
        location.reload();
    } else {
        alert('변경사항이 없습니다')
    }
}

adminForm.onsubmit = (e) => {
    e.preventDefault();
    var checkAdd = confirm("데이터를 추가합니다");
    if (checkAdd) {e.target.submit()}    
}

const adminButton = document.getElementById("admin-button");
if (userNick == 'admin') {
    updateCheck();
    adminButton.onclick = function () {
        dataAdd();
        updateCheck();
    }
}
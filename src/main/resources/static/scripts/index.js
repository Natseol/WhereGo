const registButton = document.getElementById("index-regist-button");
registButton.onclick = (e) => {
    document.getElementById("index-mid-form-login").style.display="none";
    document.getElementById("index-mid-form-regist").style.display="block";
    document.body.style = "background-color: rgba( 0 0, 0, 0.7 )";
};

const closeButton = document.getElementById("index-regist-close");
closeButton.onclick = (e) => {
    document.getElementById("index-mid-form-login").style.display="block";
    document.getElementById("index-mid-form-regist").style.display="none";
    document.body.style = "background-color: unset";
};

const unRegistButton = document.getElementById("index-unregist-button");
unRegistButton.onclick = (e) => {
    window.location.href="/map";
};
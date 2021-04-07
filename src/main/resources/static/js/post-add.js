var eg = {}

eg.$ = function (id) {
    return document.getElementById(id);
}

getDate = function () {
    alert("已触发 post-add.js");
    var date = document.getElementByClassName("date");
    var present = new Date();
    date.value = present.getFullYear() + present.getMonth() + present.getDate();
    alert("当前时间为" + date);
    //date.value = date();
    return true;
}
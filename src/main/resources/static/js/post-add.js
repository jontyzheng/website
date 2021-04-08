var eg = {}

eg.$ = function (id) {
    return document.getElementById(id);
}

setDate = function () {
    alert("已触发 post-add.js");
    var dateInput = eg.$("date");
    var dater = new Date();
    //var date = dater.valueOf();
    var date = dater.toISOString().substring(0, 10);
    dateInput.value = date;
    alert(dateInput.value);
    return true;
}
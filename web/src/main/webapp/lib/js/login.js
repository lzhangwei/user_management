$(document).ready(function () {

    $('#loginView').submit(function (e) {

        e.preventDefault();

        var data = {};

        $.each(this, function (i, v) {
            var input = $(v);
            var value = input.val();
            if (input.name == "password") {
                //加密处理
                //value = CryptoJS.MD5(value);
                console.log("password:" + value);
            }
            data[input.attr("name")] = value;

        });

        $.ajax({
            contentType: 'application/json; charset=utf-8',
            type: 'POST',
            url: '/web/login',
            dataType: 'json',
            data: JSON.stringify(data),
            success: function (responseData, textStatus) {
                console.log("login success" + responseData);

                console.log("login success" + textStatus);
                //window.location.href = "/web/views/users.jsp";
            }
        });

    });
});
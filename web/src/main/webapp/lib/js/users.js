function deleteUser(id) {
    $.ajax({
        url: '/web/users?id=' + id,
        type: 'DELETE',
        success: function (data) {
            if(data == 'success') {
                window.location.reload();
            } else {
                window.location.href = "/web/login"
            }
        }
    });
}

function updateUser(id) {
    window.location.href = '/web/user/' + id;
}

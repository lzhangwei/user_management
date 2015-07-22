function deleteEmployee(id) {
    $.ajax({
        url: '/web/employees/' + id,
        type: 'DELETE',
        success: function (data) {
            if(data == 'success') {
                window.location.reload();
            } else {
                window.location.href = "/web/employees"
            }
        }
    });
}

function updateEmployee(id) {
    window.location.href = '/web/employee/' + id;
}
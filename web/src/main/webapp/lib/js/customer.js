function deleteCustomer(id) {
    $.ajax({
        url: '/web/customers/' + id,
        type: 'DELETE',
        success: function (data) {
            if(data == 'success') {
                window.location.reload();
            } else {
                window.location.href = "/web/customers"
            }
        }
    });
}

function updateCustomer(id) {
    window.location.href = '/web/customers/' + id;
}
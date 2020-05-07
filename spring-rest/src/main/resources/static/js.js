$(document).ready(function() {
    getUser();
    $("#myModal").on('show.bs.modal', function(e) {
        $.ajax({
            url: "http://localhost:8081/admin/users",
            method: 'GET',
        }).then(function(data) {
            let index = $(e.relatedTarget).data('user-id');
            $('#modalHeader').append(' ' + data[index].roles + ' ' + data[index].login + ' ' + data[index].password);
            $('#id').val(data[index].id);
            $('#email').val(data[index].email);
            $('#login').val(data[index].login);
            $('#password').val(data[index].password);
            $('#role').val(data[index].roles);
        });
    });
});
$(document).on('show.bs.modal', function() {
    $("#updateForm").on('submit', function() {
        let user = $(this).serialize();
        $.ajax({
            url: 'http://localhost:8081/admin/users',
            type: 'PUT',
            data: user,
            success: function() {},
        })
        $('#myModal').modal('toggle', function() {});
        setTimeout(function() {
            getUser();
        }, 200);
    })
});
$(document).ready(function() {
    $("#formAdd").submit(function(event) {
        let user = $(this).serialize();
        $.ajax({
            url: 'http://localhost:8081/admin/users',
            method: 'POST',
            data: user,
        })
        setTimeout(function() {
            getUser();
            $("#formAdd")[0].reset();
            $('#tabs-83434 a[href="#tab1"]').tab('show');
        }, 200);
    })
    $("body").on('click', '.delete',function() {
        let id = $(this).attr("data-id");
        let idd = 'id='+id;
        $.ajax({
            url: 'http://localhost:8081/admin/users',
            type: 'DELETE',
            data: idd,
            success: function() {},
        })
        setTimeout(function() {
            getUser();
        }, 200);
    })
});

function getUser() {
    $.ajax({
        url: "http://localhost:8081/admin/users",
        method: 'GET',
    }).then(function(data) {
        $('#newTab').empty();
        $.each(data, function(index) {
            let row = $('<tr id="trr"/>');
            let cell = $('<td width="10"></td>');
            row.append(cell);
            cell = '<td>'+data[index].id+'</td><td>'+data[index].roles+'</td><td>'+data[index].login+'</td><td>'+data[index].password+'</td><td>'+data[index].email+'</td>';
            row.append(cell);
            cell = $('<td/>');
            cell.html('<button class="btn btn-info" data-toggle="modal" data-target="#myModal"   style="background-color: #41b7d9" data-user-id="' + index + '">' +
                'Edit' +
                '</button>');
            row.append(cell);
            cell = $('<td/>');
            cell.html('<button class="btn btn-info delete"  style="background-color: orangered" data-id="' + data[index].id + '">' +
                'Delete' +
                '</button>');
            row.append(cell);
            row.appendTo('#newTab')
        });
        $("#newTab").append('<tr height="30"/>')
    });
}
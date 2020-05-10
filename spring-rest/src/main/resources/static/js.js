$(document).ready(function() {
    getUser();
    $("#myModal").on('show.bs.modal', function(e) {
        $.ajax({
            url: "http://localhost:8080/admin/allusers",
            method: 'GET',
        }).then(function(data) {
            let index = $(e.relatedTarget).data('user-id');
            $('#modalHeader').append(' ' + data[index].roles[0].name + ' ' + data[index].age + ' ' + data[index].password);
            $('#id').val(data[index].id);
            $('#email').val(data[index].email);
            $('#firstName').val(data[index].firstName);
            $('#lastName').val(data[index].lastName);
            $('#age').val(data[index].age);
            $('#password').val(data[index].password);
            $('#role').val(data[index].roles[0].name);
        });
    });
});
$(document).on('show.bs.modal', function() {
    $("#updateForm").on('submit', function() {
        let formData = $(this).serializeArray();
        var temp = {};
        formData.forEach(function(el){
            temp[el.name] = el.value;
        });
        if (temp.role === 'ADMIN'){
            temp.isAdmin = true
            temp.isUser = false
        }else {
            temp.isUser = true
            temp.isAdmin = false
        }
        let user = JSON.stringify(temp);
        $.ajax({
            url: 'http://localhost:8080/admin/updateuser',
            type: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
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
        let formData = $(this).serializeArray();
        var temp = {};
        formData.forEach(function(el){
            temp[el.name] = el.value;
        });
        if (temp.role === 'ADMIN'){
            temp.isAdmin = true
            temp.isUser = false
        }else {
            temp.isUser = true
            temp.isAdmin = false
        }
        let user = JSON.stringify(temp);
        $.ajax({
            url: 'http://localhost:8080/admin/new',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
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
            url: 'http://localhost:8080/admin/deleteuser/'+ id,
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
        url: "http://localhost:8080/admin/allusers",
        method: 'GET',
    }).then(function(data) {
        $('#newTab').empty();
        $.each(data, function(index) {
            let row = $('<tr id="trr"/>');
            let cell = $('<td width="10"></td>');
            row.append(cell);
            cell = '<td>'+data[index].id+'</td><td>'+data[index].firstName+'</td><td>'+data[index].lastName+'</td><td>'+data[index].age+'</td><td>'+data[index].roles[0].name +'</td><td>'+ data[index].email+'</td>';
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
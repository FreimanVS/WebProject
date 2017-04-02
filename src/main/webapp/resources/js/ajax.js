$(document).ready(function() {
    $.ajax({
        url: "/comments2/getComments" + window.location.search,
        type: "GET",
        data: ({}),
        dataType: "html",
        beforeSend: function() {
            $("#information").html("<img src='/resources/gif/downloading.gif' alt='Downloading...'/>");
        },
        success: function(data) {
            $("#information").html(data);
        }
    });

    $("#testid").bind("click", function() {
        $.ajax({
            url: "/comments2/add",
            type: "GET",
            data: ({nick: $("input[name='nick']").val(), content: $("#textarea").val(),
                idmovie: $("input[name='idmovie']").val(), namemovie: $("input[name='namemovie']").val()}),
            dataType: "html",
            beforeSend: function() {
                $("#information").html("<img src='/resources/gif/downloading.gif' alt='Downloading...'/>");
            },
            success: function(data) {
                $("#information").html(data);
            }
        });
    });
});
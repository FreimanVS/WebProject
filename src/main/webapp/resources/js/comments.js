$(document).ready(function() {
    $(document).on("click", "#add_comment", function() {
        $("#sendcommentdiv").show();
        $("#add_comment").replaceWith($("#sendcommentdiv"));
    });
});
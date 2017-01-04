function hideComments() {
    $("#hide").hide();
    $("#show").show();
    $("#comments").fadeOut(1000);
}

$(document).ready(function() {
    var length_comments2 = $(".comments2").length;
    var x = 3;
    $('.comments2:lt(' + x + ')').show();
    if (length_comments2 <= x) {
        $('#loadMore').hide();
    }
    $('#loadMore').click(function () {
        x = (x + 5 <= length_comments2) ? x+5 : length_comments2;
        $('.comments2:lt('+x+')').slideDown(500);
        $('#showLess').show();
        if(x == length_comments2){
            $('#loadMore').hide();
        }
    });
    $('#showLess').click(function () {
        x = (x-5<0) ? 3 : x-5;
        $('.comments2').not(':lt('+x+')').slideUp(500);
        $('#loadMore').show();
         $('#showLess').show();
        if(x <= 3){
            $('#showLess').hide();
        }
    });
});
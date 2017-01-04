$(document).ready(function() {
    var num = $(".site_content").offset().top;

    $(window).bind('scroll', function () {
        if ($(window).scrollTop() > num) {
            $('.header').addClass('fixed');
        } else {
            $('.header').removeClass('fixed');
        }
    });
 });
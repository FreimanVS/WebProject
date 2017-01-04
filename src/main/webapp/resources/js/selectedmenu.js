// the ip address of the server has to be here
var ip = location.host;

$('document').ready(function() {
    $('.menu a').each(function() {
        if ("http://" + ip + "/" + $(this).attr('href') == window.location.href)
        {
            $(this).parent().addClass('selected');
        }
    });
});
// var requested = false;
// $('.notifications').click(function() {
// //                if (!requested) {
// //                    requested = true;
// //                    Notification.requestPermission();
// //                } else {
// //                    new Notification("Test Message", {
// //                        body: "Hello, come in the chat to talk!"
// //                    });
// //                }
//
//     Notification.requestPermission().then(
//             function(permission) {
//                 if (permission == 'granted') {
//                     var message = new Notification('Welcome', {
//                         body: 'Hello. We glad that you joined to our friendly community',
//                         icon: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmjcy5WoXo3Ocfi0WbFenK-TnhN0E8u-wTVdGfHQmcthOps8u33w'
//                     });
//
//                     // on click this notification
//                     // $(message).click(function() {
//                     //     window.location = 'http://mail.ru';
//                     // });
//                 }
//             }
//     );
// });

$(function() {
    Notification.requestPermission().then(
            function(permission) {
                if (permission == 'granted') {
                    var message = new Notification('Welcome', {
                        body: 'Hello. We are glad that you joined our friendly community',
                        icon: 'http://i1292.photobucket.com/albums/b580/supermario1989/1_zps0763995a.jpg'
                    });
                }
            }
    );
});

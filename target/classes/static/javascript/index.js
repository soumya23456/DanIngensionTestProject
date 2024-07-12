$("a[href^='#']").click(function(e){
    e.preventDefault();
    var location = $($(this).attr("href")).offset().top;
    $("li a").removeClass("active");
    $(this).addClass("active");
    $("body, html").animate({scrollTop: location}, 100 );
});

var statusV = document.getElementById("status").value;

if(statusV == "invalidEmail"){
    swal("Sorry","Please Enter Email" , "error" );
}
if(statusV == "invalidPassword"){
    swal("Sorry","Please Enter Password" , "error" );
}


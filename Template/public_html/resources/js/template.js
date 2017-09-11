$(document).ready(function () {
    $('.dropdown-submenu a.test').on("click", function (e) {
        $(this).next('ul').toggle();
        e.stopPropagation();
        e.preventDefault();
    });
    $('.state_menu_active').addClass("glyphicon-folder-open");
    $('.state_menu_').addClass("glyphicon-folder-close");

});
}
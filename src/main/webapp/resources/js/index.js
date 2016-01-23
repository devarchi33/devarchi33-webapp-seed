/**
 * Created by donghoon on 2016. 1. 23..
 */
$('.toggle').on('click', function () {
    $('.container').stop().addClass('active');
});

$('.close').on('click', function () {
    $('.container').stop().removeClass('active');
});
$('.nav-tabs li:first-child').addClass('active');
    $('.post-list').hide();
    $('.post-list:first').show();
    $('.nav-tabs li').click(function () {
        $('.nav-tabs li').removeClass('active');
        $(this).addClass('active');
        $('.post-list').hide();
        var activeTab = $(this).find('a').attr('href');
        $(activeTab).fadeIn();
        return false;
    });
    $(".heightline-post").heightLine({
        fontSizeCheck: true
    });
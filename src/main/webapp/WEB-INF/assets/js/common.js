$(document).ready(function () {
	$(function () {
		console.log("start")
		$('.btn-gnavi').on('click', function () {
			console.log("Go function")
			var topVal = 0;
			if ($(this).hasClass('hb-open')) {
				topVal = -1200;
				$(this).removeClass('hb-open');
			} else {
				$(this).addClass('hb-open');
			}
			$('#global-navi').stop().animate({
				top: topVal
			}, 200);
		});
		$('a').click(function () {
				console.log("Click function")
			$('a').removeClass('active');
			$(this).addClass("active");
		});
	})
});






$(document).ready(function() {
  var table = $('#data-table').DataTable( {
       rowReorder: {
           selector: 'td:nth-child(2)'
      },
       responsive: true
   } );
} );

$(".heightline-post").heightLine({
        fontSizeCheck: true
});

//$(document).ready(function() {
//	console.log("ready")
//	var table = $('#data-table').DataTable({
//		"paging": true,
//		"pageLength": 5,
//		"bLengthChange": false,
//		"bFilter": true,
//		"bInfo": false,
//		"bAutoWidth": false,
//		"dom": 'rtp',
//	});
//$('#dataTableSearch').keyup(function() {
//		table.search($(this).val()).draw();
//		userTable.search($(this).val()).draw();
//	});
//});
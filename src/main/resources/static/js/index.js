
$(".button-clone").click(function(){
	$(".editfrom").hide()
})

$(".editdata,.addData").click(function(){
	$(".editfrom").show()
})

 $(".guan").show()
  $(".kai").hide()

 $(".kai").click(function(){
	 $(".sidebar").show()
	 $(".guan").show()
	 $(".kai").hide()
	 $(".main").css('margin-left','10.66666667%')
 })
 $(".guan").click(function(){
	 $(".sidebar").hide()
	 $(".guan").hide()
	 $(".kai").show()
	  $(".main").css('margin-left','0px')
	  $(".main").css('width','100%')
 })
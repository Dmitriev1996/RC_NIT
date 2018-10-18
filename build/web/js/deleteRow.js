$(document).ready(function(){
    var data="";
  $(".checkbox").change(function(){
      if($(this).is(":checked")){
         $(this).parents("tr").toggleClass("row");
         $("#deleteRow").removeAttr("disabled");
         data="id="+$(this).parents("tr").find(".id").html();
      } else {
        $("#deleteRow").attr("disabled", "disabled");
        $(this).parents("tr").toggleClass("row");
      }
  });
  $("#deleteRow").click(function(){
             jQuery.ajax({
                 type: "POST",
                 url: "http://localhost:8080/WebJsp/deleteRow",
                 dataType: "text",
                 data: data,
                 succes: function(response){
                     alert("Запись успешно удалена!");
                 },
                 error: function(xhr, ajaxOptions, thrownError){
                 alert(thrownError);
                 }
             });
         });
         
});



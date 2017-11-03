$(document).ready(function(){
  
  $('.delete').click(function(e){
   
   e.preventDefault();
   
   var pid = $(this).attr('data-id');
   var parent = $(this).closest("form");
   
   bootbox.dialog({
     message: "Are you sure you want to Delete ?",
     title: "<i class='glyphicon glyphicon-trash'></i> Delete !",
     buttons: {
    success: {
      label: "No",
      className: "btn-success",
      callback: function() {
      $('.bootbox').modal('hide');
      }
    },
    danger: {
      label: "Delete!",
      className: "btn-danger",
      callback: function() {
       
       $.ajax({ 
        type: 'POST',
        url: 'suppTick?idTick='+pid
       })
       .done(function(response){    
        bootbox.alert(response);
        window.location.replace("/eboutique/adminTick/optTickets");
       })
       .fail(function(){
        
        bootbox.alert('Something Went Wrog ....');
                
       })
              
      }
    }
     }
   });
   
   
  });
  
 });
$(document).ready(function(){
  
  $('.info').click(function(e){
   
   e.preventDefault();
   
   var pid = $(this).attr('data-id');
   var parent = $(this).closest("form");
   
   bootbox.dialog({
     message: "<textarea rows='3' cols='70' id='comment' name='comment'>",
     title: "Ajouter Votre Commentaire !",
     buttons: {
    success: {
      label: "Cancel",
      className: "btn-success",
      callback: function() {
      $('.bootbox').modal('hide');
      }
    },
    danger: {
      label: "Save!",
      className: "btn-primary",
      callback: function() {
       
       $.ajax({ 
        type: 'POST',
        url: '/eboutique/admin/comment/'+pid+'/'+$("#comment").val()
       })
       .done(function(response){    
        bootbox.alert(response);
        window.location.replace("/eboutique/admin/ListTicket");
        
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
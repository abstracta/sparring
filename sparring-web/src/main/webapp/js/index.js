$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8081/articles/all',
    success: function(data){
      data.forEach(function(articleItem){
        $('#tbodyid').append('<div class="col-lg-4 col-md-6 mb-4">' + '<div class="card h-100">' + '<a href="prod.html?idp_='+articleItem[0]+'">' + '<img class="card-img-top img-fluid" src="'+articleItem[3]+'" alt="">'+ '</a>' + '<div class="card-block">' + '<h4 class="card-title">' + '<a href="prod.html?idp_='+articleItem[0]+'" class="hrefch">' + articleItem[5] + '</a>' + '</h4>' + '<h5>$' + articleItem[4] + '</h5>' + '<p id="article" class="card-text">' + articleItem[2] + ' </p>' + ' </div>' + '</div>' +'</div>');
      })
    }
  });
});

   
function byCat(cat){
  $.ajax({
    type:'GET',
    url: 'http://localhost:8081/articles/all/category?cat=' + cat,
    success: function(data){
        $('#tbodyid').empty();
      data.forEach(function(articleItem){
       $('#tbodyid').append('<div class="col-lg-4 col-md-6 mb-4">' + '<div class="card h-100">' + '<a href="prod.html?idp_='+articleItem[0]+'">' + '<img class="card-img-top img-fluid" src="'+articleItem[3]+'" alt="">'+ '</a>' + '<div class="card-block">' + '<h4 class="card-title">' + '<a href="prod.html?idp_='+articleItem[0]+'" class="hrefch">' + articleItem[5] + '</a>' + '</h4>' + '<h5>$' + articleItem[4] + '</h5>' + '<p id="article" class="card-text">' + articleItem[2] + ' </p>' + ' </div>' + '</div>' +'</div>'); 
      })
    }
  });
}

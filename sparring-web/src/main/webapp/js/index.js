$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url: 'http://sparring:8081/articles/all',
    success: function(data){
      data.forEach(function(articleItem){
        $('#tbodyid').append('<div class="col-lg-4 col-md-6 mb-4">' + '<div class="card h-100">' + '<a href="prod.html?idp_='+articleItem["id"]+'">' + '<img class="card-img-top img-fluid" src="'+articleItem["image"]+'" alt="">'+ '</a>' + '<div class="card-block">' + '<h4 class="card-title">' + '<a href="prod.html?idp_='+articleItem["id"]+'" class="hrefch">' + articleItem["title"] + '</a>' + '</h4>' + '<h5>$' + articleItem["price"] + '</h5>' + '<p id="article" class="card-text">' + articleItem["description"] + ' </p>' + ' </div>' + '</div>' +'</div>');
      })
    }
  });
});

   
function byCat(cat){
  $.ajax({
    type:'GET',
    url: 'http://sparring:8081/articles/all/category?cat=' + cat,
    success: function(data){
        $('#tbodyid').empty();
      data.forEach(function(articleItem){
       $('#tbodyid').append('<div class="col-lg-4 col-md-6 mb-4">' + '<div class="card h-100">' + '<a href="prod.html?idp_='+articleItem["id"]+'">' + '<img class="card-img-top img-fluid" src="'+articleItem["image"]+'" alt="">'+ '</a>' + '<div class="card-block">' + '<h4 class="card-title">' + '<a href="prod.html?idp_='+articleItem["id"]+'" class="hrefch">' + articleItem["title"] + '</a>' + '</h4>' + '<h5>$' + articleItem["price"] + '</h5>' + '<p id="article" class="card-text">' + articleItem["description"] + ' </p>' + ' </div>' + '</div>' +'</div>'); 
      })
    }
  });
}

$(document).ready(function(){
     var loc = document.location.href;
     var getString = loc.split('?')[1];
     var GET = getString.split('&');
     var get = {};

     for(var i = 0, l = GET.length; i < l; i++){
        var tmp = GET[i].split('p_=');
        get[tmp[0]] = unescape(decodeURI(tmp[1]));
     }
     var idp = get['id'];
     idp = idp.replace(/#/g, '');
    $.ajax({
      type:'GET',
      url: 'http://localhost:8081/articles/' + idp,

      success: function(data){
          $('#tbodyid').append('<h2 class="name">' + data[0][5] + '</h2>' + '<hr>' + '<h3 class="price-container">'+ '$' + data[0][4] + '<small>' + ' *includes tax'+'</small>'+'</h3>'+'<hr>'+'<div class="description description-tabs">'+'<ul id="myTab" class="nav nav-pills">'+'<li class="active">'+'</li>'+'</ul>'+'<div id="myTabContent" class="tab-content">'+'<div class="tab-pane fade active in" id="more-information">'+'<br>'+'<strong>'+'Product description'+'</strong>'+'<p>' + data[0][2] + '</div>'+'</div>'+'</div>'+'<hr>');
          $('#imgp').append('<div class="item active">'+'<img width=400 height=280 src="'+ data[0][3] +'" alt="">'+'</div>');
      }
    });
});  

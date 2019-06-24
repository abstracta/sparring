$(document).ready(function(){
     var loc = document.location.href;
     var getString = loc.split('?')[1];
     var GET = getString.split('&');
     var get = {};

     for(var i = 0, l = GET.length; i < l; i++){
        var tmp = GET[i].split('p_=');
        get[tmp[0]] = unescape(decodeURI(tmp[1]));
     }
     idp = get['id'];
     idp = idp.replace(/#/g, '');
    $.ajax({
      type:'GET',
      url: '/articles/' + idp,

      success: function(data){
          $('#tbodyid').append('<h2 class="name">' + data["title"] + '</h2>' + '<hr>' + '<h3 class="price-container">'+ '$' + data["price"] + '<small>' + ' *includes tax'+'</small>'+'</h3>'+'<hr>'+'<div class="description description-tabs">'+'<ul id="myTab" class="nav nav-pills">'+'<li class="active">'+'</li>'+'</ul>'+'<div id="myTabContent" class="tab-content">'+'<div class="tab-pane fade active in" id="more-information">'+'<br>'+'<strong>'+'Product description'+'</strong>'+'<p>' + data["description"] + '</div>'+'</div>'+'</div>'+'<hr>' + '<div class="row">'+'<div class="col-sm-12 col-md-6 col-lg-6">'+'<button type="button" class="btn btn-success" data-toggle="modal" data-target="#orderModal">Place Order</button>'+'</div>'+'</div>');
          $('#imgp').append('<div class="item active">'+'<img width=400 height=280 src="'+ data["image"] +'" alt="">'+'</div>');
      }
    });
});


function purchaseOrder(){
        var idr= Math.floor((Math.random() * 10000000) + 1);
        var name = document.getElementById("name").value;
        var quantity = document.getElementById("quantity").value;
        var creditCard= document.getElementById("cardNumber").value;
        var cvv= document.getElementById("cvv").value;

        var date = new Date();

        if(name == "" || quantity == "" || creditCard == ""){
          alert("Please fill out Quantity, Name and Card Number.");
        }else{
            $.ajax({
                  type:'POST',
                  url: '/articles/purchase',
                  data: JSON.stringify({"id": idp, "name": name, "quantity": quantity, "cardNumber": creditCard,"cvv": cvv}),
                  contentType: "application/json",

                  success: function(data){
                    if(data){
                        swal({
                          title: "Thank you for your purchase today!",
                          text: "Id: "+ idr + "\n"+ "Card Number: " + creditCard + "\n" + "Name: " + name + "\n" + "Date: " + date.getDate()+ "/" + date.getMonth() + "/" + date.getFullYear(),
                          type: "success",
                          confirmButtonColor: "#DD6B55",
                          confirmButtonText: "OK",
                          closeOnConfirm: false
                       },
                        function(isConfirm){
                            if (isConfirm) {
                                location.href= 'index.html';
                            }
                        });
                    }else{
                      alert("There was a problem with the payment process");
                    }
                  }
             });

        }
}

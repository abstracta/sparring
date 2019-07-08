$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url: '/issues/inactive/common',
    success: function(data){
      if ((!$.trim(data))){
        $('#commonInactiveIssues').append(' <div class="col-sm-12 col-md-6 col-lg-6"> <p> There are no inactive issues. </p> </div>');
      }
      data.forEach(function(issue){
        $('#commonInactiveIssues').append('<div class="col-lg-4 col-md-6 mb-4"> <div class="card h-100"> <div class="card-block"> <h4 class="card-title"> ' + issue["name"] + ' </h4> <p id="article" class="card-text">' + issue["description"] + ' </p>' + '<a href="#" class="btn btn-success btn-lg" data-button="' + issue["name"] + '" data-toggle="modal" data-target="#confirm-activate">Activate</a> </div>' + '</div>' +'</div>');
    })
    }
  });
});

$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url: '/issues/inactive/input',
    success: function(data){
      if ((!$.trim(data))){
        $('#inputInactiveIssues').append(' <div class="col-sm-12 col-md-6 col-lg-6"> <p> There are no inactive issues. </p> </div>');
      }
      data.forEach(function(issue){
        $('#inputInactiveIssues').append('<div class="col-lg-4 col-md-6 mb-4"> <div class="card h-100"> <div class="card-block"> <h4 class="card-title"> ' + issue["name"] + ' </h4> <p id="article" class="card-text">' + issue["description"] + ' </p>' + '<br> <a href="#" class="btn btn-success btn-lg" data-button="' + issue["name"] + '" data-toggle="modal" data-target="#confirm-activate-input">Activate</a> </div>' + '</div>' +'</div>');
    })
    }
  });
});

$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url: '/issues/active',
    success: function(data){
      if ((!$.trim(data))){
        $('#activeIssues').append(' <div class="col-sm-12 col-md-6 col-lg-6"> <p> There are no active issues. </p> </div>');
      }
      data.forEach(function(issue){
        $('#activeIssues').append('<div class="col-lg-4 col-md-6 mb-4"> <div class="card h-100"> <div class="card-block"> <h4 class="card-title"> ' + issue["name"] + ' </h4> <p id="article" class="card-text">' + issue["description"] + ' </p>' + '<a href="#" class="btn btn-danger btn-lg" data-button="' + issue["name"] + '" data-toggle="modal" data-target="#confirm-deactivate">Deactivate</a> </div>' + '</div>' +'</div>');
      })
    }
  });
});



function activate(name){
  $.ajax({
    type:'PUT',
    url: '/issues/' + name + "/active",
    success: function(data){
        window.location.reload();
    }
  });
}

function activateInput(name, value){
  $.ajax({
    type:'PUT',
    url: '/issues/' + name + "/active/" + value + "",
    success: function(data){
        window.location.reload();
    }
  });
}

function deactivate(name){
  $.ajax({
    type:'PUT',
    url: '/issues/' + name + "/inactive",
    success: function(data){
        window.location.reload();
    }
  });
}

$('#confirm-activate').on('show.bs.modal', function (e) {
    trigger = $(e.relatedTarget).data('button');
});

$('#confirm-activate-input').on('show.bs.modal', function (e) {
    trigger3 = $(e.relatedTarget).data('button');
});

$('#confirm-deactivate').on('show.bs.modal', function (e) {
    trigger2 = $(e.relatedTarget).data('button');
});

$('#activate').click(function(){
    activate(trigger);
});

$('#activate-input').click(function(){
    value = $("#confirm-activate-input #value").val().trim();
    activateInput(trigger3, value);
});

$('#deactivate').click(function(){
    deactivate(trigger2);
});






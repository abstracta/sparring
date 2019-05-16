$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url: 'http://sparring:8082/issues/inactive',
    success: function(data){
      if ((!$.trim(data))){
        $('#inactiveIssues').append(' <div class="col-sm-12 col-md-6 col-lg-6"> <p> There are no inactive issues. </p> </div>');
      }
      data.forEach(function(issue){
        $('#inactiveIssues').append('<div class="col-lg-4 col-md-6 mb-4"> <div class="card h-100"> <div class="card-block"> <h4 class="card-title"> ' + issue["name"] + ' </h4> <p id="article" class="card-text">' + issue["description"] + ' </p>' + '<a href="#" class="btn btn-success btn-lg" data-button="' + issue["name"] + '" data-toggle="modal" data-target="#confirm-activate">Activate</a> </div>' + '</div>' +'</div>');
    })
    }
  });
});


$(document).ready(function(){
  $.ajax({
    type: 'GET',
    url: 'http://sparring:8082/issues/active',
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


function restart(){
  $.ajax({
    type:'POST',
    url: 'http://sparring:8081/restart',
    success: function(data){
        alert("Application was restarted")
    }
  });
}

function activate(name){
  $.ajax({
    type:'PUT',
    url: 'http://localhost:8082/issues/' + name + "/active",
    success: function(data){
        window.location.reload();
    }
  });
}

function deactivate(name){
  $.ajax({
    type:'PUT',
    url: 'http://localhost:8082/issues/' + name + "/inactive",
    success: function(data){
        window.location.reload();
    }
  });
}

$('#confirm-activate').on('show.bs.modal', function (e) {
    trigger = $(e.relatedTarget).data('button');
});

$('#confirm-deactivate').on('show.bs.modal', function (e) {
    trigger2 = $(e.relatedTarget).data('button');
});

$('#activate').click(function(){
    activate(trigger);
});


$('#deactivate').click(function(){
    deactivate(trigger2);
});






var onBuildsave = function(e) {
	var saveData = $.ajax( {
      type        : "POST",
      url         : "/build/saveBuildCfg",
      data        : JSON.stringify( $("form").serializeArray()),
      dataType    : "json",
	  contentType : 'application/json',

      success: function(result, status, jqXHR){
          getBuildAll();
          alert("Build saved successfully");
      }} );
}

var sendBuildReq = function(id) {
	var saveData = $.ajax( {
      type        : "GET",
      url         : "/build/run?id=" + id,

      success: function(result, status, jqXHR) {
          //alert(JSON.stringify(result));
      }});
}

var getBuildAll = function() {
    $.ajax( {
      type        : "GET",
      url         : "/build/getAll",
      dataType    : "json",
      success     : function(resultData) {
          var res = new Array(resultData.length);
          for(i = 0; i < resultData.length; i++) {
              res[i] = new Array(2);
              res[i][0] = resultData[i].id;
              res[i][1] = resultData[i].name;
          }
          for(i = 0; i < res.length; i++) {
              var btn = $('<button/>', { id : res[i][0], type : "button" }).addClass("btn btn-secondary").append("Build");
              res[i][res[i].length] = btn;
              btn.click(function(e) {
                  sendBuildReq(e.target.id);
              });
          }
          var grid = new UIGrid("grid", ["Config ID", "Build Name", ""], res);
          $("#grid").remove();
          $("#main").append(grid);
    }});
}

$( document ).ready(function() {
    getBuildAll();
    $.ajax( {
          type        : "GET",
          url         : "/build/getImageName",
          dataType    : "json",
          success     : function(resultData) {
              var imageName = new Array();
              for(i =0; i < resultData.length; i++){
                imageName[i] = resultData[i].name;
              }

              var buildForm = new UIBuildForm("buildForm", imageName);
              	$("#main").append(new UIModal("exampleModal", "New Build", buildForm, onBuildsave));
        }});
});


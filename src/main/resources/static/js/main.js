var onBuildsave = function(e) {
	alert(JSON.stringify( $("form").serializeArray()));
	var saveData = $.ajax( {
      type        : "POST",
      url         : "saveData.html",
      data        : JSON.stringify( $("form").serializeArray()),
      dataType    : "json",
	  contentType : 'application/json',

      success: function(resultData){
          alert("Build saved successfully");
      }} );
}

$( document ).ready(
    function() {
	$.ajax( {
      type        : "GET",
      url         : "getSavedBuildList.html",
      dataType    : "text/html",
      success     : function(resultData) {
          alert("qwd");
    }});
});


$( function() {
	
	var j = jQuery.parseJSON("[[1,2], [3,4]]");
	
	for(i = 0; i < j.length; i++) {
		j[i][j[i].length] = $('<button/>', { type : "button" }).addClass("btn btn-secondary").append("Build");
	}
	
    var grid = new UIGrid("2", ["h1", "h2", "h3"], j);
	$("#main").append(grid);
	var buildForm = new UIBuildForm("buildForm", ["Image-1", "Image-2"]);
	$("#main").append(new UIModal("exampleModal", "New Build", buildForm, onBuildsave));
});

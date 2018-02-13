var UIGrid = function (id, hdrs, rows) {
	this.mainDivUI = $('<div/>', { id: 'grid-div-'.id }).addClass("container");

	var rowUI = $('<div/>', { id: 'grow-div-'.id }).addClass("row");

	for(j = 0; j < hdrs.length; j++) {
		var colUI = $('<div/>', { id: 'gcol-div-hdr-'.id }).addClass("col-sm col-grid-hdr-div").append("<h6>" + hdrs[j] + "</h6>");
		rowUI.append(colUI);
	}
	this.mainDivUI.append(rowUI);

	
	for(i = 0; i < rows.length; i++) {
		var rowUI = $('<div/>', { id: 'grow-div-'.id }).addClass("row");

		for(j = 0; j < rows[i].length; j++) {
			var colUI = $('<div/>', { id: 'gcol-div-'.id }).addClass("col-sm col-grid-div").append(rows[i][j]);
			rowUI.append(colUI);
		}
		this.mainDivUI.append(rowUI);
	}

    return this.mainDivUI;
};


var UIModal = function (id, title, content, onSave) {
	this.modalDivUI = $('<div/>',
	                      { id                : id,
	                        tabindex          : "-1",
							"aria-labelledby" : "exampleModalLabel",
							"aria-hidden"     : "true",
							role              : "dialog"}).addClass("modal fade bd-example-modal-lg");
	

    var modalHdrDiv = $('<div/>').addClass("modal-header").append("<h5 class=modal-title>"+title+"</h5>");
	var modalBdyDiv = $('<div/>').addClass("modal-body").append(content);
	var closeBtn = $('<button/>', { "data-dismiss" : "modal", type : "button" }).addClass("btn btn-secondary").append("Close");
	var saveBtn = $('<button/>').addClass("btn btn-primary", { type : "button" }).append("Save").click(onSave);
    saveBtn.myform = content;
	var modalFtrDiv = $('<div/>').addClass("modal-footer").append(closeBtn).append(saveBtn);

	//content
	var modalCntDiv = $('<div/>').addClass("modal-content").append(modalHdrDiv).append(modalBdyDiv).append(modalFtrDiv);
	var modalDlgDiv = $('<div/>').addClass("modal-dialog").append(modalCntDiv);
	this.modalDivUI.append(modalDlgDiv);

    return this.modalDivUI;
};

var UIAccordion = function(id, accData) {
	this.acc = $('<div/>', { id : id, width : "100%"});
	for(i = 0; i < accData.length; i++) {
		var hdr = $('<h3/>').append(accData[i].header);
		var content = $('<div/>').append($('<p/>').append(accData[i].content));
		this.acc.append(hdr).append(content);
	}

	this.acc.accordion();

	return this.acc;
}

var UIComboBox = function(id, opts) {
	this.comboBox = $('<select/>', { id : id, width : "100%", name : id }).addClass("custom-select d-block w-100");
	for(i = 0; i < opts.length; i++) {
		this.comboBox.append($('<option/>', { value : opts[i],  }).append(opts[i]));
	}

	return this.comboBox;
}

var UIRadio = function(id, options) {
	this.radioDiv = $('<div/>');

	for(i = 0;i < options.length; i++) {
			var radioOptDiv = $('<div/>', { id : id, width : "100%" }).addClass("form-check");

    	if(i == 0)
	        var radioInput = $('<input/>', { name: id, id : "id" + options[i], value : options[i], type : "radio", checked : ""}).addClass("form-check-input");
		else
			var radioInput = $('<input/>', { name: id, id : "id" + options[i], value : options[i], type : "radio"}).addClass("form-check-input");
		var radioLabel = $('<label/>', { "for" : id }).addClass("form-check-label").append(options[i]);
		
		radioOptDiv.append(radioInput).append(radioLabel);
		this.radioDiv.append(radioOptDiv);
	}

	return this.radioDiv;
}

var UITextBox = function(id) {
	this.textBox = $('<input/>', { id : id, width : "100%", name : id }).addClass("form-control");
	
	return this.textBox;
}

var UITextArea = function(id) {
	this.textArea = $('<textarea/>', { id : id, name : id}).addClass("form-control");
	return this.textArea;
}

var UIConfCol = function(id, label, content) {
	this.confCol = $('<div/>', { id : id }).addClass("col-sm-10");
	var labelUI = $('<label/>').addClass("col-sm-3 col-form-label").append(label);
	this.confCol.append(labelUI).append(content);
	
	return this.confCol;
}

var UIBuildForm = function(id, imgList) {
	this.formDiv = $('<form/>', { id : id, name : id});
	
	//row-1
	var confRow = $('<div/>').addClass("form-group row");	
	var img = new UIComboBox("img", imgList);
	confRow.append(new UIConfCol("imgCol", "Image", img));
	this.formDiv.append(confRow);

	// Row-2
	var confRow = $('<div/>').addClass("form-group row");	
	var prov = new UITextArea("prov");
	confRow.append(new UIConfCol("provCol", "Provision", prov));
	this.formDiv.append(confRow);

	// Row-3
	var confRow = $('<div/>').addClass("form-group row");	
	var cloud = new UIRadio("cloud", ["AWS", "GCP", "Azure"]);
	confRow.append(new UIConfCol("provCol", "Cloud", cloud));
	this.formDiv.append(confRow);

    return this.formDiv;
}
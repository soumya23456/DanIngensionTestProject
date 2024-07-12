const fileform = document.querySelector("#fileform");
const filetypes = document.querySelector("#filetype");
var multifiles = document.getElementById('multifile');
const filefield = document.querySelector("#multifile");
const fileext_regex = /(\.txt|\.csv|\.xls|\.xlsx|\.xml|\.doc|\.docx|\.jpeg|\.jpg|\.png)$/i;

var formData = new FormData();

let formfiletypes = [];
const displayError = (input,errMessage) => {
    const formField = input.parentElement;
    const error = formField.querySelector('small');
    error.textContent = errMessage;
};
const displaySuccess = (input) => {
    const formField = input.parentElement;
    const error = formField.querySelector('small');
    error.textContent = '';
};

const checkFiles = () => {
	let valid = false;
	console.log("files : "+multifiles.files.length);
	console.log("files data : "+multifiles.toString());

	if(multifile.files.length === 0){
		displayError(filefield,"Upload File");
	}
	else{
		for(var i=0; i <filefield.files.length;i++){
			const fsize = filefield.files[i].size;
			const fileSize = Math.round((fsize/1024));
			console.log("file size : "+ fileSize);
		}
		displaySuccess(filefield);
		valid = true;
	}
	return valid;
}

const checkFiletypes = () => {
	let valid = false;
	console.log("filetypes : "+filetypes.selectedIndex);
	if(filetypes.selectedIndex == -1){
		displayError(filetypes,"Select file types");
	}
	else{
		for(var i=0; i<filetypes.options.length; i++){
			if(filetypes.options[i].selected == true){
				formfiletypes.push(filetypes.options[i].value);
				console.log(formfiletypes);
			}
		}
		console.log("filetypes data : "+ filetypes[0]+" ");
		displaySuccess(filetypes);
		valid = true;
	}
	return valid;
}

fileform.addEventListener('submit', function(e){
	e.preventDefault();
	let filetypevalid = checkFiletypes();
	let filevalid = checkFiles();
	let formvalid = filevalid && filetypevalid;
	console.log(formvalid);
	let valid =false;
	let uploaded_files = [], types = [], uploaded_filetypes = [];
    for(let i = 0; i < multifiles.files.length; i++){
    	console.log("multifles :"+ multifiles.files[i]);
       uploaded_files.push(multifiles.files[i]);
       types.push(uploaded_files[i].type)
    }

     types.forEach(type => {
        if(!uploaded_filetypes.includes(type)){
             uploaded_filetypes.push(type);
         }
     });
     
        if(uploaded_files.length != 0){
            uploaded_files.forEach(f => {
                if(!fileext_regex.exec(f.name) && 
                (f.type != "text/plain" || f.type != "text/csv" ||
                f.type != "text/xml" || f.type != "application/xml" || 
                f.type != "application/vnd.ms-excel" ||
                f.type != "application/msword"
                )){
					displayError(filefield,"Uploaded non-text file");
				}
                else if(formfiletypes.sort().toString() != uploaded_filetypes.sort().toString()){
						displayError(filetypes,"Not selected uploaded file types/extensions");
				}
                else{
                	valid =true
                }
			});
            if(valid){
    			document.querySelector("form").submit();            	
            }
		}
		else{
			displayError(filefield, "Upload File");
		}
});
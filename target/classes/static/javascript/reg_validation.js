console.log("REGISTRATION VALIDATION");

const reg_user = document.querySelector('#register-form');
		
const successmsg = document.querySelector('#msg');

const username	= document.querySelector('#fullname');
const uemail	= document.querySelector('#email');
const uphone	= document.querySelector('#contact');
const upwd 		= document.querySelector('#pass');
const repwd 	= document.querySelector('#re_pass');
const optradio 	= document.querySelector('#optradio');
const address 	= document.querySelector('#address');
const state 	 = document.querySelector('#state');
const postalcode = document.querySelector('#postalcode');
const country 	 = document.querySelector('#country');

const emailregex 	= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
const phoneregex 	= /^\(?(\d{3})\)?([-]?)(\d{3})([-]?)(\d{4})$/;
const psdregex 		= /^(?=.*[a-z])(?=.*[A-Z])(?=.*[\d])(?=.*[!@#\$%\^&\*])(?=.{8,})$/;
const nameregex		= /^([a-zA-Z])+([ ]?)+([a-zA-Z])+$/;
const usernameregex = /^([a-zA-Z0-9])+([a-zA-Z0-9!@#\$%\^&\*\-\+\_]?)+$/;
const addressregex 	= /^([a-zA-Z0-9\s\.\#\-\,])+$/;
const postalregex 	= /(^\d{5}$)|(^\d{9}$)|(^\d{5}-\d{4}$)/;
const stateregex	= /^([a-zA-Z])+$/;
const isRequired 	= value =>(value === '' ? false : true);

const isBetween = (length,min,max) => (length < min || length > max ? false : true);
const isEmailValid = (email) => {
    return emailregex.test(email);
};
const isPhoneValid = (contact) => {
    return phoneregex.test(contact);
};
const isPasswordValid = (pass) => {
    return psdregex.test(pass);
};

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
const checkFullName = () => {
    let valid = false;
    const min=2,max=30;
    const Vfullname = username.value.trim();
    const length = Vfullname.length;

    if(!isRequired(Vfullname)){
        displayError(username,'Full name is required.');
    }
    else if(!isBetween(length,min,max)){
        displayError(username,'Must be 2-30 characters long.');
    }else if(!nameregex.test(Vfullname)){
        displayError(username,'Invalid Full name.');
    }else{
        displaySuccess(username);
        valid = true;
    }
    return valid;
}
const checkEmail = () => {
    let valid = false;
    const Vemail = uemail.value.trim();

    if(!isRequired(Vemail)){
        displayError(uemail,'Email is required.');
    }
    else if(!emailregex.test(Vemail)){
        displayError(uemail,'Invalid email.');
    }else{
        displaySuccess(uemail);
        valid = true;
    }
    return valid;
}
const checkPhoneNumber = () => {
    let valid = false;
    const min=10,max=14;
    const Vphonenumber = uphone.value.trim();

    if(!isRequired(Vphonenumber)){
        displayError(uphone,'Phone number is required.');
    }
    else if(!isBetween(Vphonenumber.length,min,max)){
        displayError(uphone,'Must be 10 digits long.');
    }else if(!phoneregex.test(Vphonenumber)){
        displayError(uphone,'Invalid Phone number.');
    }else{
        displaySuccess(uphone);
        valid = true;
    }
    return valid;
}
const checkPassword = () => {
    let valid = false;
    const min=8,max=30;
    const Vpassword = upwd.value.trim();

    if(!isRequired(Vpassword)){
        displayError(upwd,'Password is required.');
    }
    else if(!isBetween(Vpassword.length,min,max)){
        displayError(upwd,'Must be 8-20 characters long');
    }else if(!usernameregex.test(Vpassword)){
        displayError(upwd,'Password must include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*).');
    }else{
        displaySuccess(upwd);
        valid = true;
    }
    return valid;
}
const matchPassword = () => {
    let valid = false;
    const Vpassword = repwd.value.trim();
    const password = upwd.value.trim();

    if(!isRequired(Vpassword)){
        displayError(repwd,'Password is required.');
    }
    else if(Vpassword.value !== password.value){
        displayError(repwd,'Passwords do not match');
    }
    else{
        displaySuccess(repwd);
        valid = true;
    }
    return valid;
}

const checkAddress = () => {
    let valid = false;
    const Vaddress = address.value.trim();

    if(!isRequired(Vaddress)){
        displayError(address,'Address is required.');
    }
    else if(!addressregex.test(Vaddress)){
        displayError(address,'Invalid Address.');
    }else{
        displaySuccess(address);
        valid = true;
    }
    return valid;
}
const checkPostalcode = () => {
    let valid = false;
    const Vpostalcode = postalcode.value.trim();

    if(!isRequired(Vpostalcode)){
        displayError(postalcode,'Postal code is required.');
    }
    else if(!postalregex.test(Vpostalcode)){
        displayError(postalcode,'Invalid postal code.');
    }else{
        displaySuccess(postalcode);
        valid = true;
    }
    return valid;
}
const checkState = () => {
    let valid = false;
    if(state.selectedIndex == 0){
        displayError(state,'State is required.');
    }
    else{
        displaySuccess(state);
        valid = true;
    }
    return valid;
}

const checkCountry = () => {
    let valid = false;
    if(country.selectedIndex == 0){
        displayError(country,'Country is required.');
    }
    else{
        displaySuccess(country);
        valid = true;
    }
    return valid;
}
const checkOptradio = ()=>{
    let valid = false;
    let optradiop = document.querySelector("#optradio");
    if(reg_user.optradio.value != "ADMIN" && 
    reg_user.optradio.value != "CLIENT" && 
    reg_user.optradio.value != "VENDOR" ){
        displayError(optradiop,'Choose a User Type');
    }else{
        displaySuccess(optradiop);
        valid = true;
    }
    return valid;
} 
const checkRecaptcha =()=>{
    let valid = false;
    const recaptcha = document.querySelector("#g-recaptcha-response");
    const recaptchaerr = document.querySelector("#recaptchaerr");
    var response = recaptcha.value;
    if(response.length == 0){
        displayError(recaptchaerr,'Please verify recaptcha.');
    }else{
        displaySuccess(recaptchaerr);
        valid = true;
    }
    return valid;
}


const debounce = (fn, delay = 1000) => {
    let timeoutId;
    return (...args) => {
        if (timeoutId) {
            clearTimeout(timeoutId);
        }
        timeoutId = setTimeout(() => {
            fn.apply(null, args)
        }, delay);
    };
};

reg_user.addEventListener('submit',function(e){
    e.preventDefault();
    let isFullnameValid = checkFullName(),
    isEmailVValid = checkEmail(),
    isPhonenumberValid = checkPhoneNumber(),
    isPasswordVValid = checkPassword(),
    ismatchpsd = matchPassword(),
    isOptradioVValid = checkOptradio(),
    isAddressVValid = checkAddress(),
    isStateVValid = checkState(),
    isPostalcodeVValid = checkPostalcode(),
    isCountryVValid = checkCountry(),
    isrecaptcha =checkRecaptcha();

    let isFormValid = isFullnameValid &&
    isEmailVValid && isPhonenumberValid && 
    isPasswordVValid && ismatchpsd && isOptradioVValid && isAddressVValid && isStateVValid && isPostalcodeVValid && isCountryVValid;
    
    if(isrecaptcha){
        if(isFormValid){
            reg_user.submit();
        }	
    }
    else{
        successmsg.textContent = 'Please Verify recaptcha to proceed further.';
        successmsg.classList.remove('text-success');
        successmsg.classList.add('text-danger');
    }
});

reg_user.addEventListener('input', debounce (function (e) {
    switch (e.target.id) {
        case 'fullname':
            checkFullName();
            break;
        case 'email':
            checkEmail();
            break;
        case 'contact':
            checkPhoneNumber();
            break;
        case 'pass':
            checkPassword();
            break;
        case 're_pass':
            matchPassword();
            break;
        case 'optradio':
            checkOptradio();
            break; 
        case 'address':
            checkAddress();
            break;
        case 'state':
            checkState();
            break;
        case 'postalcode':
            checkPostalcode();
            break;
        case 'country':
            checkCountry();
            break;
    }
}));
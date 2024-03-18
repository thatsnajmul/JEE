
//from event area started from here
function submitForm(event) {

    //The event. preventDefault() method stops the default action of an element from happening
    event.preventDefault();

    //Here we declare from all input field variable name
    let rName = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let pass = document.getElementById('pass').value;
    // // Here we are using query selector for pic a specific data to compare multiple value
    let gender = document.querySelector('input[name="gender"]:checked');
    // Here we are select multiple queryselector to using multiple checkbox
    let hobby = document.querySelectorAll('input[name="hobby"]:checked');
    hoobbyValue = [];
    // for (let index = 0; index < hobby.length; index++) {
    //     hoobbyValue.push(hobby[index].value);
    // }

    hoobbyValue = [];
    for (let index = 0; index < 0; index++) {
        hoobbyValue.push(hobby[index].value);
    }

    // let gender =document.querySelector('input[name="gender"]:checked');
    // let hobby = document.querySelectorAll('input[name="hobby"]:checked');
    // hobbyValue=[];
    // for(let index=0; index<0; index++){
    //     hobbyValue.push(hobby=[index].value);
    // }

    // let hoobbyValue = [];
    // hobby.forEach(
    //     function (hobby) {
    //         hoobbyValue.push(hobby.value);
    //     }
    // );

    //Again start as usual al other var decalar
    let course = document.getElementById('course').value;

    // let gender="";
    // let genderElements = document.getElementsByName('gender');
    // for(let i=0; i<genderElements.length; i++){
    //     if(genderElements[i]=checked){
    //         gender=genderElements[i].value;
    //     }
    // }

    // let hobbyArray = [];
    // let hobbyElements = document.getElementsByName('hobby');
    // for (let i = 0; i < hobbyElements.length; i++) {
    //     if (hobbyElements[i].checked) {
    //         hobbyArray.push(hobbyElements[i].value);
    //     }
    //keep

    // Again started to dob
    let dob = document.getElementById('dob').value;
    let comment = document.getElementById('comment').value;

    // Start from validation part
    if (rName == "") {
        alert("Name can't be empty");
        return;
    }
    else if (rName.length <= 3) {
        alert("Name Must be 4 charecter");
        return;
    }

    const regEx = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (regEx.test(email)) {

    }
    else {
        alert("Not a valid email address");
        return;
    }

    if (pass.length < 6 || pass.length >= 20) {
        alert("Password length must be 6 to 20 charrecters");
        return;
    }

    if (gender == null) {
        alert("Gender must be selected");
        return;
    }

    if (hobby.length == 0) {
        alert("Select at least one hobby");
        return;
    }
    if (course === 'choose') {

    }
    if (dob == "") {
        alert("Dob Must be given");
        return;
    }


    // if(rName==""){
    //     alert("Name can't be empty");
    //     return;
    // }
    // else if(rName.length<=3){
    //     alert("Name Must be 4 charecter");
    //     return;
    // }

    // const regEx= /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    // if(regEx.test(email)){

    // }
    // else{
    //     alert("Not a valid email address");
    //     return;
    // }

    // if(pass.length<6 || pass.length>=20){
    //     alert("Password length must be 6 to 20 charrecters");
    //     return;
    // }

    // if(gender==null){
    //     alert("Gender must be selected");
    //     return;
    // }

    // if(hobby.length==0){
    //     alert("Select at least one hobby");
    //     return;
    // }
    // if(course==='choose'){

    // }
    // if(dob==""){
    //     alert("Dob Must be given");
    //     return;
    // }

    // Here we are started output area to print line by line use \n
    // let output = "Name: " + rName + "\n";
    // output += "Email: " + email + "\n";
    // output += "Phone: " + phone + "\n";
    // output += "Pass: " + pass + "\n";
    // output += "Gender: " + gender.value + "\n";
    // output += "Course: " + course + "\n";
    // output += "Hobby: " + hoobbyValue + "\n";
    // output += "DOB: " + dob + "\n";
    // output += "Comment: " + comment + "\n";

    let output = "Name: " + rName + "\n";
    output += "Email: " + email + "\n";
    output += "Phone: " + phone + "\n";
    output += "Password: " + pass + "\n";
    output += "Gender: " + gender.value + "\n";
    output += "Course: " + course + "\n";
    output += "Hobby: " + hoobbyValue + "\n";
    // output += "Hobby: " +hobbyValue+ "\n";
    output += "DOB: " + dob + "\n";
    output += "Comment:" + comment + "\n";


    //Here we use newWindow = window.open("","_blank{to go another page and show value}")
    //Secoend line we are print all data finally
    // let newWindow = window.open("", '_blank');
    // newWindow.document.write("<pre>" + output + "</pre>");

    let newWindow = window.open("", '_blank');
    newWindow.document.write("<pre>" + output + "</pre>");
}

let myForm = document.getElementById("myForm");
myForm.addEventListener("submit", submitForm);

// //Here we write myForm that we declare to our main html form tag id
// let myForm = document.getElementById("myForm");

// //Here we fire a a event that name is addEvent Listener and we use 2 parameter
// myForm.addEventListener("submit", submitForm);


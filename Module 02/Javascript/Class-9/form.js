
//from event area started from here
function submitForm(event) {

    //The event. preventDefault() method stops the default action of an element from happening
    event.preventDefault();

    //Here we declare from all input field variable name
    let rName = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let pass = document.getElementById('pass').value;

    // Here we are using query selector for pic a specific data to compare multiple value
    let gender = document.querySelector('input[name="gender"]:checked').value;

    // Here we are select multiple queryselector to using multiple checkbox
    let hobby = document.querySelectorAll('input[name="hobby"]:checked');
    let hoobbyValue = [];
    hobby.forEach(
        function (hobby) {
            hoobbyValue.push(hobby.value);
        }
    );

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

    // Here we are started output area to print line by line use \n
    let output = "Name: " + rName + "\n";
    output += "Email: " + email + "\n";
    output += "Phone: " + phone + "\n";
    output += "Pass: " + pass + "\n";
    output += "Gender: " + gender + "\n";
    output += "Course: " + course + "\n";
    output += "Hobby: " + hoobbyValue + "\n";
    output += "DOB: " + dob + "\n";
    output += "Comment: " + comment + "\n";

    //Here we use newWindow = window.open("","_blank{to go another page and show value}")
    //Secoend line we are print all data finally
    let newWindow = window.open("", '_blank');
    newWindow.document.write("<pre>" + output + "</pre>");
}

//Here we write myForm that we declare to our main html form tag id
let myForm = document.getElementById("myForm");

//Here we fire a a event that name is addEvent Listener and we use 2 parameter
myForm.addEventListener("submit", submitForm);


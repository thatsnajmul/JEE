function submitForm(event) {

    event.preventDefault();


    let rName = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let pass = document.getElementById('pass').value;


    let gender=document.querySelector('input[name="gender"]:checked').value;
    // let hobby=document.querySelectorAll('input[name="hobby"]:checked').value;
    // let course=document.querySelector('input[name="course"]:checked').value;

    // let gender="";
    // let genderElements = document.getElementsByName('gender');
    // for(let i=0; i<genderElements.length; i++){
    //     if(genderElements[i]=checked){
    //         gender=genderElements[i].value;
    //     }
    // }

    // let hobArray = [];
    // let hobbyElements = document.getElementsByName('hobby');

    // let course = document.getElementById('course').value;

    
    let dob = document.getElementById('dob').value;
    let comment = document.getElementById('comment').value;

    let output = "Name: " + rName + "\n";
    output += "Email: " + email + "\n";
    output += "Phone: " + phone + "\n";
    output += "Pass: " + pass + "\n";
    output += "Gender: " + gender + "\n";
    // output += "Course: " + course + "\n";
    // output += "Hobby: " + hobby + "\n";
    output += "DOB: " + dob + "\n";
    output += "Comment: " + comment + "\n";


    let newWindow = window.open("", '_blank');
    newWindow.document.write("<pre>" + output + "</pre>");
}

let myForm = document.getElementById("myForm");

myForm.addEventListener("submit", submitForm);


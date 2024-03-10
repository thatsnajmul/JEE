function submitForm(event) {
    event.preventDefault();

    let rName = document.getElementById("name").value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    let gender = document.querySelector('input[name="gender"]:checked');
    let course=document.getElementById("course").value;
    let dob=document.getElementById('dob').value;

    let hoobyValue=[];
    for( let index=0; index<hobby.length; index++){
        hoobyValue.push(hobby[index].value);
    }

    if(rName==""){
        alert("Name can not be empty");
        return;
    }
    else if(rName.length<=3){
        alert("Name must have at least 4 charecter");
        return;
    }

    const regEx = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if(regEx.test(email)){

    }
    else{
        alert("Not a valied email address");
        return;
    }

    if(password.length<6 || password.length>=20){
        alert("Password length must be between 60 to 20 charecter");
        return;
    }
    if (gender==null){
        alert("Gender must be selected");
        return;
    }
    if(course==='Choose...'){
        alert("Select any Course");
        return;
    }
    if(dob==""){
        alert("Dob must be given");
        return;
    }

    let output = "Name: " + rName + "\n";
    output += "Email: " +email + "\n";
    output += "Password: " +password + "\n";
    output += "Gender: " +hoobyValue+ "\n";
    output += "Hobby: " +hoobyValue+ "\n";
    output += "Course: " +course+ "\n";
    output += "Dob: " +dob+ "\n";
    output += "Address: " +address+ "\n";


    let newWindow = window.open("", '_blank');
    newWindow.document.write("<pre>" + output + "</pre>")

}

let myForm = document.getElementById('myForm');
myForm.addEventListener('submit', submitForm);
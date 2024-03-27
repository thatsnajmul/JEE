function submitForm(event){
    event.preventDefault;

    let rName = document.getElementById('name').value;
    let gender= document.querySelector('input[name="gender"]:checked').value;
    let education = document.querySelectorAll('input[name="education"]:checked');


    if(rName.length && rName>20){
        alert('enter your correct name');
    }else{

    }

    educationValue =[];
    for(index=0; index<education.length; index++){
        educationValue.push(education[index].value);
    }

    let output = "Name: " +rName+ "\n";
     output += "Gender: " +gender+ "\n";
     output += "Education: " +educationValue+ "\n";


    let newWindow = window.open("", '_blank');
    newWindow.document.write("<pre>" +output+ "</pre>");

}

let myForm = document.getElementById('myForm');
myForm.addEventListener("submit", submitForm);

function submitForm(event) {
    event.preventDefault;

    let rName = document.getElementById('name').value;
    let phone = document.getElementById('phone').value;
    let remarks = document.getElementById('remarks').value;
    let sex = document.querySelector('input[name="sex"]:checkbox');
    let courses = document.querySelectorAll('input[name="courses"]:checkbox');
    let location = document.getElementById('location').value;

    let courseValue = [];
    for (let index = 0; index < courses.length; index++) {
        courseValue.push(courses[index]);
    }






    let output = "Name: " + rName + "\n";
    output += "Phone: " + phone + "\n";
    output += "Remarks: " + remarks + "\n";
    output += "Sex: " + sex + "\n";
    output += "Courses: " + courseValue + "\n";
    output += "Location: " + location + "\n";







    let newWindow = window.open('', '_blank');
    newWindow.document.write("<pre>" + output + "</pre>");
}

let myForm = document.getElementById('myForm');
myForm.addEventListener('submit', submitForm);
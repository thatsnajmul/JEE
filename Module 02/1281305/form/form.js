function submitForm(event){
    event.preventDefault;

    let rName = document.getElementById('name').value;            
    let phone = document.getElementById('name').value;            
    let remarks = document.getElementById('remarks').value;

    let gender = document.querySelector('input[name="gender"]:checked');
    let courses = document.querySelectorAll('input[name="courses"]:checked');

    

    let coursesValue = [];
    for(let i=0; i<courses.length; i++){
        coursesValue.push(courses[i]);
    }

    let location = document.getElementById('location').value;


    let output = "Name: " + rName + "\n";
        output += "Phone: " + phone + "\n";
        output += "Remarks: " +remarks + "\n";
        output +=  "Gender: " +gender.value+ "\n";
        output += "Courses: " +coursesValue+ "\n";
        output += "Location: " +location+ "\n";





    let newWindow= window.open('','_blank');
    newWindow.document.write("<pre>"+output+"</pre>");


}

  let myForm = document.getElementById('myForm');
  myForm.addEventListener('submit', submitForm);
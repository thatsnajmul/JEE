function submitForm(event){
    event.preventDefault;

    let rName= document.getElementById('name').value;
    let gender= document.querySelector('input[name="gender"]:checked').value;
    let courses= document.querySelectorAll('input[name="courses"]:checked');
    
    coursesValue=[];
    for(let index=0; index<courses.length; index++){
        coursesValue.push(courses[index].value);
    }

    let location= document.getElementById('location').value;
    
    let output = "Name: " +rName+ "\n";
    output += "Gender: " +gender+ "\n";
    output += "Courses: " +coursesValue+ "\n";
    output += "Location: " +location+ "\n";





   let newWindow = window.open('', '_blank');
    newWindow.document.write("<pre>"+output+"</pre>");

}


let myForm= document.getElementById('myForm');
    myForm.addEventListener('submit', submitForm);
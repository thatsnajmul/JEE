function Submitform(event){
    event.preventDefault;

    let rName = document.getElementById('name').value;
    let remarks = document.getElementById('remarks').value;
    let gender = document.querySelectorAll('');

    let courses = document.querySelector('');

    let coursesValue = [];
    for(coursesValue=0; coursesValue<courses.length; coursesValue++){

    }

    let location = document.getElementById('location').value;


    let output = "Name: " + rName + "\n";
        output += "Remarks: " +remarks + "\n";
        output +=  "Gender: " +gender + "\n";
        output += "Courses: " +courses+ "\n";
        output += "Location: " +location+ "\n";





    let newWindow= window.open('','_blank');
    newWindow=document.write(output);


}

  Submitform=addEventListener.
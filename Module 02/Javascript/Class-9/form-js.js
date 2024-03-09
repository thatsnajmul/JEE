function submitForm(event){
    event.preventDefault();

    let rName= document.getElementById('name').value;


    if(rName == ""){
        alert("Name can't be empty");
    }else if(rName.length<=3){
        alert("Name Must be 4 charecter");
        return;
    }

    let output = "Name: " + "\n";
    


    let newWindow = window.open("", '_blank');
    newWindow.document.write("<pre>"+output+"</pre>");
}

let myForm = document.getElementById("myForm");

myForm.addEventListener("submit", submitForm);
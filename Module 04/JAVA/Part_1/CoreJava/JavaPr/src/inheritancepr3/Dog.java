
package inheritancepr3;


public class Dog extends Animal{
    private String breed;
    

    public Dog() {
    }

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        super.makeSound(); 
        System.out.println(this.breed);
    }

    

    
    
    
    
    
}

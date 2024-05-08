
package phone;

//Supper Class
public class Mobile {
    //Variable declare
    private boolean makecall;
    private boolean makeText;
    private boolean camera;
    private boolean multimedia;
    
    //Default constractor or relational constractor
     public Mobile() {
    }
    //Argument constractor select 2
     public Mobile(boolean makecall, boolean message, boolean camera, boolean multimedia) {
        this.makecall = makecall;
        this.makeText = message;
        this.camera = camera;
        this.multimedia = multimedia;
    }

    //Getter and Setter
    public boolean isMakecall() {
        return makecall;
    }

    public void setMakecall(boolean makecall) {
        this.makecall = makecall;
    }

    public boolean isMessage() {
        return makeText;
    }

    public void setMessage(boolean message) {
        this.makeText = message;
    }

    public boolean isCamera() {
        return camera;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public boolean isMultimedia() {
        return multimedia;
    }

    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }

    //To String
    @Override
    public String toString() {
        return "Mobile{" + "makecall=" + makecall + ", message=" + makeText + ", camera=" + camera + ", multimedia=" + multimedia + '}';
    }
    //Override
    
    

    
   
   
    
}

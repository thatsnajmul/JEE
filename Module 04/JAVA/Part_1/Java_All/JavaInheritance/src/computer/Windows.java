
package computer;

//Supper Class
public class Windows {

    
    
    //private variable declaration with sepecific data type
    private String msstore;
    private String iebrowser;
    private boolean winDisplay;
    
    public Windows() {
    }

    public Windows(String msstore, String iebrowser, boolean winDisplay) {
        this.msstore = msstore;
        this.iebrowser = iebrowser;
        this.winDisplay = winDisplay;
    }

    public String getMsstore() {
        return msstore;
    }

    public void setMsstore(String msstore) {
        this.msstore = msstore;
    }

    public String getIebrowser() {
        return iebrowser;
    }

    public void setIebrowser(String iebrowser) {
        this.iebrowser = iebrowser;
    }

    public boolean isWinDisplay() {
        return winDisplay;
    }

    public void setWinDisplay(boolean winDisplay) {
        this.winDisplay = winDisplay;
    }

    @Override
    public String toString() {
        return "Windows{" + "msstore=" + msstore + ", iebrowser=" + iebrowser + ", winDisplay=" + winDisplay + '}';
    }
    
    
    
    
    
}

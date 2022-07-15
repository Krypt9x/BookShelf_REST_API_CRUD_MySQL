package BookShelfAPICRUD.BookShelfAPICRUD;

public class RecordNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;
    private String msg;
    public RecordNotFoundException(String msg){
        super();
        this.msg = msg;
    }
}

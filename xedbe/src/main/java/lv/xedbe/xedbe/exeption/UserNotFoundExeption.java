package lv.xedbe.xedbe.exeption;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption(Long id){
        super("Not found user "+id);
    }
}

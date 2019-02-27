public class NameWithNumbersException extends RuntimeException {
    NameWithNumbersException(){
        System.out.println("NameWithNumbersException: Имя не должно содержать цифр");
        System.exit(0);
    }
}

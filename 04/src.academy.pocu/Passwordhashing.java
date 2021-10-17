package src.academy.pocu;

public class Passwordhashing {

    public static void main(String[] args) {
        User user = new User("myemail@email.com",
                "My StRoNg P@$$word");

        System.out.println("ID ::: " + user.getId());

        System.out.println("Email ::: " + user.getEmail());

        System.out.println("Password Hash ::: " + user.getPaswordHash());

        boolean isValid = user.isValidPassword("wrong password!");

        System.out.println(isValid);

        isValid = user.isValidPassword("My StRoNg P@$$word");

        System.out.println(isValid);
    }

}

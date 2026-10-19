
package mycompany.project1.validitionMessage;




public final class ValidationMessages {
    public static final String USERNAME_CAPTURED = "Username successfully captured.";
    public static final String USERNAME_INVALID =
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";

    public static final String PASSWORD_CAPTURED = "Password successfully captured.";
    public static final String PASSWORD_INVALID =
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

    public static final String CELL_CAPTURED = "Cell number successfully captured.";
    public static final String CELL_INVALID =
            "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";

    public static final String LOGIN_FAILED = "Username or password incorrect, please try again.";

    public static final String REGISTERED_SUCCESSFULLY = "The two above conditions have been met, and the user has been registered successfully.";

    private ValidationMessages() {
    }

    public static String welcome(String firstName, String lastName) {
        return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
    }
}    


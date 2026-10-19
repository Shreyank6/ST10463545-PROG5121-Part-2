
package mycompany.project1;
import java.util.regex.Pattern;
import mycompany.project1.validitionMessage.ValidationMessages;

public class Login {
    private String firstName= "";
    private String lastName= "";
    private String username= "";
    private String password= "";
    private String cellPhoneNumber= "";
    private String loginUsername= "";
    private String loginPassword= "";
    private User registeredUser;

   
    private static final Pattern SA_CELL_PATTERN = Pattern.compile("^\\+27[0-9]{1,10}$");

    public Login() {
    }

    public Login(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

   
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

   
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char current = password.charAt(i);
            if (Character.isUpperCase(current)) {
                hasCapital = true;
            } else if (Character.isDigit(current)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(current)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    
    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber != null && SA_CELL_PATTERN.matcher(cellPhoneNumber).matches();
    }

    public String getUsernameMessage() {
        if (checkUserName()) {
            return ValidationMessages.USERNAME_CAPTURED;
        }
        return ValidationMessages.USERNAME_INVALID;
    }

    public String getPasswordMessage() {
        if (checkPasswordComplexity()) {
            return ValidationMessages.PASSWORD_CAPTURED;
        }
        return ValidationMessages.PASSWORD_INVALID;
    }

    public String getCellPhoneMessage() {
        if (checkCellPhoneNumber()) {
            return ValidationMessages.CELL_CAPTURED;
        }
        return ValidationMessages.CELL_INVALID;
    }
    
    public String registerUser() {
        if (!checkUserName()) {
            return ValidationMessages.USERNAME_INVALID;
        }
        if (!checkPasswordComplexity()) {
            return ValidationMessages.PASSWORD_INVALID;
        }

        if (checkCellPhoneNumber()) {
            registeredUser = new User(firstName, lastName, username, password, cellPhoneNumber);
            return ValidationMessages.REGISTERED_SUCCESSFULLY;
        }

        return ValidationMessages.USERNAME_CAPTURED + " " + ValidationMessages.PASSWORD_CAPTURED
                + " " + ValidationMessages.CELL_INVALID;
    }

    //Confirms that the login details match the details stored at registration.
    
    public boolean loginUser() {
        if (registeredUser == null || loginUsername == null || loginPassword == null) {
            return false;
        }
        return registeredUser.getUsername().equals(loginUsername)
                && registeredUser.getPassword().equals(loginPassword);
    }

    //Returns the welcome or failure message for the current login attempt.
     
    public String returnLoginStatus() {
        if (loginUser()) {
            return ValidationMessages.welcome(registeredUser.getFirstName(), registeredUser.getLastName());
        }
        return ValidationMessages.LOGIN_FAILED;
    }

    boolean isRegistered() {
       return registeredUser != null;
    }

    void setEnteredUsername(String nextLine) {
        this.loginUsername = nextLine;
    }

    void setEnteredPassword(String nextLine) {
        this.loginPassword = nextLine;
    }
}
    


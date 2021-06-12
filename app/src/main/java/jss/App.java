package jss;

import gui.MainFrame;

public class App {

    public static void main(String[] args) {

        new GUILauncher();
        MainFrame main = new MainFrame();

        /* Brendan's notes

        *  Main ->
        *  1) loads / creates the frame. Frame has a method for replacing header and replacing body.
        *
        *  2) LoginScreen login = new Login Screen   (would this be "controller"? a loginController?)
        *     Then run login.loadLogin()
        *     loadLogin() will return a validated user.
        *     If user enters credentials wrong displays:
        *     JFrame popup = new JFrame(); JOptionPane.showMessageDialog(popup, "Incorrect email or password", "Error", JOptionPane.ERROR_MESSAGE);
        *     This creates a popup that says incorrect user name.
        *     The loadLogin() method has a while loop that listens for input and continues until a username and password is validated.
        *     This is triggered when a username and password are entered and login button clicked.
        *     If user selects register the option to create a user is loaded/called as a branch of Login, bringing the user back into the while loop once created or Cancel is selected.
        *     That person can then insert their credentials.
        *     Once a valid user is validated, it can be returned to main as a User like this:
        *     User validatedUser = new Recruiter() or User validatedUser = new jobSeeker()
        *     (this is determined by the validation method)
        *     return validatedUser;

        *  3) Main calls an internal method called "clearFrame()"
        *     clearFrame(){frame.removeAll(); frame.revalidate(); frame.repaint();}
        *
        *  4) main then loads either the recruiter screen or the jobSeeker screen based on the following boolean result:
        *     boolean isRecruiter = returnedUser instanceof Recruiter;
        *     if (isRecruiter) loadRecruiterScreen(); else loadJobSeekerScreen();
        *
        * */

    }
}

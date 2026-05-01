/*
 * Entry point for the Number Guessing Game JavaFX application.
 */

package NumberGuessingGame;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * This method is called when the JavaFX application is launched.
     * It sets up the primary stage (main window), loads the FXML layout,
     * sets the application icon and title, and shows the UI.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set the application icon (from the same package as the class)
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("guessGame.png")));

        // Load the UI layout from FXML file
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        // Set the title of the application window
        primaryStage.setTitle("Number Guessing Game");

        // Set the scene using the loaded layout
        primaryStage.setScene(new Scene(root));

        // Display the window
        primaryStage.show();
    }

    /**
     * Main method - the entry point of the Java application.
     * Launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args); // Start JavaFX application
    }
}

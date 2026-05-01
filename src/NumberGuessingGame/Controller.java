package NumberGuessingGame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.util.Random;

public class Controller {

    // UI elements connected from FXML
    @FXML private TextField guessField;
    @FXML private Label messageLabel;
    @FXML private Label timerLabel;
    @FXML private Label attemptsLabel;
    @FXML private Button guessButton;
    @FXML private Button retryButton;
    @FXML private ProgressBar timeProgressBar;

    // Game variables
    private int secretNumber;      // the number the player must guess
    private int attempts;          // how many attempts the player has made
    private final int maxAttempts = 3;  // max allowed attempts
    private int timeLeft = 30;     // time left for current attempt
    private Timeline timer;        // timer for countdown

    @FXML
    public void initialize() {
        setupGame(); // set initial game state

        // Prevent non-numeric input in the text field
        guessField.textProperty().addListener((obs, oldText, newText) -> {
            if (!newText.matches("\\d*")) {
                guessField.setText(newText.replaceAll("[^\\d]", ""));
            }
        });

        // Set up button actions
        guessButton.setOnAction(e -> handleGuess());
        retryButton.setOnAction(e -> resetGame());
    }

    /**
     * Called when the user presses the "Guess" button.
     * Processes the input and checks the guess.
     */
    private void handleGuess() {
        String input = guessField.getText().trim();
        if (input.isEmpty()) {
            messageLabel.setText("⚠️ Please enter a number!");
            return;
        }

        int guess = Integer.parseInt(input);
        attempts++; // increase attempt count
        attemptsLabel.setText("Attempt: " + attempts + " / " + maxAttempts);

        // Logic for comparing guess with the secret number
        if (guess == secretNumber) {
            messageLabel.setText("🎉 You won! The correct number is: " + secretNumber);
            stopGame(); // stop game and timer
        } else if (guess < secretNumber / 2) {
            messageLabel.setText("⬇️ Too Low");
        } else if (guess < secretNumber) {
            messageLabel.setText("⤵️ Low");
        } else if (guess > secretNumber * 2) {
            messageLabel.setText("⤴️ Too High");
        } else {
            messageLabel.setText("⬆️ High");
        }

        // Check if all attempts are used
        if (attempts >= maxAttempts) {
            messageLabel.setText("❌ You lost! The correct number was: " + secretNumber);
            stopGame(); // game over
        } else {
            resetTimer(); // restart countdown for next attempt
        }

        guessField.clear(); // clear input field
    }

    /**
     * Initializes the game with a random number and resets all UI and game variables.
     */
    private void setupGame() {
        secretNumber = new Random().nextInt(9999) + 1; // generate number from 1 to 9999
        attempts = 0;
        timeLeft = 30;
        System.out.println(secretNumber);
        // Enable/disable buttons and inputs
        guessField.setDisable(false);
        guessButton.setDisable(false);
        retryButton.setDisable(true);

        // Reset labels
        messageLabel.setText("🎯Guess a Number between 1 & 9999🎯");
        timerLabel.setText("⏱️ Time left: 30 seconds");
        attemptsLabel.setText("Attempt: 0 / " + maxAttempts);
        timeProgressBar.setProgress(1.0);

        startTimer(); // start countdown timer
    }

    /**
     * Starts the countdown timer for each attempt.
     * Decreases timeLeft every second and handles timeout logic.
     */
    private void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--; // decrease time
            timerLabel.setText("⏱️ Time left: " + timeLeft + " seconds");

            // Update progress bar
            double progress = (double) timeLeft / 30;
            timeProgressBar.setProgress(progress);

            // If time runs out for this attempt
            if (timeLeft <= 0) {
                attempts++;
                attemptsLabel.setText("Attempt: " + attempts + " / " + maxAttempts);
                messageLabel.setText("⏳ Time is up for this attempt!");

                // Check if this was the last attempt
                if (attempts >= maxAttempts) {
                    messageLabel.setText("❌ You lost! The correct number was: " + secretNumber);
                    stopGame(); // stop everything
                } else {
                    resetTimer(); // give new 30 seconds for next attempt
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE); // run forever (until manually stopped)
        timer.play(); // start timer
    }

    /**
     * Resets the countdown timer to 30 seconds and updates UI accordingly.
     */
    private void resetTimer() {
        timeLeft = 30;
        timerLabel.setText("⏱️ Time left: 30 seconds");
        timeProgressBar.setProgress(1.0);
    }

    /**
     * Called when the game ends (either win or lose).
     * Disables inputs and stops the timer.
     */
    private void stopGame() {
        if (timer != null) timer.stop(); // stop countdown
        guessField.setDisable(true);
        guessButton.setDisable(true);
        retryButton.setDisable(false); // allow restarting
    }

    /**
     * Resets everything to restart the game.
     */
    private void resetGame() {
        if (timer != null) timer.stop(); // stop current timer
        setupGame(); // set up new game
    }
}

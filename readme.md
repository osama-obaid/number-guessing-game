# 🎮 Number Guessing Game (JavaFX)

## 📌 Project Description

This project is a **Number Guessing Game** developed using Java and JavaFX.

The game challenges the player to guess a randomly generated number within a limited number of attempts and time.

It provides hints such as **"Too High"** or **"Too Low"** to guide the player toward the correct answer.

---

## 🚀 Features

* 🎯 Random number generation
* ⏱ Countdown timer (e.g., 30 seconds per attempt)
* 🔁 Limited number of attempts
* 💡 Hints:

  * Too High
  * Too Low
* 🎮 Interactive GUI using JavaFX
* 📈 Level system (progressive difficulty)

---

## 🛠 Technologies Used

### Language:

* Java

### Framework:

* JavaFX

### Tools:

* Apache Ant (build system)

---

## 📁 Project Structure

```
NUMBERGUESSINGGAME/
│
├── src/                      # Source code
├── build/                    # Compiled files
├── dist/                     # Executable JAR
├── nbproject/                # NetBeans configuration
│
├── build.xml                 # Build file
├── manifest.mf              # App configuration
```

---

## ⚙️ Requirements

Before running the project:

* Java JDK 1.8 or higher
* JavaFX SDK
* NetBeans (optional but recommended)

---

## 📦 Installation

1. Clone the repository:

```
git clone https://github.com/osama-obaid/number-guessing-game.git
cd number-guessing-game
```

---

## ▶️ How to Run

### 🔹 Option 1: Using NetBeans

* Open the project
* Click **Run**

---

### 🔹 Option 2: Using Command Line

Build the project:

```
ant build
```

Run the JAR file:

```
java -jar dist/NumberGuessingGame.jar
```

---

## 🧠 How It Works

1. The system generates a random number
2. The player tries to guess it
3. After each attempt:

   * If the guess is higher → "Too High"
   * If lower → "Too Low"
4. The game ends when:

   * Player guesses correctly 🎉
   * Or runs out of attempts

---

## 📌 Future Improvements

* 🎨 Improve UI/UX design
* 🔊 Add sound effects
* 🏆 Add score system
* 💾 Save high scores
* 📱 Convert to mobile version

---

## 👨‍💻 Author

**Osama Abdullah Obaid**
osamhobaid4@gmail.com
IT Engineer | Software Developer

---

## 📄 License

This project is for educational purposes.

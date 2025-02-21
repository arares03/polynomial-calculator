# Polynomial Calculator

## Assignment Objective
This project is a **Polynomial Calculator** with a **Graphical User Interface (GUI)**. Users can input polynomials and perform various operations:

- **Addition**
- **Subtraction**
- **Multiplication**
- **Division** (with remainder handling)
- **Differentiation**
- **Integration**

The GUI is built using **Java Swing**, and the backend follows the **Model-View-Controller (MVC)** pattern.

---

## Features
- **Polynomial Input as Strings**: Users can enter polynomials in a standard notation.
- **Operation Selection via Radio Buttons**: A simple way to choose desired operations.
- **Result Display**: Outputs computed results in real-time.
- **Robust Input Validation**: Ensures correct data entry.
- **JUnit Testing**: Automated tests for each operation to validate correctness.

---

## Technologies Used
- **Java** (Core Language)
- **Swing** (GUI Framework)
- **JUnit** (Testing)
- **HashMap** (Polynomial Storage)
- **MVC Design Pattern**

---

## Project Structure
```
📂 src/
 ├── 📁 controller/  # Handles logic
 ├── 📁 model/       # Polynomial operations
 ├── 📁 view/        # GUI Implementation
 ├── 📁 tests/       # JUnit test cases
```

### Key Classes
- **Controller**: Handles user input and processes polynomial operations.
- **Operations**: Implements polynomial addition, subtraction, multiplication, division, differentiation, and integration.
- **Polynomial**: Data structure to store polynomial terms using `HashMap<Integer, Double>`.
- **View**: Implements GUI using **Swing** components.
- **Tests**: JUnit test cases to validate core functionalities.

---

## Installation & Usage
### Prerequisites
- Java (JDK 8+)
- Any Java IDE (IntelliJ, Eclipse, VS Code)

### Running the Application
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/polynomial-calculator.git
   ```
2. Navigate to the project folder:
   ```sh
   cd polynomial-calculator
   ```
3. Compile and Run:
   ```sh
   javac src/Main.java
   java src.Main
   ```

---

## Future Improvements
- **Better GUI Design** with improved layout and responsiveness.
- **Support for Multivariate Polynomials**.
- **Optimized Algorithms** for polynomial operations.

---

## Credits
- **PT Course, TUCN**
- **Stack Overflow** (for guidance and troubleshooting)


# 🚀 Team 1 Mars Rover Simulation (Winston , Nahum , Samarth )

## 📚 Table of Contents
1. [Project Overview](#-project-overview)
2. [Original Thoughtworks Problem](#-original-thoughtworks-problem)
3. [Our Approach and Enhancements](#-our-approach-and-enhancements)
4. [Requirements Comparison](#-requirements-comparison)
5. [Team Members](#-team-members)
6. [Functional Requirements](#-functional-requirements)
7. [Non-Functional Requirements](#-non-functional-requirements)
8. [Getting Started](#-getting-started)
9. [Dependencies](#-dependencies)
10. [Build and Run](#-build-and-run)
11. [Testing](#-testing)
12. [CI/CD](#-cicd)
13. [Code Quality](#-code-quality)
14. [Project Structure](#-project-structure)
15. [Concepts and Design Patterns](#-concepts-and-design-patterns)
16. [Contributing](#-contributing)
17. [License](#-license)

## 🌟 Project Overview
Our Mars Rover Project( # 🚀 Team 1 Mars Rover Simulation (Winston , Nahum , Samarth )) is an advanced implementation of the classic Thoughtworks Mars Rover problem. Our team has taken the original challenge and significantly expanded it, creating a robust and feature-rich simulation that exceeds the basic requirements.

## 🎯 Original Thoughtworks Problem
As described by [danilsuits](https://danilsuits.github.io/mars-rover-kata/):

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

### Input:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

### Output:
The output for each rover should be its final co-ordinates and heading.

### Example:
Test Input:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

Expected Output:
```
1 3 N
5 1 E
```

## 🚀 Our Approach and Enhancements
We've elevated the original concept by incorporating:

1. **Multiple Rover Types**: Introducing standard and jumping rovers, each with unique capabilities.
2. **Advanced Collision Detection**: Ensuring rovers don't occupy the same space.
3. **Enhanced Console Visualization**: Rich, colorful representation of the plateau and rover positions using ANSI escape codes.
4. **Extended Command Set**: Implementing additional commands beyond the basic move and rotate, including support for jumping rovers.
5. **Distance Tracking**: Calculating and reporting the total distance traveled by each rover.
6. **Robust Error Handling**: Comprehensive input validation and error reporting, including out-of-bounds movement prevention.
7. **Scalable Architecture**: Designed to easily accommodate new rover types or commands.
8. **Interactive Command Input**: Allowing users to input commands for each rover sequentially.
9. **Informative Console Output**: Providing clear feedback on rover movements, including successful moves and warnings for invalid actions.

## 📊 Requirements Comparison

| Requirement Type | Original Thoughtworks Problem | Our Project's Requirements | Given Requirements | Extra Credit |
|------------------|-------------------------------|----------------------------|---------------------|--------------|
| **Functional Requirements** | | | | |
| Plateau Creation | Create a rectangular plateau | Create a rectangular plateau with user-defined grid | Create a rectangular plateau | |
| Rover Deployment | Deploy multiple rovers | Support deployment of multiple rovers | Deploy multiple rovers | |
| Rover Types | Single type of rover | Implement standard and jumping rovers | Not specified | ✨ |
| Movement Commands | L, R, M commands | L, R, M commands + J for jumping rovers | L, R, M commands | ✨ |
| Boundary Handling | Implicit (not specified) | Ensure rovers don't move outside boundaries | Not specified | |
| Collision Detection | Not specified | Implement collision detection | Not specified | ✨ |
| Distance Tracking | Not specified | Calculate and report distance traveled | Not specified | ✨ |
| Visualization | Not specified | Provide visual representation using ANSI escape codes | Not specified | ✨ |
| Sequential Control | Specified | Allow sequential control of multiple rovers | Specified | |
| Feedback | Output final position | Provide clear feedback on movements, errors, warnings | Output final position | |
| **Non-Functional Requirements** | | | | |
| Performance | Not specified | Efficient command processing for multiple rovers | Not specified | |
| Scalability | Not specified | Handle various plateau sizes and multiple rovers | Not specified | |
| Maintainability | Not specified | Clean code, SOLID principles, design patterns | Implement OO principles | |
| Testability | Not specified | High test coverage using JUnit and Mockito | Use TDD | |
| Usability | Not specified | Clear console output, intuitive input interface | Not specified | ✨ |
| Extensibility | Not specified | Easy accommodation of new rover types/commands | Not specified | |
| Reliability | Not specified | Robust error handling and input validation | Not specified | |
| Code Quality | Not specified | Adhere to Java standards, consistent style | Follow design principles | |
| Version Control | Not specified | Not explicitly mentioned (but using Git) | Use collaborative development with Git | |
| Documentation | Not specified | Comprehensive README and inline comments | Document decisions with ADRs | |

Legend:
✨ - Extra Credit Feature

### Key Enhancements and Extra Credit Features(OUTPUT SCREENSHOTS: https://github.com/samarthtiku/TEAM1-MARS-ROVER-KATA-WINSTON_NAHUM_SAM-/blob/seventh-Branch/MARSROVER_TEAM1_OUTPUT.pdf)

1. **Multiple Rover Types**: We introduced both standard and jumping rovers, adding complexity to the simulation.
2. **Advanced Movement Commands**: In addition to the basic L, R, and M commands, we implemented a J command for jumping rovers.
3. **Collision Detection**: Our simulation prevents rovers from occupying the same position, adding realism to the scenario.
4. **Distance Tracking**: We calculate and report the total distance traveled by each rover, providing valuable metrics.
5. **Enhanced Visualization with ANSI Escape Codes**: We implemented a visually rich console interface using ANSI escape codes. This feature includes:
   - Color-coded representation of different rover types
   - Dynamic updating of the plateau state
   - Visually distinct representations for rover orientations (e.g., ↑, →, ↓, ←)
   - Highlighted feedback for successful moves and error states
6. **Improved Usability**: We focused on creating clear console output and an intuitive command input interface for a better user experience, leveraging the ANSI escape codes for enhanced readability.

## 👥 Team Members
This project was developed collaboratively by:

1. **Winston** - [GitHub Profile](https://github.com/kvngwinston) <!-- Replace with actual GitHub profile link -->
2. **Nahum** - [GitHub Profile](https://github.com/nahumguess) <!-- Replace with actual GitHub profile link -->
3. **Samarth Tiku** - [GitHub Profile](https://github.com/samarthtiku)

## 📋 Functional Requirements
1. Create a rectangular plateau with a user-defined grid coordinate system.
2. Support deployment of multiple rovers on the plateau.
3. Implement two types of rovers: standard and jumping.
4. Process movement commands for each rover: 'L' (turn left), 'R' (turn right), 'M' (move forward).
5. Implement an additional 'J' (jump) command for jumping rovers.
6. Ensure rovers do not move outside the plateau boundaries.
7. Implement collision detection to prevent rovers from occupying the same position.
8. Calculate and report the distance traveled by each rover.
9. Provide an enhanced visual representation of the plateau and rover positions using ANSI escape codes for colors and formatting.
10. Allow sequential control of multiple rovers.
11. Provide clear feedback on rover movements and any errors or warnings.

## 🔧 Non-Functional Requirements
1. **Performance**: The simulation should process commands for multiple rovers efficiently.
2. **Scalability**: The system should handle plateaus of various sizes and multiple rovers without significant performance degradation.
3. **Maintainability**: Implement clean code practices, SOLID principles, and appropriate design patterns.
4. **Testability**: Achieve high test coverage (aim for >80%) using JUnit and Mockito.
5. **Usability**: Provide clear console output and intuitive command input interface.
6. **Extensibility**: Design the system to easily accommodate new types of rovers or commands.
7. **Reliability**: Implement robust error handling and input validation.
8. **Code Quality**: Adhere to Java coding standards and maintain consistent code style.

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Gradle 8.5 or higher

### 🛠️ Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/samarthtiku/TEAM1-MARS-ROVER-KATA-WINSTON_NAHUM_SAM-.git
   ```
2. Navigate to the project directory:
   ```bash
   cd TEAM1-MARS-ROVER-KATA-WINSTON_NAHUM_SAM-
   ```
3. Checkout the default branch:
   ```bash
   git checkout seventh-Branch
   ```

## 📦 Dependencies
This project uses the following dependencies:

- [🧪 JUnit 5](https://junit.org/junit5/) (org.junit.jupiter:junit-jupiter:5.9.2) for testing
- [🃏 Mockito](https://site.mockito.org/) (org.mockito:mockito-core:5.3.1) for mocking in tests
- [🐘 Gradle 8.5](https://gradle.org/) as the build tool

##  🏗️ Build and Run ( Compilation and Execution )

If you prefer to compile and run the project manually, follow these steps:

1. **Compile the project:** 
   First, you need to compile the project using Gradle:

   ```bash
   ./gradlew build
   ```

2. **Navigate to the compiled classes directory:** 
   The compiled `.class` files are stored in the `build/classes/java/main` directory:

   ```bash
   cd build/classes/java/main
   ```

3. **Run the main class:** 
   Use the `java` command to run the main class (`MarsRoverApplication`). Ensure you provide the full package name:

   ```bash
   java com.marsrover.application.MarsRoverApplication
   ```

### Notes(Alternative way To run the simulation)

- #### Right-click on MarsRoverApplication.java.
- #### Select Run 'MarsRoverApplication.main()'.
- #### This will compile and run the Mars Rover simulation

## 🧪 Testing

Run tests with:
```bash
./gradlew test
```

## 🔄 CI/CD

This project uses GitHub Actions for Continuous Integration. The workflow is defined in `.github/workflows/ci.yml`. It automatically builds the project, runs tests, and performs static code analysis on every push and pull request to the `seventh-Branch`.

## 🔍 Code Quality

We use the following tools for ensuring code quality:

- [🕵️ Infer](https://fbinfer.com/): Static analysis tool
  To run Infer:
  ```bash
  infer run -- ./gradlew build
  ```

- [📏 Checkstyle](https://checkstyle.sourceforge.io/): Code style enforcement
  Run Checkstyle with:
  ```bash
  ./gradlew checkstyleMain
  ```

## 📁 Project Structure
```
TEAM1-MARS-ROVER-KATA-WINSTON_NAHUM_SAM-/
├── src/
│   ├── main/java/com/marsrover/
│   │   ├── application/
│   │   │   ├── MarsRoverApplication.java
│   │   │   └── MarsRoverProgram.java
│   │   ├── model/
│   │   │   ├── AbstractRover.java
│   │   │   ├── StandardRover.java
│   │   │   ├── JumpingRover.java
│   │   │   ├── Plateau.java
│   │   │   └── Orientation.java
│   │   ├── service/
│   │   │   ├── InputHandler.java
│   │   │   ├── ConsoleInputHandler.java
│   │   │   ├── RoverFactory.java
│   │   │   └── RoverFactoryImpl.java
│   │   └── util/
│   │       ├── PlateauVisualizer.java
│   │       └── Configuration.java
│   └── test/java/com/marsrover/
│       ├── application/
│       ├── model/
│       ├── service/
│       └── util/
├── .github/workflows/
│   └── ci.yml
├── build.gradle.kts
├── settings.gradle.kts
├── README.md

```

## 🧠 Concepts and Design Patterns

Our Mars Rover Simulation project incorporates a wide range of software engineering concepts and design patterns:

### 🏗️ Object-Oriented Programming (OOP) Concepts
1. **Encapsulation**: Used in classes like `Plateau` and `AbstractRover`.
2. **Inheritance**: Rover hierarchy with `AbstractRover` as the base class.
3. **Polymorphism**: Different rover types can be used interchangeably.
4. **Abstraction**: `AbstractRover` provides a common interface for all rover types.

## 🎨 Design Patterns

- **Factory Pattern**: 
  - Implemented in `RoverFactory` and `RoverFactoryImpl`.
  - Centralizes the creation of different types of rovers (e.g., `StandardRover`, `JumpingRover`).
  - Ensures flexibility for adding new rover types without modifying existing code, following the **Open/Closed Principle**.

- **Command Pattern**: 
  - Used to implement rover movement commands (`L`, `R`, `M`) as separate objects.
  - Encapsulates each command, making it easy to manage command sequences and extend with new commands.
  - Facilitates future enhancements like undo/redo functionality.

- **Strategy Pattern**: 
  - Handles different movement algorithms for various rover types.
  - For example, `StandardMovementStrategy` for standard rovers and `JumpingMovementStrategy` for jumping rovers.
  - Simplifies the `Rover` class by delegating movement behavior, making it easy to add new strategies.

- **Singleton Pattern**: 
  - Used for `PlateauConfiguration` to ensure only one instance of the plateau configuration exists.
  - Prevents inconsistent or conflicting settings across the application and optimizes memory usage.

- **Memento Pattern**: 
  - Enables undo/redo functionality by storing snapshots of rover states at specific points in time.
  - Encapsulates the rover's internal state without exposing it, enhancing user experience for error recovery.

- **Observer Pattern**: 
  - Allows real-time monitoring of rover status changes during simulation.
  - Decouples rover movement logic from the rest of the system, making it easy to add new components like a visualization module or logging.

- **Iterator Pattern**: 
  - Processes sequences of rover movement commands in a standardized way.
  - Separates command traversal from the underlying command representation, ensuring clean and efficient command execution.


### 🧱 SOLID Principles
1. **Single Responsibility Principle**: Each class has a well-defined purpose.
2. **Open/Closed Principle**: System is open for extension but closed for modification.
3. **Liskov Substitution Principle**: Subclasses can be used interchangeably with base class.
4. **Interface Segregation**: Use of focused interfaces like `InputHandler`.
5. **Dependency Inversion**: High-level modules depend on abstractions.

### 💡 Other Programming Concepts
1. **Enums**: Used for `Orientation` (N, E, S, W).
2. **Exception Handling**: Implemented for invalid inputs and out-of-bounds movements.
3. **Immutability**: `Plateau` class designed as immutable for thread safety.

### 🛠️ Software Engineering Practices
1. **Test-Driven Development (TDD)**: Used throughout the development process.
2. **Continuous Integration**: Implemented using GitHub Actions.
3. **Version Control**: Git used for source code management.

### 📊 Data Structures and Algorithms
1. **2D Grid**: Used in `Plateau` to represent the Mars surface.
2. **Lists and Maps**: Used for managing rovers and their positions.
3. **Grid Navigation Algorithms**: For moving rovers and collision detection.

### 🖥️ User Interface Concepts
1. **Command-Line Interface (CLI)**: For user input and output.
2. **ANSI Escape Codes**: For colorful and formatted console output.

## 🤝 Contributing

We welcome contributions to the Mars Rover Simulation project! Your input is valuable in making this project better for everyone. Here's how you can contribute:

### Getting Started

1. Fork the repository on GitHub.
2. Clone your forked repository to your local machine.
3. Create a new branch for your feature or bug fix:
   ```
   git checkout -b feature/AmazingFeature
   ```

### Making Changes

1. Make your changes in your feature branch.
2. Add or update tests as necessary.
3. Ensure your code adheres to our coding standards (see below).
4. Run the test suite to make sure all tests pass:
   ```
   ./gradlew test
   ```
5. Update the documentation, including README.md and ADRs if necessary.

### Submitting Changes

1. Commit your changes:
   ```
   git commit -m 'Add some AmazingFeature'
   ```
2. Push to your fork:
   ```
   git push origin feature/AmazingFeature
   ```
3. Open a Pull Request from your fork to our repository.

### Pull Request Guidelines

- Provide a clear description of the problem you're solving or the feature you're adding.
- Include any relevant issue numbers in the PR description.
- Ensure all tests are passing.
- Update documentation as needed.

### Coding Standards
- Follow Java coding conventions
- Use meaningful variable and method names
- Write clear comments and documentation
- Maintain consistent indentation and formatting

### Testing
- Write unit tests for all new features
- Ensure all tests pass before submitting a pull request
- Aim for high test coverage (>80%)

### Documentation
- Update the README.md if you're adding or changing features
- Document any new classes or methods using Javadoc comments
- Update the Architecture Decision Records (ADRs) if you're making significant design changes

### Review Process
1. A project maintainer will review your pull request
2. They may suggest changes or improvements
3. Once approved, your contribution will be merged into the main branch

We appreciate all contributions, whether they're bug fixes, feature additions, or documentation improvements. Thank you for helping to make the Mars Rover Simulation project better!

## 📄 License
This project is licensed under the MIT License. 

### MIT License

Copyright (c) 2024 Winston, Nahum, Samarth Tiku

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## 📞 Contact

If you have any questions, issues, or suggestions regarding the Mars Rover Simulation project, please feel free to contact us:

- Winston - [Email](winstonessibu@gmail.com)
- Nahum - [Email](mailto:nahumguess@gmail.com)
- Samarth Tiku - [Email](mailto:samarth.tiku@example.com)

You can also open an issue on our [GitHub repository](https://github.com/samarthtiku/TEAM1-MARS-ROVER-KATA-WINSTON_NAHUM_SAM-/issues) for bug reports or feature requests.

## 🙏 Acknowledgments

We would like to express our gratitude to:

- The original creators of the Mars Rover kata for providing an engaging problem to solve
- Our instructor, Dr. Konstantin Läufer ([@klaeufer](https://github.com/klaeufer)), for his invaluable guidance, support, and expertise.
- The open-source community for the various tools and libraries that made this project possible

Special thanks to Dr. Läufer for introducing us to advanced software development concepts and practice projects ( introducing us to Mars Rover Problem ).

Thank you for your interest in our Mars Rover Simulation project. We hope you find it useful and educational!    




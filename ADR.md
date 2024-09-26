# 📐 Architecture Decision Record (ADR)

## 🏗️ ADR 1: Layered Architecture

🟦 **Context**
We need a clear structure for our Mars Rover Simulation that separates concerns and allows for easy maintenance and extension.

🟩 **Decision**
Implement a layered architecture with the following layers:
1. Application Layer (`application` package)
2. Model Layer (`model` package)
3. Service Layer (`service` package)
4. Utility Layer (`util` package)

🟨 **Consequences**
- ✅ Clear separation of concerns
- ✅ Easier to maintain and extend
- ✅ Facilitates unit testing
- ❌ Might introduce some overhead for smaller functions

---

## 🤖 ADR 2: Rover Abstraction

🟦 **Context**
We need to support different types of rovers with varying capabilities.

🟩 **Decision**
Create an `AbstractRover` class as a base for all rover types, with `StandardRover` and `JumpingRover` as concrete implementations.

🟨 **Consequences**
- ✅ Allows for easy addition of new rover types
- ✅ Encapsulates common rover behavior
- ✅ Supports polymorphism in rover handling
- ❌ Might lead to some code duplication in concrete classes

---

## 🏭 ADR 3: Factory Pattern for Rover Creation

🟦 **Context**
We need a flexible way to create different types of rovers.

🟩 **Decision**
Implement a `RoverFactory` interface and `RoverFactoryImpl` class to handle rover creation.

🟨 **Consequences**
- ✅ Centralizes rover creation logic
- ✅ Makes it easy to add new rover types
- ✅ Adheres to the Open/Closed principle
- ❌ Adds an extra layer of abstraction

---

## 🎨 ADR 4: Command Pattern for Rover Movement

🟦 **Context**
We need a flexible system to handle different rover movement commands.

🟩 **Decision**
Implement the **Command Pattern** for rover movements (L, R, M).

🟨 **Consequences**
- ✅ Encapsulates each command as an object
- ✅ Allows for easy addition of new commands
- ✅ Facilitates undo/redo functionality if needed
- ❌ Increases the number of classes in the system

---

## 🧪 ADR 5: Test-Driven Development (TDD)

🟦 **Context**
We need to ensure the reliability and correctness of our simulation.

🟩 **Decision**
Adopt Test-Driven Development using JUnit 5 and Mockito for testing.

🟨 **Consequences**
- ✅ Ensures high test coverage
- ✅ Improves design by considering usage before implementation
- ✅ Facilitates refactoring and maintenance
- ❌ May initially slow down development process

---

## 🔄 ADR 6: Continuous Integration with GitHub Actions

🟦 **Context**
We need to ensure code quality and automate the build and test process.

🟩 **Decision**
Implement CI/CD using GitHub Actions.

🟨 **Consequences**
- ✅ Automates build and test processes
- ✅ Catches integration issues early
- ✅ Ensures consistent build environment
- ❌ Requires maintenance of CI/CD configuration

---

## 🖥️ ADR 7: ANSI Escape Codes for Visualization

🟦 **Context**
We need an engaging way to visualize the plateau and rover positions in the console output.

🟩 **Decision**
Implement visualization using ANSI escape codes for colorful and formatted console output.

🟨 **Consequences**
- ✅ Provides a visually appealing representation of the simulation
- ✅ Enhances user experience and understanding of rover movements
- ✅ Allows for easy differentiation between rover types and states
- ❌ May not work in all console environments
- ❌ Requires additional logic to handle color and formatting

---

## 🚫 ADR 8: Exception Handling and Input Validation

🟦 **Context**
We need a robust way to handle errors and invalid inputs to ensure the simulation's reliability.

🟩 **Decision**
Implement a comprehensive exception handling system and thorough input validation throughout the application.

🟨 **Consequences**
- ✅ Improves application stability and user experience
- ✅ Provides clear feedback on error conditions
- ✅ Facilitates debugging and troubleshooting
- ❌ Increases code complexity
- ❌ Requires additional testing scenarios

---

## 🗺️ ADR 9: Immutable Plateau Representation

🟦 **Context**
We need an efficient and thread-safe way to represent the Mars plateau.

🟩 **Decision**
Implement the `Plateau` class as an immutable object with a fixed size and grid representation.

🟨 **Consequences**
- ✅ Ensures thread safety in potential multi-threaded scenarios
- ✅ Simplifies reasoning about the plateau state
- ✅ Prevents accidental modifications to the plateau size
- ❌ May require creating new plateau instances for different scenarios
- ❌ Limits flexibility for dynamic plateau modifications

---

## 🔢 ADR 10: Enum for Orientation Representation

🟦 **Context**
We need a clear and type-safe way to represent and manipulate rover orientations.

🟩 **Decision**
Use an **Enum** to represent the four cardinal directions (N, E, S, W) and include methods for rotation.

🟨 **Consequences**
- ✅ Provides type safety and prevents invalid orientations
- ✅ Encapsulates rotation logic within the Enum
- ✅ Improves code readability and maintainability
- ❌ Limited to predefined set of orientations
- ❌ May require changes if diagonal movements are introduced in the future

---

## 🔄 ADR 11: Iterator Pattern for Command Processing

🟦 **Context**
We need an efficient way to process a sequence of commands for each rover.

🟩 **Decision**
Implement the **Iterator Pattern** to process the sequence of movement commands.

🟨 **Consequences**
- ✅ Provides a standardized way to traverse the command sequence
- ✅ Allows for easy extension to support different command sources (e.g., file, network)
- ✅ Separates the traversal of commands from the underlying representation
- ❌ Adds some complexity to the command processing logic
- ❌ May be overkill for simple command sequences

---

## 🚀 ADR 12: Strategy Pattern for Rover Movement Logic

🟦 **Context**
We might want to support different movement strategies for various rover types (e.g., standard vs. jumping rovers) and allow future extensibility.

🟩 **Decision**
Implement the **Strategy Pattern** to encapsulate movement algorithms for each type of rover:
- `StandardMovementStrategy` for standard rovers.
- `JumpingMovementStrategy` for jumping rovers.

🟨 **Consequences**
- ✅ Allows flexible addition of new movement types.
- ✅ Simplifies the `Rover` class by delegating movement behavior.
- ✅ Follows the Open/Closed Principle, making it easy to add new strategies.
- ❌ Adds an extra layer of abstraction.

---

## 🛠️ ADR 13: Singleton Pattern for Plateau Configuration

🟦 **Context**
We want a single, globally accessible configuration for the plateau size and grid structure to ensure that changes to the plateau are centralized.

🟩 **Decision**
Implement the **Singleton Pattern** for `PlateauConfiguration`, ensuring that only one instance of the plateau configuration exists throughout the application.

🟨 **Consequences**
- ✅ Ensures centralized access to plateau configuration.
- ✅ Prevents inconsistent or conflicting plateau settings.
- ✅ Ensures thread safety and memory optimization for configuration.
- ❌ Can lead to challenges in testing due to global state.

---

## 💾 ADR 14: Memento Pattern for Undo Functionality

🟦 **Context**
There may be scenarios where users want to undo or rollback rover movements to a previous state.

🟩 **Decision**
Implement the **Memento Pattern** to store snapshots of the rover's state at specific points in time, enabling rollback functionality.

🟨 **Consequences**
- ✅ Provides easy rollback to previous rover states.
- ✅ Encapsulates the internal state of the rover without exposing it.
- ✅ Enhances user experience by supporting undo/redo operations.
- ❌ Increases memory usage due to state storage.
- ❌ Requires additional logic to handle state restoration.

---

## 🔍 ADR 15: Observer Pattern for Rover Status Monitoring

🟦 **Context**
We need a way to monitor the status of each rover during simulation, possibly to notify other parts of the system when a rover moves or completes a command sequence.

🟩 **Decision**
Implement the **Observer Pattern** so that interested components (e.g., visualization module, logging system) can be notified of rover state changes.

🟨 **Consequences**
- ✅ Enables real-time monitoring of rover movements.
- ✅ Decouples the rover's movement logic from the observers (like the UI).
- ✅ Allows future components to easily subscribe to rover events.
- ❌ Adds complexity to the system by introducing event-driven interaction.

//ADR TESTING
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TEAM 1 Mars Rover Simulation ADR</title>
    <style>
        body {
            font-family: 'Times New Roman', Tahoma, Geneva, Verdana, sans-serif;
            line-height: 1.6;
            color: #333;
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f0f4f8;
        }
        h1, h2, h3 {
            color: #2c3e50;
        }
        h1 {
            border-bottom: 3px solid #3498db;
            padding-bottom: 10px;
            text-align: center;
        }
        h2 {
            border-bottom: 2px solid #e74c3c;
            padding-bottom: 5px;
            margin-top: 30px;
        }
        .section {
            background-color: #ffffff;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .pros {
            color: #27ae60;
        }
        .cons {
            color: #c0392b;
        }
        .neutral {
            color: #f39c12;
        }
        .collapsible {
            background-color: #3498db;
            color: white;
            cursor: pointer;
            padding: 18px;
            width: 100%;
            border: none;
            text-align: left;
            outline: none;
            font-size: 15px;
            transition: 0.4s;
            border-radius: 8px 8px 0 0;
        }
        .active, .collapsible:hover {
            background-color: #2980b9;
        }
        .content {
            padding: 0 18px;
            display: none;
            overflow: hidden;
            background-color: #f1f1f1;
            border-radius: 0 0 8px 8px;
        }
        .edit-btn {
            background-color: #2ecc71;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h1>TEAM 1 Mars Rover Simulation ADR</h1>

<div class="section">
    <h2>Metadata</h2>
    <table id="metadataTable">
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>Status</td>
            <td contenteditable="true">Proposed</td>
        </tr>
        <tr>
            <td>Dates</td>
            <td contenteditable="true"></td>
        </tr>
        <tr>
            <td>Decision-makers</td>
            <td contenteditable="true">Winston, Nahum, Samarth</td>
        </tr>
        <tr>
            <td>Consulted</td>
            <td contenteditable="true"></td>
        </tr>
        <tr>
            <td>Informed</td>
            <td contenteditable="true"></td>
        </tr>
    </table>
</div>

<div class="section">
    <h2>Context and Problem Statement</h2>
    <p contenteditable="true">
        As Team 1, we are working on the mars-rover-kata project, which involves Test-Driven Development (TDD) using the Thoughtworks mars-rover problem. The problem involves navigating robotic rovers on a rectangular plateau on Mars. The rovers' positions are represented by x and y coordinates and a direction (N, E, S, W). They can be controlled through simple commands: 'L' (turn left), 'R' (turn right), and 'M' (move forward).

        Our task is to implement a solution that can process a series of these commands for multiple rovers and output their final positions. This project serves as a team exercise to practice collaborative software development, software architecture and design concepts, and test-driven development.

        Key aspects of the problem include:
        1. Defining the plateau's dimensions
        2. Initializing rovers with their starting positions and orientations
        3. Processing movement commands for each rover sequentially
        4. Ensuring rovers don't move outside the plateau boundaries
        5. Outputting the final positions of all rovers

        As a team project, we need to make architectural decisions that will allow for efficient development, easy maintenance, and potential future enhancements.
    </p>
</div>

<div class="section">
    <h2>Decision Drivers</h2>
    <ul id="decisionDrivers" contenteditable="true">
        <li>Code maintainability and readability</li>
        <li>Extensibility for future features</li>
        <li>Performance considerations</li>
        <li>Adherence to object-oriented design principles</li>
        <li>Testability of the codebase</li>
    </ul>
</div>

<div class="section">
    <h2>Decisions</h2>
    <div id="optionsDetails">
        <div>
            <button class="collapsible">Decision 1: Use of Enum for Orientation</button>
            <div class="content">
                <p contenteditable="true">We will use an Enum class to represent the cardinal directions (N, E, S, W) for the rover's orientation.</p>
                <ul contenteditable="true">
                    <li class="pros">Good, because it provides type safety and prevents invalid orientations</li>
                    <li class="pros">Good, because it allows for easy implementation of left and right turns</li>
                    <li class="cons">Bad, because it might be less flexible if we need to add diagonal directions in the future</li>
                </ul>
            </div>
        </div>
        <div>
            <button class="collapsible">Decision 2: Immutable Plateau Class</button>
            <div class="content">
                <p contenteditable="true">The Plateau class will be implemented as an immutable class with final fields for width and height.</p>
                <ul contenteditable="true">
                    <li class="pros">Good, because it ensures the plateau size cannot be accidentally changed during runtime</li>
                    <li class="pros">Good, because it simplifies reasoning about the code and prevents certain bugs</li>
                    <li class="cons">Bad, because it might limit flexibility if dynamic resizing of the plateau is needed in the future</li>
                </ul>
            </div>
        </div>
        <div>
            <button class="collapsible">Decision 3: Command Pattern for Rover Movement</button>
            <div class="content">
                <p contenteditable="true">We will use the Command pattern to implement the rover's movement and rotation commands (L, R, M).</p>
                <ul contenteditable="true">
                    <li class="pros">Good, because it allows for easy addition of new commands in the future</li>
                    <li class="pros">Good, because it separates the command logic from the Rover class, adhering to the Single Responsibility Principle</li>
                    <li class="cons">Bad, because it adds some complexity to the codebase</li>
                </ul>
            </div>
        </div>
        <div>
            <button class="collapsible">Decision 4: Use of Exceptions for Error Handling</button>
            <div class="content">
                <p contenteditable="true">We will use custom exceptions (IllegalArgumentException, IllegalStateException) for handling error scenarios such as invalid input or out-of-bounds movement.</p>
                <ul contenteditable="true">
                    <li class="pros">Good, because it provides clear and specific error messages</li>
                    <li class="pros">Good, because it allows for centralized error handling in the main program</li>
                    <li class="cons">Bad, because excessive use of exceptions might impact performance if errors are frequent</li>
                </ul>
            </div>
        </div>
        <div>
            <button class="collapsible">Decision 5: Use of Strategy Pattern for Movement Calculation</button>
            <div class="content">
                <p contenteditable="true">We will implement a Strategy pattern for calculating new positions based on the current orientation.</p>
                <ul contenteditable="true">
                    <li class="pros">Good, because it allows for easy modification of movement logic if requirements change</li>
                    <li class="pros">Good, because it separates movement calculation from the Rover class, improving maintainability</li>
                    <li class="cons">Bad, because it might be overkill for the current simple movement logic</li>
                </ul>
            </div>
        </div>
        <div>
            <button class="collapsible">Decision 6: Implementation of a RoverUtilities Class</button>
            <div class="content">
                <p contenteditable="true">We will create a RoverUtilities class to handle common operations and calculations, such as distance traveled.</p>
                <ul contenteditable="true">
                    <li class="pros">Good, because it centralizes common utility functions</li>
                    <li class="pros">Good, because it can be easily extended to include more utility functions in the future</li>
                    <li class="cons">Bad, because it might lead to a "god class" if not carefully managed</li>
                </ul>
            </div>
        </div>
        <div>
            <button class="collapsible">Decision 7: Use of ANSI Color Codes for Console Output</button>
            <div class="content">
                <p contenteditable="true">We will use ANSI color codes to enhance the console output of the simulation.</p>
                <ul contenteditable="true">
                    <li class="pros">Good, because it improves the user experience by making the output more readable</li>
                    <li class="pros">Good, because it allows for visual differentiation of different types of information</li>
                    <li class="cons">Bad, because it might not work on all console environments</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <h2>More Information</h2>
    <p contenteditable="true">The implementation details can be found in the provided Java files. Further decisions may be needed as the project evolves, particularly regarding the handling of multiple rovers, obstacle detection, and more complex command sequences.</p>
</div>

<script>
    // Set up collapsible sections
    var coll = document.getElementsByClassName('collapsible');
    for (var i = 0; i < coll.length; i++) {
        coll[i].addEventListener('click', function() {
            this.classList.toggle('active');
            var content = this.nextElementSibling;
            if (content.style.display === 'block') {
                content.style.display = 'none';
            } else {
                content.style.display = 'block';
            }
        });
    }
</script>
</body>
</html>



# TEAM1-MARS-ROVER-KATA-WINSTON_NAHUM_SAM-
# Time Log - September 8, 2024 6:38 pm
# Time Log - September 9, 2024 3:48 pm(Notes for Tested Input and Expected Output )
# Time Log - September 10, 2024 9 am(Added Nahum's approach as well as some starter code)
# Time Log - September 12, 2024 6 pm(Added github actions to the project)
# Time Log - September 14, 2024 (Created Rover class : added processCommands and getPosition methods.. & fixed some bug )
# Time Log - September 16, 2024 10 pm(Filled in methods in rover class)
# Time Log - September 16, 2024 11pm (Notes on breaking down of our MARS ROVER project structure & Calculating the total distance traveled by a rover )
# Time Log - September 17, 2024 9:24 am ( Adding simulation of Mars Rover( will update it later  )) 
# Time Log - September 22, 2024  All Day
# Time Log - September 23, 2024  5am - 8am
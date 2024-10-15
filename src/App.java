import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    float darkGreenRectX = 375; 
    float darkGreenRectY = 50;
    float darkGreenRectSize = 50; // Floats create the first rectangle
    float darkGreenOffsetX, darkGreenOffsetY; // Offset for first rectangle
    boolean darkGreenDragging = false; // First rectangle dragging is false

    float blueRectX = 450;
    float blueRectY = 550;
    float blueRectSize = 50; // Creating the second rectangle
    float blueOffsetX, blueOffsetY; // Offset for second rectangle
    boolean blueDragging = false; // Second rectangle dragging is false

    float purpleRectX = 500;
    float purpleRectY = 110;
    float purpleRectSize = 25;
    float purpleOffsetX, purpleOffsetY;
    boolean purpleDragging = false;

    float redRectX = 325;
    float redRectY = 540;
    float redRectSize = 25;
    float redOffsetX, redOffsetY;
    boolean redDragging = false;

    float yellowRectX = 450;
    float yellowRectY = 450;
    float yellowRectSize = 25;
    float yellowOffsetX, yellowOffsetY;
    boolean yellowDragging = false;

    float darkGreyRectX = 460;
    float darkGreyRectY = 400;
    float darkGreyRectSize = 25;
    float darkGreyOffsetX, darkGreyOffsetY;
    boolean darkGreyDragging = false;

    float orangeRectX = 535;
    float orangeRectY = 160;
    float orangeRectSize = 15;
    float orangeOffsetX, orangeOffsetY;
    boolean orangeDragging = false;

    float pinkRectX = 510;
    float pinkRectY = 375;
    float pinkRectSize = 15;
    float pinkOffsetX, pinkOffsetY;
    boolean pinkDragging = false;

    float darkGreenTargetX = 450;
    float darkGreenTargetY = 90;
    float darkGreenTargetSize = 50;

    float blueTargetX = 350;
    float blueTargetY = 90;
    float blueTargetSize = 50;

    float purpleTargetX = 340;
    float purpleTargetY = 190;
    float purpleTargetSize = 25;
    
    float redTargetX = 375;
    float redTargetY = 240;
    float redTargetSize = 25;

    float yellowTargetX = 495;
    float yellowTargetY = 180;
    float yellowTargetSize = 50;

    float darkGreyTargetX = 470;
    float darkGreyTargetY = 215;
    float darkGreyTargetSize = 50;

    float orangeTargetX = 445;
    float orangeTargetY = 257;
    float orangeTargetSize = 25;
    
    float pinkTargetX = 420;
    float pinkTargetY = 257;
    float pinkTargetSize = 25;

    boolean darkGreenInTarget = false;
    boolean blueInTarget = false;
    boolean purpleInTarget = false;
    boolean redInTarget = false;
    boolean yellowInTarget = false;
    boolean darkGreyInTarget = false;
    boolean orangeInTarget = false;
    boolean pinkInTarget = false;

    int currentScreen = 0;
    int screen0TargetX = 250, screen0TargetY = 250;
    int screen0TargetSize = 100;

    // Timer variables
    int timeLimit = 90;  // Time limit in seconds
    int startTime;  // Store the time when the puzzle starts
    boolean isTimeUp = false;  // Flag to check if time is up

    public void setup() {
        background(80080);
        strokeWeight(20);
        startTime = millis();  // Capture the starting time when the puzzle begins

    }

    public void settings() {
        size(600, 600);
    }

    public void draw() {

        if (isTimeUp) {
            drawTimeUpScreen();  // If time runs out, show the time-up screen
        } else if (currentScreen == 0) {
            drawStartScreen();
        } else if (currentScreen == 1) {
            drawPuzzle();
            checkTimer();
        } else if (isTimeUp) {
            drawTimeUpScreen();  // If time runs out, show the time-up screen
    }
}

         
        public void drawStartScreen() {
            background(145);
            
            stroke(0);
            strokeWeight(10);
            fill(225);
            ellipse(300, 300, 100, 100);

            stroke(0);
            strokeWeight(10);
            fill(225);
            triangle(283, 320, 283, 280, 320, 300);

            stroke(0);
            textSize(30);
            fill(00, 00, 00);
            text("Press play to start the puzzle", 125, 200);
            
        }
         
        public void drawPuzzle() {
        background(80080); // Clear background every frame

        int remainingTime = timeLimit - (millis() - startTime) / 1000;
        stroke(0);
        textSize(25);
        fill(0);
        text("Time Left: " + remainingTime + " seconds", 20, 50);

        stroke(0);
        textSize(15);
        fill(00, 00, 00);
        text("Complete the puzzle as shown on the left.", 315, 25);

        stroke(0);
        textSize(15);
        fill(00, 00, 00);
        text("If a shape turns green, it's in the right place.", 315, 40);

        // Line divider
        stroke(0);
        strokeWeight(20);
        line(300, 600, 300, 0);

        // Static rectangles on the left
        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(190, 100, 50, 50);

        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(50, 100, 50, 50);

        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(40, 200, 25, 25);

        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(225, 200, 25, 25);

        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(75, 240, 25, 25);

        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(175, 240, 25, 25);

        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(115, 260, 15, 15);

        stroke(0);
        strokeWeight(10);
        fill(0, 255, 0);
        rect(145, 260, 15, 15);

        // First draggable rectangle
        if (!darkGreenDragging) {  // Only draw the rectangle if it's not being dragged
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);
            rect(darkGreenRectX, darkGreenRectY, darkGreenRectSize, darkGreenRectSize);
        } else {
            // Draw the new rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);  // You can change the color or appearance here
            rect(mouseX + darkGreenOffsetX, mouseY + darkGreenOffsetY, darkGreenRectSize, darkGreenRectSize);
        }

        // Second draggable rectangle
        if (!blueDragging) {  // Only draw the rectangle if it's not being dragged
            stroke(0);
            strokeWeight(10);
            fill(5, 5, 150);
            rect(blueRectX, blueRectY, blueRectSize, blueRectSize);
        } else {
            // Draw the new rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(5, 5, 150);  // You can change the color or appearance here
            rect(mouseX + blueOffsetX, mouseY + blueOffsetY, blueRectSize, blueRectSize);
        }

        if (!purpleDragging) {  // Only draw the rectangle if it's not being dragged
        stroke(0);
        strokeWeight(10);
        fill(100, 0, 100);
        rect(purpleRectX, purpleRectY, purpleRectSize, purpleRectSize);
    } else {
        // Draw the new rectangle at the mouse location while dragging
        stroke(0);
        strokeWeight(10);
        fill(100, 0, 100);  // You can change the color or appearance here
        rect(mouseX + purpleOffsetX, mouseY + purpleOffsetY, purpleRectSize, purpleRectSize);
    }

    if (!redDragging) {  // Only draw the rectangle if it's not being dragged
        stroke(0);
        strokeWeight(10);
        fill(100, 0, 0);
        rect(redRectX, redRectY, redRectSize, redRectSize);
    } else {
        stroke(0);
        strokeWeight(10);
        fill(100, 0, 0);  
        rect(mouseX + redOffsetX, mouseY + redOffsetY, redRectSize, redRectSize);
    }

    if (!yellowDragging) {  // Only draw the rectangle if it's not being dragged
        stroke(0);
        strokeWeight(10);
        fill(255, 255, 0);
        rect(yellowRectX, yellowRectY, yellowRectSize, yellowRectSize);
    } else {
        stroke(0);
        strokeWeight(10);
        fill(255, 255, 0);  
        rect(mouseX + yellowOffsetX, mouseY + yellowOffsetY, yellowRectSize, yellowRectSize);
    }

    if (!darkGreyDragging) { 
        stroke(0);
        strokeWeight(10);
        fill(20);
        rect(darkGreyRectX, darkGreyRectY, darkGreyRectSize, darkGreyRectSize);
    } else {
        stroke(0);
        strokeWeight(10);
        fill(20);  
        rect(mouseX + darkGreyOffsetX, mouseY + darkGreyOffsetY, darkGreyRectSize, darkGreyRectSize);
    }

    if (!orangeDragging) { 
        stroke(0);
        strokeWeight(10);
        fill(204, 85, 0);
        rect(orangeRectX, orangeRectY, orangeRectSize, orangeRectSize);
    } else {
        stroke(0);
        strokeWeight(10);
        fill(204, 85, 0);  
        rect(mouseX + orangeOffsetX, mouseY + orangeOffsetY, orangeRectSize, orangeRectSize);
    }

    if (!pinkDragging) { 
        stroke(0);
        strokeWeight(10);
        fill(255, 102, 204);
        rect(pinkRectX, pinkRectY, pinkRectSize, pinkRectSize);
    } else {
        stroke(0);
        strokeWeight(10);
        fill(255, 102, 204);  
        rect(mouseX + pinkOffsetX, mouseY + pinkOffsetY, pinkRectSize, pinkRectSize);
    }
     

        if (!darkGreenDragging) {
            if (darkGreenRectX > darkGreenTargetX && darkGreenRectX < darkGreenTargetX + darkGreenTargetSize &&
                darkGreenRectY > darkGreenTargetY && darkGreenRectY < darkGreenTargetY + darkGreenTargetSize) {
                // If the rectangle is inside the target space, make it green

                fill(0, 255, 0);
                darkGreenInTarget = true;
            } else {
                // Otherwise, keep its normal color
                fill(0, 50, 5);
                darkGreenInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(darkGreenRectX, darkGreenRectY, darkGreenRectSize, darkGreenRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);
            rect(mouseX + darkGreenOffsetX, mouseY + darkGreenOffsetY, darkGreenRectSize, darkGreenRectSize);
        }

        if (!blueDragging) {
            if (blueRectX > blueTargetX && blueRectX < blueTargetX + blueTargetSize &&
                blueRectY > blueTargetY && blueRectY < blueTargetY + blueTargetSize) {
                // If the rectangle is inside the target space, make it green

                fill(0, 255, 0);
                blueInTarget = true;
            } else {
                // Otherwise, keep its normal color
                fill(5, 5, 150);
                blueInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(blueRectX, blueRectY, blueRectSize, blueRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(5, 5, 150);
            rect(mouseX + blueOffsetX, mouseY + blueOffsetY, blueRectSize, blueRectSize);
        }

        if (!purpleDragging) {
            if (purpleRectX > purpleTargetX && purpleRectX < purpleTargetX + purpleTargetSize &&
                purpleRectY > purpleTargetY && purpleRectY < purpleTargetY + purpleTargetSize) {
                // If the rectangle is inside the target space, make it green

                fill(0, 255, 0);
                purpleInTarget = true;
            } else {
                // Otherwise, keep its normal color
                fill(100, 0, 100);
                purpleInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(purpleRectX, purpleRectY, purpleRectSize, purpleRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(100, 0, 100);
            rect(mouseX + purpleOffsetX, mouseY + purpleOffsetY, purpleRectSize, purpleRectSize);
        }

        if (!redDragging) {
            if (redRectX > redTargetX && redRectX < redTargetX + redTargetSize &&
                redRectY > redTargetY && redRectY < redTargetY + redTargetSize) {
                // If the rectangle is inside the target space, make it green

                fill(0, 255, 0);
                redInTarget = true;
            } else {
                // Otherwise, keep its normal color
                fill(100, 0, 0);
                redInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(redRectX, redRectY, redRectSize, redRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(100, 0, 0);
            rect(mouseX + redOffsetX, mouseY + redOffsetY, redRectSize, redRectSize);
        }

        if (!yellowDragging) {
            if (yellowRectX > yellowTargetX && yellowRectX < yellowTargetX + yellowTargetSize &&
                yellowRectY > yellowTargetY && yellowRectY < yellowTargetY + yellowTargetSize) {
                // If the rectangle is inside the target space, make it green

                fill(0, 255, 0);
                yellowInTarget = true;
            } else {
                // Otherwise, keep its normal color
                fill(255, 255, 0);
                yellowInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(yellowRectX, yellowRectY, yellowRectSize, yellowRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(255, 255, 0);
            rect(mouseX + yellowOffsetX, mouseY + yellowOffsetY, yellowRectSize, yellowRectSize);
        }

        if (!darkGreyDragging) {
            if (darkGreyRectX > darkGreyTargetX && darkGreyRectX < darkGreyTargetX + darkGreyTargetSize &&
                darkGreyRectY > darkGreyTargetY && darkGreyRectY < darkGreyTargetY + darkGreyTargetSize) {

                fill(0, 255, 0);
                darkGreyInTarget = true;
            } else {
                fill(20);
                darkGreyInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(darkGreyRectX, darkGreyRectY, darkGreyRectSize, darkGreyRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(20);
            rect(mouseX + darkGreyOffsetX, mouseY + darkGreyOffsetY, darkGreyRectSize, darkGreyRectSize);
        }

        if (!orangeDragging) {
            if (orangeRectX > orangeTargetX && orangeRectX < orangeTargetX + orangeTargetSize &&
                orangeRectY > orangeTargetY && orangeRectY < orangeTargetY + orangeTargetSize) {

                fill(0, 255, 0);
                orangeInTarget = true;
            } else {
                fill(204, 85, 0);
                orangeInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(orangeRectX, orangeRectY, orangeRectSize, orangeRectSize);
        } else {
            stroke(0);
            strokeWeight(10);
            fill(204, 85, 0);
            rect(mouseX + orangeOffsetX, mouseY + orangeOffsetY, orangeRectSize, orangeRectSize);
        }

        if (!pinkDragging) {
            if (pinkRectX > pinkTargetX && pinkRectX < pinkTargetX + pinkTargetSize &&
                pinkRectY > pinkTargetY && pinkRectY < pinkTargetY + pinkTargetSize) {

                fill(0, 255, 0);
                pinkInTarget = true;
            } else {
                fill(255, 102, 204);
                pinkInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(pinkRectX, pinkRectY, pinkRectSize, pinkRectSize);
        } else {
            stroke(0);
            strokeWeight(10);
            fill(255, 102, 204);
            rect(mouseX + pinkOffsetX, mouseY + pinkOffsetY, pinkRectSize, pinkRectSize);
        }

        if (darkGreenInTarget == true && blueInTarget == true && purpleInTarget == true && redInTarget == true && yellowInTarget == true && darkGreyInTarget == true && orangeInTarget == true && pinkInTarget == true) {
            drawCompleteScreen();
    }
    }

    public void drawTimeUpScreen() {
        background(80080);  // Red background for "Time's Up"
        stroke(0);
        textSize(40);
        fill(255, 0, 0);
        text("Game Over", 200, 300);
    }

    public void checkTimer() {
        int elapsedTime = (millis() - startTime) / 1000;  // Calculate the elapsed time in seconds
        if (elapsedTime >= timeLimit) {
            isTimeUp = true;  // Time's up, stop the puzzle
        }
    }

    public void drawCompleteScreen() {
        background(80080);
        stroke(0);
        textSize(40);
        fill(0, 255, 0);
        text("Puzzle Complete!", 150, 300);
    }


    public void mousePressed() {
        // Check if the first rectangle is clicked
        if (mouseX > darkGreenRectX && mouseX < darkGreenRectX + darkGreenRectSize &&
            mouseY > darkGreenRectY && mouseY < darkGreenRectY + darkGreenRectSize) {
            darkGreenDragging = true; // Start dragging the first rectangle
            darkGreenOffsetX = darkGreenRectX - mouseX; // Calculate offset for the first rectangle
            darkGreenOffsetY = darkGreenRectY - mouseY;
        }

        // Check if the second rectangle is clicked
        if (mouseX > blueRectX && mouseX < blueRectX + blueRectSize &&
            mouseY > blueRectY && mouseY < blueRectY + blueRectSize) {
            blueDragging = true; // Start dragging the second rectangle
            blueOffsetX = blueRectX - mouseX; // Calculate offset for the second rectangle
            blueOffsetY = blueRectY - mouseY; }

        if (mouseX > purpleRectX && mouseX < purpleRectX + purpleRectSize &&
            mouseY > purpleRectY && mouseY < purpleRectY + purpleRectSize) {
            purpleDragging = true; 
            purpleOffsetX = purpleRectX - mouseX; 
            purpleOffsetY = purpleRectY - mouseY; }

        if (mouseX > redRectX && mouseX < redRectX + redRectSize &&
            mouseY > redRectY && mouseY < redRectY + redRectSize) {
            redDragging = true; 
            redOffsetX = redRectX - mouseX; 
            redOffsetY = redRectY - mouseY; }

        if (mouseX > yellowRectX && mouseX < yellowRectX + yellowRectSize &&
            mouseY > yellowRectY && mouseY < yellowRectY + yellowRectSize) {
            yellowDragging = true; 
            yellowOffsetX = yellowRectX - mouseX; 
            yellowOffsetY = yellowRectY - mouseY; }

        if (mouseX > darkGreyRectX && mouseX < darkGreyRectX + darkGreyRectSize &&
            mouseY > darkGreyRectY && mouseY < darkGreyRectY + darkGreyRectSize) {
            darkGreyDragging = true; 
            darkGreyOffsetX = darkGreyRectX - mouseX; 
            darkGreyOffsetY = darkGreyRectY - mouseY; }

        if (mouseX > orangeRectX && mouseX < orangeRectX + orangeRectSize &&
            mouseY > orangeRectY && mouseY < orangeRectY + orangeRectSize) {
            orangeDragging = true; 
            orangeOffsetX = orangeRectX - mouseX; 
            orangeOffsetY = orangeRectY - mouseY; }

        if (mouseX > pinkRectX && mouseX < pinkRectX + pinkRectSize &&
            mouseY > pinkRectY && mouseY < pinkRectY + pinkRectSize) {
            pinkDragging = true; 
            pinkOffsetX = pinkRectX - mouseX; 
            pinkOffsetY = pinkRectY - mouseY; }

            //If target area is pressed, screen changes
        if (mouseX > screen0TargetX && mouseX < screen0TargetX + screen0TargetSize && mouseY > screen0TargetY && mouseY < screen0TargetY + screen0TargetSize) {
            currentScreen = 1;
        }
        }

       
    public void mouseReleased() {
        if (darkGreenDragging) {
            // Update the position of the first rectangle to where the mouse is released
            darkGreenRectX = mouseX + darkGreenOffsetX;
            darkGreenRectY = mouseY + darkGreenOffsetY;
            darkGreenDragging = false;  // Stop dragging the first rectangle
    }

        if (blueDragging) {
            // Update the position of the second rectangle to where the mouse is released
            blueRectX = mouseX + blueOffsetX;
            blueRectY = mouseY + blueOffsetY;
            blueDragging = false;  // Stop dragging the second
        }

        if (purpleDragging) {
            purpleRectX = mouseX + purpleOffsetX;
            purpleRectY = mouseY + purpleOffsetY;
            purpleDragging = false;  
        }

        if (redDragging) {
            redRectX = mouseX + redOffsetX;
            redRectY = mouseY + redOffsetY;
            redDragging = false;  
        }

        if (yellowDragging) {
            yellowRectX = mouseX + yellowOffsetX;
            yellowRectY = mouseY + yellowOffsetY;
            yellowDragging = false;  
        }

        if (darkGreyDragging) {
            darkGreyRectX = mouseX + darkGreyOffsetX;
            darkGreyRectY = mouseY + darkGreyOffsetY;
            darkGreyDragging = false;  
        }

        if (orangeDragging) {
            orangeRectX = mouseX + orangeOffsetX;
            orangeRectY = mouseY + orangeOffsetY;
            orangeDragging = false;  
        }

        if (pinkDragging) {
            pinkRectX = mouseX + pinkOffsetX;
            pinkRectY = mouseY + pinkOffsetY;
            pinkDragging = false;  
        }

}
}


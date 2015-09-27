//////// Exercise x2:  modularize exercise x1, and add dog to chase hero.
//////// Rebeca  (CST 112; today's date?)

//////// Please change these to your name and today's date.
String author=  "Rebeca";
String title=  "Dog chases Vienna ";
String help=  " Click to relocate hero \n 'q' to quit; 'r' to reset. ";
int count = 0;

//// GLOBALS:  coordinates, speed, etc.
float x, y;                         //position                                             // Position of creature.
float dx, dy;                       // speed                                                // Speed.
float horizon;
float circleX = 0;
float circleY = 0;
float circleW = 40;
float circleH = 50;
float circleFill = 0;
float cr=255, cg=200, cb=0;
float backgroundColor = 255;
float change = .5;
float dogX, dogY;

//// SETUP:  window size, initialization (start in middle of screen).
void setup() {
  size( 640,480);
  horizon=  height/4;
  x=  width/2;
  y=  height/2;
  frameRate(30);
  dx=  3;
  dy=  2;
}

//// NEXT FRAME:  scene, action, show.
void draw() {
  scene();
  hero();
  dog();
  messages();

}

//// SCENE:  sky, sun, tree, house, etc.
void scene() {  
 // sky                                                          
 background( 100,150,200 );                    
                                                                 
  //Sun
  
  fill( cr, cg, cb );           
  noStroke();
  ellipse(circleX, circleY, circleW+10, circleH-10);
  circleX = circleX + change + 1 ;
  circleY = circleY + change;
  circleW = circleW+ change;
  circleH = circleH + change;
  circleFill = circleFill + change;
 
 
 // Grass
  fill( 100,200,100 );
  rect( 0,horizon+10, width,height*3/4 );      
  
  stroke(0);                                     // tree 
  fill(66,139,18);    
  triangle(30, 120, 58, 70, 86, 120);
  triangle(30, 75, 58, 20, 86, 75);              
  fill(98,86,56);
  rect(55,120,10,20);                          // trunk
  
  //House
  
  stroke(0);
  fill(167,161,98);                   
  rect(50,300,150,125);                              // house
  fill(77,66,67);
  triangle(50, 300, 125, 175, 200, 300);             // roof
  fill(160,10,20); 
  rect(90,190,20,60);                                // cheminee
  fill(255);
  rect(65,310,30,50);                               //  windows
  rect(155,310,30,50);                              //  windows
  fill(75,71,57);
  rect(105,370,30,55);                              //  door
  fill(0);
 
                                     
}

void messages() {
  fill(0);
 text( title, width/3, 20 );
 text( help, width*2/3, 30 );
 text( author, 10,height-20 );
}

//// ACTION:  move (x,y) coordinates of hero & dog; show them.

void hero() {
text( "Vienna", 200, 200 );
  
 fill(69,185,142);                    //body's color
 rect( x,y-5, 40,80 );               // body
 fill(250,210,172);                  //head color
 ellipse(x+18,y-50,50,70);           //head
 fill(250,210,172);                  //neck color
 rect(x+15,y-15,10,10);              //neck
 
 float shoulder = y-30; strokeWeight(5);                 
 stroke(250,210,175);                  // arm color
 line(x, shoulder+25, x-25, y+10);     //  Left shoulder 
 line(x+40, shoulder+25, x+60, y+10);  //  Rigth shoulder
 stroke(0);
 strokeWeight(1);
 fill(255);                          // eye color
 ellipse(x+5,y-60,9,5);              // eye sclera
 ellipse(x+25,y-60,9,5);             // eye sclera
 fill(88,144,198,198);               // pupil color
 ellipse(x+5,y-60,2,5);              // pupil
 ellipse(x+25,y-60,2,5);             // pupil
 fill(0);                            // nose's color
 ellipse(x+15,y-45,3,6);             // nose
 fill(255,0,0);                      // lip's color
 ellipse(x+15,y-30,12,3);            // upper lip
 ellipse(x+16,y-27,9,3);             // lower lip
 fill(149,81,35);                    // shoes' color 
 ellipse(x+5, y+75,25,7);            // left shoe
 ellipse(x+35, y+75,25,7);           // right shoe
 
  
 
 // Vienna moves around
  x = x + dx;                            
  if (x > width-40) {
    
  dx= dx *-1 ; 
  }
  if (x < 2) { 
  dx= dx* -1;
}

  y = y + dy;
  
 if ((y > height-75) || (y < +100)) {
  
    dy= dy *-1;
  }
}

void dog() {
  
  dogX=  dogX - (dogX-x)/30;
  dogY=  dogY - (dogY-y)/40;
  
 
  strokeWeight(1);
  stroke(0);
  fill( 185,130,56);                         // body's color 
  ellipse(dogX,dogY, 60,30 );                // dog's body
  fill(95,62,21);                            // tail color
  ellipse(dogX-30,dogY-5,5,15);              // tail
  fill( 185,130,56);                         // head color
  ellipse(dogX+30,dogY-10,20,30);            // head
  fill(95,62,21);                            // ear color
  ellipse(dogX+20,dogY-10,10,20);            // ear
  fill(0);                                   // eye color
  ellipse(dogX+28,dogY-13,5,3);              // eye
  fill(0);                                   // nose color
  ellipse(dogX+40,dogY-10,5,5);              // nose
  fill(247,195,226);                         // mouth's color
  ellipse(dogX+40,dogY,7,5);                 // mouth

 // need help flipping the dog ***
 
 if (count/30 % 2 == 0) {
  strokeWeight(5);
  stroke(95,62,21); 
  line(dogX+10,dogY+5,dogX+10,dogY+20);
  line(dogX-10,dogY+5,dogX-10,dogY+20);
 } else{
  line(dogX,dogY-5,dogX,dogY-20+20);
  line(dogX,dogY-5,dogX+10,dogY-20);
  }
 strokeWeight(1);
  
 text( "WOOF, WOOF!d!!", 150, 150 );
}

//////// HANDLERS:  mouse clicks, keys
void mousePressed() {
  x=  mouseX+10;                             // Set (x,y) to mouse
  y=  mouseY+10;
  //
  dx=  random( -5, +5 );                  // random speed.
  dy=  random( -3, +3 );
}

void keyPressed() {
  if (key == 'q') {
    exit();                           // press 'q' key to QUIT.
  }
  /* INSERT YOUR CODE HERE! */
}
   
   

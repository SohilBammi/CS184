// CS184 Simple OpenGL Example
#include <vector>
#include <iostream>
#include <fstream>
#include <cmath>

#ifdef _WIN32
#include <windows.h>
#else
#include <sys/time.h>
#endif

#ifdef OSX
#include <GLUT/glut.h>
#include <OpenGL/glu.h>
#else
#include <GL/glut.h>
#include <GL/glu.h>
#endif

#include <time.h>
#include <math.h>

#ifdef _WIN32
static DWORD lastTime;
#else
static struct timeval lastTime;
#endif

#define PI 3.14159265

using namespace std;

//****************************************************
// Some Classes
//****************************************************
class Viewport {
  public:
    int w, h; // width and height
};


//****************************************************
// Global Variables
//****************************************************
Viewport    viewport;

//****************************************************
// reshape viewport if the window is resized
//****************************************************
void myReshape(int w, int h) {
  viewport.w = w;
  viewport.h = h;

  glViewport(0,0,viewport.w,viewport.h);// sets the rectangle that will be the window
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();                // loading the identity matrix for the screen

  //----------- setting the projection -------------------------
  // glOrtho sets left, right, bottom, top, zNear, zFar of the chord system


  // glOrtho(-1, 1 + (w-400)/200.0 , -1 -(h-400)/200.0, 1, 1, -1); // resize type = add
  // glOrtho(-w/400.0, w/400.0, -h/400.0, h/400.0, 1, -1); // resize type = center

  glOrtho(-1, 1, -1, 1, 1, -1);    // resize type = stretch

  //------------------------------------------------------------
}


//****************************************************
// sets the window up
//****************************************************
void initScene(){
  glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Clear to black, fully transparent

  myReshape(viewport.w,viewport.h);
}

void drawStars() {
	for (float i = -1.00f; i <= 1.1f; i = i + 0.10f) {
		for (float j = -1.00f; j <= 1.1f; j = j + 0.10f) {
			glColor3f(1.0f, 1.0f, 1.0f);
			glBegin(GL_POLYGON);
			glVertex3f(i-0.005f, j-0.005f, 0.00f);
			glVertex3f(i+0.005f, j-0.005f, 0.00f);
			glVertex3f(i+0.005f, j+0.005f, 0.00f);
			glVertex3f(i-0.005f, j+0.005f, 0.00f);
			glEnd();
		}
	}
}

//***************************************************
// function that does the actual drawing
//***************************************************

void myDisplay() {

  //----------------------- ----------------------- -----------------------
  // This is a quick hack to add a little bit of animation.
  const  float spd = 0.0075f;
  const  float beg = 0.1f;
  const  float end = 1.5f;
  static float tip = -1.1f;
  static float triangle_base = -1.22f;
  static float rectangle1_top = -1.22f;
  static float rectangle1_bottom = -1.42f;
  static float wing_tip = -1.35f;
  static float wing_bottom = -1.5f;
  static float wing_side = -1.4f;

  tip += spd;
  triangle_base += spd;
  rectangle1_top += spd;
  rectangle1_bottom += spd;
  wing_tip += spd;
  wing_bottom += spd;
  wing_side += spd;
  if (tip > end) {
	  tip = -1.1f;
	  triangle_base = -1.22f;
	  rectangle1_top = -1.22f;
	  rectangle1_bottom = -1.42f;
	  wing_tip = -1.35f;
	  wing_bottom = -1.5f;
	  wing_side = -1.4f;
  }
  //----------------------- ----------------------- -----------------------


  glClear(GL_COLOR_BUFFER_BIT);                // clear the color buffer (sets everything to black)

  glMatrixMode(GL_MODELVIEW);                  // indicate we are specifying camera transformations
  glLoadIdentity();                            // make sure transformation is "zero'd"

  //----------------------- code to draw objects --------------------------
  // Rectangle Code
  //glColor3f(red component, green component, blue component);
  drawStars();
  glColor3f(1.0f, 0.0f, 0.0f);
  glBegin(GL_POLYGON);                         // draw rectangle 
  //glVertex3f(x val, y val, z val (won't change the point because of the projection type));
  glVertex3f(0.00f, tip, 0.00f);
  glVertex3f(0.1f, triangle_base, 0.00f);
  glVertex3f(-0.1f, triangle_base, 0.00f);
  glEnd();

  glColor3f(0.75f, 0.75f, 0.75f);
  glBegin(GL_POLYGON);
  glVertex3f(-0.06f, rectangle1_top, 0.00f);
  glVertex3f(0.06f, rectangle1_top, 0.00f);
  glVertex3f(0.06f, rectangle1_bottom, 0.00f);
  glVertex3f(-0.06f, rectangle1_bottom, 0.00f);
  glEnd();

  glColor3f(1.00f, 0.75f, 0.00f);
  glBegin(GL_POLYGON);
  glVertex3f(-0.06f, wing_tip, 0.00f);
  glVertex3f(-0.06f, wing_bottom, 0.00f);
  glVertex3f(-0.10f, wing_bottom, 0.00f);
  glVertex3f(-0.10f, wing_side, 0.00f);
  glEnd();

  glBegin(GL_POLYGON);
  glVertex3f(0.06f, wing_tip, 0.00f);
  glVertex3f(0.06f, wing_bottom, 0.00f);
  glVertex3f(0.10f, wing_bottom, 0.00f);
  glVertex3f(0.10f, wing_side, 0.00f);
  glEnd();
 
  //-----------------------------------------------------------------------

  glFlush();
  glutSwapBuffers();                           // swap buffers (we earlier set double buffer)
}

//****************************************************
// called by glut when there are no messages to handle
//****************************************************
void myFrameMove() {
  //nothing here for now
#ifdef _WIN32
  Sleep(10);                                   //give ~10ms back to OS (so as not to waste the CPU)
#endif
  glutPostRedisplay(); // forces glut to call the display function (myDisplay())
}


//****************************************************
// the usual stuff, nothing exciting here
//****************************************************
int main(int argc, char *argv[]) {
  //This initializes glut
  glutInit(&argc, argv);

  //This tells glut to use a double-buffered window with red, green, and blue channels 
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);

  // Initalize theviewport size
  viewport.w = 400;
  viewport.h = 400;

  //The size and position of the window
  glutInitWindowSize(viewport.w, viewport.h);
  glutInitWindowPosition(0, 0);
  glutCreateWindow("Space Exploration");

  initScene();                                 // quick function to set up scene

  glutDisplayFunc(myDisplay);                  // function to run when its time to draw something
  glutReshapeFunc(myReshape);                  // function to run when the window gets resized
  glutIdleFunc(myFrameMove);                   // function to run when not handling any other task
  glutMainLoop();                              // infinite loop that will keep drawing and resizing and whatever else

  return 0;
}









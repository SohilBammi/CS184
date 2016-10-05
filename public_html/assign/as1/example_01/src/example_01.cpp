#include <vector>
#include <iostream>
#include <fstream>
#include <cmath>

//include header file for glfw library so that we can use OpenGL
#include <GLFW/glfw3.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

#ifdef _WIN32
static DWORD lastTime;
#else
static struct timeval lastTime;
#endif

#define PI 3.14159265 // Should be used from mathlib

using namespace std;

//****************************************************
// Global Variables
//****************************************************
GLfloat translation[3] = {0.0f, 0.0f, 0.0f};
bool auto_strech = false;
int Width_global = 400;
int Height_global = 400;
GLfloat kaRGB[3] = {0.0f, 0.0f, 0.0f};
GLfloat kdRGB[3] = {0.0f, 0.0f, 0.0f};
GLfloat ksRGB[3] = {0.0f, 0.0f, 0.0f};
bool specSet = false;
GLfloat spuPU = 0;
GLfloat spvPV = 0;
GLfloat spP = 0;
int numPl = 0;
GLfloat plXYZRGB1[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat plXYZRGB2[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat plXYZRGB3[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat plXYZRGB4[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat plXYZRGB5[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
int numDl = 0;
GLfloat dlXYZRGB1[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat dlXYZRGB2[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat dlXYZRGB3[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat dlXYZRGB4[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
GLfloat dlXYZRGB5[6] = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
//GLfloat halfangle[3] = {0.0f, 0.0f, 0.0f};
GLfloat fullTerm[3] = {0.0f, 0.0f, 0.0f};
//GLfloat lightVec2[3] = {lightVec[0], lightVec[1], lightVec[2]};
GLfloat fullFirstTerm = 0;
GLfloat nhTotal = 0;
GLfloat fres = 0;


inline float sqr(float x) { return x*x; }


//****************************************************
// Simple init function
//****************************************************
void initializeRendering()
{
    glfwInit();
}


//****************************************************
// A routine to set a pixel by drawing a GL point.  This is not a
// general purpose routine as it assumes a lot of stuff specific to
// this example.
//****************************************************
void setPixel(float x, float y, GLfloat r, GLfloat g, GLfloat b) {
    glColor3f(r, g, b);
    glVertex2f(x+0.5, y+0.5);  // The 0.5 is to target pixel centers
    // Note: Need to check for gap bug on inst machines.
}

//****************************************************
// Keyboard inputs
//****************************************************
static void key_callback(GLFWwindow* window, int key, int scancode, int action, int mods)
{
    switch (key) {
            
        case GLFW_KEY_ESCAPE: glfwSetWindowShouldClose(window, GLFW_TRUE); break;
        case GLFW_KEY_Q: glfwSetWindowShouldClose(window, GLFW_TRUE); break;
        case GLFW_KEY_LEFT :
            if (action) translation[0] -= 0.01f * Width_global; break;
        case GLFW_KEY_RIGHT:
            if (action) translation[0] += 0.01f * Width_global; break;
        case GLFW_KEY_UP   :
            if (action) translation[1] += 0.01f * Height_global; break;
        case GLFW_KEY_DOWN :
            if (action) translation[1] -= 0.01f * Height_global; break;
        case GLFW_KEY_F:
            if (action) auto_strech = !auto_strech; break;
        case GLFW_KEY_SPACE: break;
            
        default: break;
    }
    
}


//****************************************************
// vector divide
//****************************************************
void vecDivide(GLfloat vec1[], GLfloat vec2[], GLfloat ret[]){
	ret[0] = vec1[0]/vec2[0];
	ret[1] = vec1[1]/vec2[1];
	ret[2] =  vec1[2]/vec2[2];
}

void vecDivideCon(GLfloat vec[], GLfloat constant, GLfloat ret[]){
	ret[0] = vec[0]/constant;
	ret[1] = vec[1]/constant;
	ret[2] = vec[2]/constant;
}

//****************************************************
// vector multiply
//****************************************************
void vecMultiply(GLfloat vec1[], GLfloat vec2[], GLfloat ret[]){
	ret[0] = vec1[0]*vec2[0];
	ret[1] = vec1[1]*vec2[1];
	ret[2] =  vec1[2]*vec2[2];
}

void vecMultiplyCon(GLfloat vec[], GLfloat constant, GLfloat ret[]){
	for(int i = 0; i < 3; i++){
		if(!(constant < 0.0f && vec[i]==0.0f)){
			ret[i] = constant*vec[i];
		}
		else{
			ret[i] = 0;
		}
	}
}

//****************************************************
// vector add
//****************************************************
void vecAdd(GLfloat vec1[], GLfloat vec2[], GLfloat ret[]){
	ret[0] = vec1[0]+vec2[0];
	ret[1] = vec1[1]+vec2[1];
	ret[2] =  vec1[2]+vec2[2];
}

//****************************************************
// vector subtract
//****************************************************
void vecSubtract(GLfloat vec1[], GLfloat vec2[], GLfloat ret[]){
	ret[0] = vec1[0]-vec2[0];
	ret[1] = vec1[1]-vec2[1];
	ret[2] =  vec1[2]-vec2[2];

}

//****************************************************
// normalize Function
//****************************************************
GLfloat magnitudeVec(GLfloat vec[]){
	return sqrt((vec[0] * vec[0]) + (vec[1] * vec[1]) + (vec[2] * vec[2]));
}

//****************************************************
// normalize Function
//****************************************************
void normalizeVec(GLfloat vec[], GLfloat normVec[]){
	GLfloat mag = magnitudeVec(vec);
	if(mag > 0.0f){
		vecDivideCon(vec, mag, normVec);
	}
	else{
		normVec[0] = 0.0f;
		normVec[1] = 0.0f;
		normVec[2] = 0.0f;
	}
}

//****************************************************
// dotProduct Function
//****************************************************
GLfloat dotProduct(GLfloat vec1[], GLfloat vec2[]){
	return (vec1[0] * vec2[0]) + (vec1[1] * vec2[1]) + (vec1[2] * vec2[2]);
}

//****************************************************
// crossProduct Function
//****************************************************
void crossProduct(GLfloat vec1[], GLfloat vec2[], GLfloat ret[]){
	ret[0] = (vec1[1] * vec2[2]) - (vec1[2] * vec2[1]);
	ret[1] = (vec1[2] * vec2[0]) - (vec1[0] * vec2[2]);
	ret[2] = (vec1[0] * vec2[1]) - (vec1[1] * vec2[0]);
}

//****************************************************
// maxVZero Function
//****************************************************
GLfloat maxVZero(GLfloat num){
	if(num > 0.0f){
		return num;
	}
	else{
		return (GLfloat) 0.0f;
	}
}

//****************************************************
// first term calc in Shirley calc
//****************************************************
GLfloat calcFirstTerm(GLfloat spuPU, GLfloat spvPV) {
	GLfloat numerator = sqrt((spuPU+1)*(spvPV+1));
	return numerator/(8*PI);
}

//****************************************************
// getting u and v
//****************************************************
void calcV(GLfloat yVec[], GLfloat normVec[], GLfloat ret[]) {
	GLfloat *term2 = (GLfloat*) malloc(3);
	vecMultiplyCon(normVec, dotProduct(normVec, yVec), term2);
	GLfloat *retTerm = (GLfloat*) malloc(3);
	vecSubtract(yVec, term2, retTerm);
	free(term2);
	normalizeVec(retTerm, ret);
	free(retTerm);
}

void calcU(GLfloat vVec[], GLfloat normVec[], GLfloat ret[]) {
	GLfloat *retRaw = (GLfloat*) malloc(3);
	crossProduct(vVec, normVec, retRaw);
	normalizeVec(retRaw, ret);
}



//****************************************************
// calculating half-angle
//****************************************************
void calcHalfAngle(GLfloat lightVec[], GLfloat viewVec[], GLfloat ret[]) {
	GLfloat *num = (GLfloat*) malloc(3);
	vecAdd(lightVec, viewVec, num);
	GLfloat mag = magnitudeVec(num);
	vecDivideCon(num, mag, ret);
}

//****************************************************
// spu and spv exponent 
//****************************************************
GLfloat calcNHPower(GLfloat spuPU, GLfloat halfAngle[], GLfloat uVal[], GLfloat vVal[], GLfloat normVec[], GLfloat viewVec[]) {
	GLfloat term1 = spuPU*((dotProduct(halfAngle, uVal))*(dotProduct(halfAngle, uVal)));
	GLfloat term2 = spuPU*((dotProduct(halfAngle, vVal))*(dotProduct(halfAngle, vVal)));
	GLfloat term3 = 1 - (dotProduct(halfAngle, normVec)*dotProduct(halfAngle, normVec));
	return (term1 + term2) / term3;
}

//****************************************************
// fresnel calculation
//****************************************************
GLfloat calcFres(GLfloat halfVec[], GLfloat viewVec[], GLfloat ksCon) {
	return ksCon + (1-ksCon)*(pow((1-(dotProduct(halfVec, viewVec))), 5));
}

GLfloat calcAnisoSpec(GLfloat firstTerm, GLfloat nhPower, GLfloat fresTerm, GLfloat halfAngle[], GLfloat normVec[], GLfloat viewVec[], GLfloat lightVec[]) {
	cout << "Normal Vector: " << normVec[0] << " " << normVec[1] << " " << normVec[2] << endl;
	cout << "View Vector: " << viewVec[0] << " " << viewVec[1] << " " << viewVec[2] << endl;
	cout << "Light Vector: " << lightVec[0] << " " << lightVec[1] << " " << lightVec[2] << endl;
	GLfloat secondTermNum = pow(dotProduct(normVec, halfAngle), nhPower);
	cout << "nhPow: " << nhPower << endl;
	cout << "dotProd: " << dotProduct(normVec, halfAngle) << endl;
	cout << "dotProd: " << pow(dotProduct(normVec, halfAngle), nhPower) << endl;
	GLfloat secondTermDenom = dotProduct(halfAngle, viewVec) * max(dotProduct(normVec, viewVec), dotProduct(normVec, lightVec));
	cout << "Second Term Denom: " << secondTermDenom << endl;
	GLfloat secondTerm = secondTermNum / secondTermDenom;
	cout << "Second Term: " << secondTerm << endl;
	return firstTerm * secondTerm * fresTerm;
}

//****************************************************
// setUp Light Var
//****************************************************
void setUpLightVar(GLfloat light[], GLfloat arg1, GLfloat arg2, GLfloat arg3, GLfloat arg4, GLfloat arg5, GLfloat arg6){
	light[0] = arg1;
	light[1] = arg2;
	light[2] = arg3;
	light[3] = arg4;
	light[4] = arg5;
	light[5] = arg6;
}

//****************************************************
// Command Line inputs
//****************************************************
void commandLine(int argc, char *argv[]) {
    int i = 1;
	cout << argv[i] << endl;
    while(i < argc) {
		if(std::string(argv[i]) == "-ka"){
			kaRGB[0] = (GLfloat) atof(argv[i+1]);
			kaRGB[1] = (GLfloat) atof(argv[i+2]);
			kaRGB[2] = (GLfloat) atof(argv[i+3]);
			i = i + 4;
			cout << "-ka: " << kaRGB[0] << " " << kaRGB[1] << " " << kaRGB[2] << endl;
		}
		else if(std::string(argv[i]) == "-kd"){
			kdRGB[0] = (GLfloat) atof(argv[i+1]);
			kdRGB[1] = (GLfloat) atof(argv[i+2]);
			kdRGB[2] = (GLfloat) atof(argv[i+3]);
			i = i + 4;
			cout << "-kd: " << kdRGB[0] << " " << kdRGB[1] << " " << kdRGB[2] << endl;
		}
		else if(std::string(argv[i]) == "-ks"){
			ksRGB[0] = (GLfloat) atof(argv[i+1]);
			ksRGB[1] = (GLfloat) atof(argv[i+2]);
			ksRGB[2] = (GLfloat) atof(argv[i+3]);
			i = i + 4;
			cout << "-ks: " << ksRGB[0] << " " << ksRGB[1] << " " << ksRGB[2] << endl;
		}
		else if(std::string(argv[i]) == "-spu"){
			spuPU = (GLfloat) atof(argv[i+1]);
			i = i + 2;
			cout << "-spu: " << spuPU << endl;
		}
		else if(std::string(argv[i]) == "-spv"){
			spvPV = (GLfloat) atof(argv[i+1]);
			i = i + 2;
			cout << "-spv: " << spvPV << endl;
		}
		else if(std::string(argv[i]) == "-sp"){
			spP = (GLfloat) atof(argv[i+1]);
			i = i + 2;
			specSet = true;
			cout << "-sp: " << spP << endl;
		}
		else if(std::string(argv[i]) == "-pl"){
			GLfloat arg1 = (GLfloat) atof(argv[i+1]);
			GLfloat arg2 = (GLfloat) atof(argv[i+2]);
			GLfloat arg3 = (GLfloat) atof(argv[i+3]);
			GLfloat arg4 = (GLfloat) atof(argv[i+4]);
			GLfloat arg5 = (GLfloat) atof(argv[i+5]);
			GLfloat arg6 = (GLfloat) atof(argv[i+6]);
			if(numPl == 0) {
				setUpLightVar(plXYZRGB1, arg1, arg2, arg3, arg4, arg5, arg6);
				numPl = numPl + 1;
				cout << "-pl1: " << plXYZRGB1[0] << plXYZRGB1[1] << plXYZRGB1[2] << plXYZRGB1[3] << plXYZRGB1[4] << plXYZRGB1[5] << endl;
			}
			else if(numPl == 1) {
				setUpLightVar(plXYZRGB2, arg1, arg2, arg3, arg4, arg5, arg6);
				numPl = numPl + 1;
				cout << "-pl2: " << plXYZRGB2[0] << plXYZRGB2[1] << plXYZRGB2[2] << plXYZRGB2[3] << plXYZRGB2[4] << plXYZRGB2[5] << endl;
			}
			else if(numPl == 2) {
				setUpLightVar(plXYZRGB3, arg1, arg2, arg3, arg4, arg5, arg6);
				numPl = numPl + 1;
				cout << "-pl3: " << plXYZRGB3[0] << plXYZRGB3[1] << plXYZRGB3[2] << plXYZRGB3[3] << plXYZRGB3[4] << plXYZRGB3[5] << endl;
			}
			else if(numPl == 3) {
				setUpLightVar(plXYZRGB4, arg1, arg2, arg3, arg4, arg5, arg6);
				numPl = numPl + 1;
				cout << "-pl4: " << plXYZRGB4[0] << plXYZRGB4[1] << plXYZRGB4[2] << plXYZRGB1[3] << plXYZRGB4[4] << plXYZRGB4[5] << endl;
			}
			else if(numPl == 4) {
				setUpLightVar(plXYZRGB5, arg1, arg2, arg3, arg4, arg5, arg6);
				numPl = numPl + 1;
				cout << "-pl5: " << plXYZRGB5[0] << plXYZRGB5[1] << plXYZRGB5[2] << plXYZRGB5[3] << plXYZRGB5[4] << plXYZRGB5[5] << endl;
			}
			i = i + 7;
		}
		else if(std::string(argv[i]) == "-dl"){
			GLfloat arg1 = (GLfloat) atof(argv[i+1]);
			GLfloat arg2 = (GLfloat) atof(argv[i+2]);
			GLfloat arg3 = (GLfloat) atof(argv[i+3]);
			GLfloat arg4 = (GLfloat) atof(argv[i+4]);
			GLfloat arg5 = (GLfloat) atof(argv[i+5]);
			GLfloat arg6 = (GLfloat) atof(argv[i+6]);
			if(numDl == 0) {
				setUpLightVar(dlXYZRGB1, arg1, arg2, arg3, arg4, arg5, arg6);
				numDl = numDl + 1;
				cout << "-dl1: " << dlXYZRGB1[0] << dlXYZRGB1[1] << dlXYZRGB1[2] << dlXYZRGB1[3] << dlXYZRGB1[4] << dlXYZRGB1[5] << endl;
			}
			else if(numDl == 1) {
				setUpLightVar(dlXYZRGB2, arg1, arg2, arg3, arg4, arg5, arg6);
				numDl = numDl + 1;
				cout << "-dl2: " << dlXYZRGB2[0] << dlXYZRGB2[1] << dlXYZRGB2[2] << dlXYZRGB2[3] << dlXYZRGB2[4] << dlXYZRGB2[5] << endl;
			}
			else if(numDl == 2) {
				setUpLightVar(dlXYZRGB3, arg1, arg2, arg3, arg4, arg5, arg6);
				numDl = numDl + 1;
				cout << "-dl3: " << dlXYZRGB3[0] << dlXYZRGB3[1] << dlXYZRGB3[2] << dlXYZRGB3[3] << dlXYZRGB3[4] << dlXYZRGB3[5] << endl;
			}
			else if(numDl == 3) {
				setUpLightVar(dlXYZRGB4, arg1, arg2, arg3, arg4, arg5, arg6);
				numDl = numDl + 1;
				cout << "-dl4: " << dlXYZRGB4[0] << dlXYZRGB4[1] << dlXYZRGB4[2] << dlXYZRGB1[3] << dlXYZRGB4[4] << dlXYZRGB4[5] << endl;
			}
			else if(numDl == 4) {
				setUpLightVar(dlXYZRGB5, arg1, arg2, arg3, arg4, arg5, arg6);
				numDl = numDl + 1;
				cout << "-dl5: " << dlXYZRGB5[0] << dlXYZRGB5[1] << dlXYZRGB5[2] << dlXYZRGB5[3] << dlXYZRGB5[4] << dlXYZRGB5[5] << endl;
			}
			i = i + 7;
		}
    }
}

void setAnisotropic(GLfloat lightVec[], GLfloat exViewVec[], GLfloat exNormVec[]){
	GLfloat exPu = spuPU;
	GLfloat exPv = spvPV;
	GLfloat *exLightVec = (GLfloat*) malloc(3);
	normalizeVec(lightVec, exLightVec);
	GLfloat exYvec[3] = {0.0f, 1.0f, 0.0f};
	GLfloat *exU= (GLfloat*) malloc(3);
	GLfloat *exV = (GLfloat*) malloc(3);
	GLfloat *halfVec = (GLfloat*) malloc(3);
	GLfloat ksCon = spP;
	calcV(exYvec, exNormVec, exV);
	cout << "V value: {" << exV[0] << ", " << exV[1] << ", " << exV[2] << "}" << endl;
	calcU(exV, exNormVec, exU);
	cout << "U value: {" << exU[0] << ", " << exU[1] << ", " << exU[2] << "}" << endl;
	calcHalfAngle(exLightVec, exViewVec, halfVec);
	cout << "HalfVec value: {" << halfVec[0] << ", " << halfVec[1] << ", " << halfVec[2] << "}" << endl;
	GLfloat firstTerm = calcFirstTerm(exPu, exPv);
	cout << "First Term: " << firstTerm << endl;
	GLfloat nhPower = calcNHPower(exPu, halfVec, exU, exV, exNormVec, exViewVec);
	cout << "NHPower: " << nhPower << endl;
	GLfloat fresTerm = calcFres(halfVec, exViewVec, ksCon);
	cout << "Fres Term: " << fresTerm << endl;
	spP = calcAnisoSpec(firstTerm, nhPower, fresTerm, halfVec, exNormVec, exViewVec, exLightVec);
	cout << "Aniso Spec: " << spP << endl;
}

void computeLightShade(GLfloat norVec[], GLfloat viewVec[], GLfloat lightRGB[], GLfloat pixelInt[], GLfloat lightIntVec[]){
	GLfloat *lightIntVecNorm = (GLfloat*) malloc(3);
	normalizeVec(lightIntVec, lightIntVecNorm);
	if(!specSet){
		setAnisotropic(lightIntVecNorm, viewVec, norVec);
	}
	//cout << "LVecNorm: {" << lightIntVecNorm[0] << ", " << lightIntVecNorm[1] << ", " << lightIntVecNorm[2] << "}" << endl;
	GLfloat *kdLightVec = (GLfloat*) malloc(3);
	vecMultiplyCon(kdRGB, maxVZero(dotProduct(lightIntVecNorm, norVec)), kdLightVec);
	//cout << "kdLightVec: {" << kdLightVec[0] << ", " << kdLightVec[1] << ", " << kdLightVec[2] << "}" << endl;
	GLfloat specCon = 2.0f;
	GLfloat difCon = -1.0f;
	GLfloat *rVec = (GLfloat*) malloc(3);
	GLfloat *rVecTerm2 = (GLfloat*) malloc(3);
	GLfloat *rVecTerm1 = (GLfloat*) malloc(3);
	vecMultiplyCon(norVec, specCon * dotProduct(lightIntVecNorm, norVec),  rVecTerm2);
	vecMultiplyCon(lightIntVecNorm, difCon, rVecTerm1);
	free(lightIntVecNorm);
	vecAdd(rVecTerm1, rVecTerm2, rVec);
	free(rVecTerm1);
	free(rVecTerm2);
	//cout << "rVec: {" << rVec[0] << ", " << rVec[1] << ", " << rVec[2] << "}" << endl;
	GLfloat *ksLightVec = (GLfloat*) malloc(3);
	GLfloat baseFloat = maxVZero(dotProduct(rVec, viewVec));
	GLfloat exponFloat = pow(baseFloat, spP);
	vecMultiplyCon(ksRGB, exponFloat, ksLightVec);
	free(rVec);
	//cout << "ksLightVec: {" << ksLightVec[0] << ", " << ksLightVec[1] << ", " << ksLightVec[2] << "}" << endl;
	GLfloat *kskdVec = (GLfloat*) malloc(3);
	vecAdd(kdLightVec, ksLightVec, kskdVec);
	free(kdLightVec);
	free(ksLightVec);
	GLfloat *kskdRGBVec = (GLfloat*) malloc(3);
	vecMultiply(lightRGB, kskdVec, kskdRGBVec);
	vecMultiply(lightRGB, kskdVec, pixelInt);
	free(kskdVec);
	//cout << "kskdRGBVec: {" << kskdRGBVec[0] << ", " << kskdRGBVec[1] << ", " << kskdRGBVec[2] << "}" << endl;
	free(kskdRGBVec);
}

void computeLightShadePointL(GLfloat norVec[], GLfloat viewVec[], GLfloat lightVec[], GLfloat pixelInt[]){
	GLfloat lightXYZ[3] = {lightVec[0], lightVec[1], lightVec[2]};
	//cout << "LXYZ: {" << lightXYZ[0] << ", " << lightXYZ[1] << ", " << lightXYZ[2] << "}" << endl;
	GLfloat lightRGB[3] = {lightVec[3], lightVec[4], lightVec[5]};
	//cout << "LRGB: {" << lightRGB[0] << ", " << lightRGB[1] << ", " << lightRGB[2] << "}" << endl;
	GLfloat *lightIntVec = (GLfloat*) malloc(3);
	vecSubtract(lightXYZ, norVec, lightIntVec);
	//cout << "LVec: {" << lightIntVec[0] << ", " << lightIntVec[1] << ", " << lightIntVec[2] << "}" << endl;
	computeLightShade(norVec, viewVec, lightRGB, pixelInt, lightIntVec);
	free(lightIntVec);
}

void computeLightShadeDirL(GLfloat norVec[], GLfloat viewVec[], GLfloat lightVec[], GLfloat pixelInt[]){
	GLfloat lightXYZ[3] = {lightVec[0], lightVec[1], lightVec[2]};
	//cout << "LXYZ: {" << lightXYZ[0] << ", " << lightXYZ[1] << ", " << lightXYZ[2] << "}" << endl;
	GLfloat lightRGB[3] = {lightVec[3], lightVec[4], lightVec[5]};
	//cout << "LRGB: {" << lightRGB[0] << ", " << lightRGB[1] << ", " << lightRGB[2] << "}" << endl;
	GLfloat reverseCon = -1.0f;
	GLfloat *lightIntVec = (GLfloat*) malloc(3);
	vecMultiplyCon(lightXYZ, reverseCon, lightIntVec);
	//cout << "LVec: {" << lightIntVec[0] << ", " << lightIntVec[1] << ", " << lightIntVec[2] << "}" << endl;
	computeLightShade(norVec, viewVec, lightRGB, pixelInt, lightIntVec);
	free(lightIntVec);
}


//Module - Calculate Pixel Shade
void calcPixelShade(GLfloat xcord, GLfloat ycord, GLfloat zcord, GLfloat viewVecPos[],  GLfloat pixelRGB[]){
	GLfloat *ret = (GLfloat*) malloc(3);
	ret[0] = 0.0f;
	ret[1] = 0.0f;
	ret[2] = 0.0f;

	GLfloat norVec[3] = {xcord, ycord, zcord};
	//cout << "normal vector: {" << norVec[0] << ", " << norVec[1] << ", " << norVec[2] << "}" << endl;
	//GLfloat[3] viewVec = vecSubtract({0.0f, 0.0f, (Width_global/2)}, norVec);
	GLfloat *viewVec = (GLfloat*) malloc(3);
	vecSubtract(viewVecPos, norVec, viewVec);
	//cout << "View Vector: {" << viewVec[0] << ", " << viewVec[1] << ", " << viewVec[2] << "}" << endl;
	GLfloat *pixelInt = (GLfloat*) malloc(3);
	GLfloat *pixelInt1 = (GLfloat*) malloc(3);
	if(numPl > 0){
		cout << "----------PL1----------" << endl;
		computeLightShadePointL(norVec, viewVec, plXYZRGB1, pixelInt);
		vecAdd(ret, pixelInt, ret);
		//cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numPl > 1){
		cout << "----------PL2----------" << endl;
		computeLightShadePointL(norVec, viewVec, plXYZRGB2, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numPl > 2){
		cout << "----------PL3----------" << endl;
		computeLightShadePointL(norVec, viewVec, plXYZRGB3, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numPl > 3){
		cout << "----------PL4----------" << endl;
		computeLightShadePointL(norVec, viewVec, plXYZRGB4, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numPl > 4){
		cout << "----------PL5----------" << endl;
		computeLightShadePointL(norVec, viewVec, plXYZRGB5, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numDl > 0){
		cout << "----------DL1----------" << endl;
		computeLightShadeDirL(norVec, viewVec, dlXYZRGB1, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numDl > 1){
		cout << "----------DL2----------" << endl;
		computeLightShadeDirL(norVec, viewVec, dlXYZRGB2, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numDl > 2){
		cout << "----------DL3----------" << endl;
		computeLightShadeDirL(norVec, viewVec, dlXYZRGB3, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numDl > 3){
		cout << "----------DL4----------" << endl;
		computeLightShadeDirL(norVec, viewVec, dlXYZRGB4, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	if(numDl > 4){
		cout << "----------DL5----------" << endl;
		computeLightShadeDirL(norVec, viewVec, dlXYZRGB5, pixelInt);
		vecAdd(ret, pixelInt, ret);
		cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	}
	vecAdd(ret, kaRGB, pixelRGB);
	cout << "ret: {" << ret[0] << ", " << ret[1] << ", " << ret[2] << "}" << endl;
	free(pixelInt);
	free(viewVec);
	free(ret);
}

//****************************************************
// Draw a filled circle.
//****************************************************
void drawCircle(float centerX, float centerY, float radius) {
    // Draw inner circle
    glBegin(GL_POINTS);

    // We could eliminate wasted work by only looping over the pixels
    // inside the sphere's radius.  But the example is more clear this
    // way.  In general drawing an object by loopig over the whole
    // screen is wasteful.

    int minI = max(0,(int)floor(centerX-radius));
    int maxI = min(Width_global-1,(int)ceil(centerX+radius));

    int minJ = max(0,(int)floor(centerY-radius));
    int maxJ = min(Height_global-1,(int)ceil(centerY+radius));
    int count = 1;
    for (int i = 0; i < Width_global; i++) {
        for (int j = 0; j < Height_global; j++) {

            // Location of the center of pixel relative to center of sphere
            float x = (i+0.5-centerX);
            float y = (j+0.5-centerY);

            float dist = sqrt(sqr(x) + sqr(y));

            if (dist <= radius) {
                // This is the front-facing Z coordinate
                float z = sqrt(radius*radius-dist*dist);
                //setPixel(i, j, 0, 0, 1);
                GLfloat *pixelRGB = (GLfloat*) malloc(3);
                GLfloat *viewVecPos = (GLfloat*) malloc(3);
                viewVecPos[0] = 0.0f;
                viewVecPos[1] = 0.0f;
                viewVecPos[2] = (Width_global / 2 ) / radius;
                float x_unit = x/radius;
                float y_unit = y/radius;
                float z_unit = z/radius;
				calcPixelShade(x_unit, y_unit, z_unit, viewVecPos, pixelRGB);
				cout << "RGBVec: {" << pixelRGB[0] << ", " << pixelRGB[1] << ", " << pixelRGB[2] << "}" << endl;
                setPixel(i, j, pixelRGB[0], pixelRGB[1], pixelRGB[2]);
                free(viewVecPos);
                free(pixelRGB);

                // This is amusing, but it assumes negative color values are treated reasonably.
                // setPixel(i,j, x/radius, y/radius, z/radius );
                
                // Just for fun, an example of making the boundary pixels yellow.
                // if (dist > (radius-1.0)) {
                //     setPixel(i, j, 1.0, 1.0, 0.0);
                // }
            }
        }
    }

    glEnd();
}

//****************************************************
// function that does the actual drawing of stuff
//***************************************************
void display( GLFWwindow* window )
{
    glClearColor( 0.0f, 0.0f, 0.0f, 0.0f ); //clear background screen to black
    
    glClear(GL_COLOR_BUFFER_BIT);                // clear the color buffer (sets everything to black)
    
    glMatrixMode(GL_MODELVIEW);                  // indicate we are specifying camera transformations
    glLoadIdentity();                            // make sure transformation is "zero'd"
    
    //----------------------- code to draw objects --------------------------
    glPushMatrix();
    glTranslatef (translation[0], translation[1], translation[2]);
    drawCircle(Width_global / 2.0 , Height_global / 2.0 , min(Width_global, Height_global) * 0.8 / 2.0);
    glPopMatrix();
    
    glfwSwapBuffers(window);
    
}

//****************************************************
// function that is called when window is resized
//***************************************************
void size_callback(GLFWwindow* window, int width, int height)
{
    // Get the pixel coordinate of the window
    // it returns the size, in pixels, of the framebuffer of the specified window
    glfwGetFramebufferSize(window, &Width_global, &Height_global);
    
    glViewport(0, 0, Width_global, Height_global);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, Width_global, 0, Height_global, 1, -1);
    
    display(window);
}



//****************************************************
// the usual stuff, nothing exciting here
//****************************************************
int main(int argc, char *argv[]) {
    //This initializes glfw
/*	GLfloat exPu = 0.5f;
	GLfloat exPv = 0.5f;
	GLfloat exViewVec[3] = {0.0f, 0.0f, 1.0f};
	GLfloat exLightVec[3] = {0.0f, 1.0f, 1.0f};
	GLfloat exNormVec[3] = {0.0f, 0.0f, 1.0f};
	GLfloat exYvec[3] = {0.0f, 1.0f, 0.0f};
	GLfloat *exU= (GLfloat*) malloc(3);
	GLfloat *exV = (GLfloat*) malloc(3);
	GLfloat *halfVec = (GLfloat*) malloc(3);
	GLfloat ksCon = ksRGB[0];
	ksCon = 0.5f;
	calcV(exYvec, exNormVec, exV);
	cout << "V value: {" << exV[0] << ", " << exV[1] << ", " << exV[2] << "}" << endl;
	calcU(exV, exNormVec, exU);
	cout << "U value: {" << exU[0] << ", " << exU[1] << ", " << exU[2] << "}" << endl;
	calcHalfAngle(exLightVec, exViewVec, halfVec);
	cout << "HalfVec value: {" << halfVec[0] << ", " << halfVec[1] << ", " << halfVec[2] << "}" << endl;
	GLfloat firstTerm = calcFirstTerm(exPu, exPv);
	cout << "First Term: " << firstTerm << endl;
	GLfloat nhPower = calcNHPower(exPu, halfVec, exU, exV, exNormVec, exViewVec);
	cout << "NHPower: " << nhPower << endl;
	GLfloat fresTerm = calcFres(halfVec, exViewVec, ksCon);
	cout << "Fres Term: " << fresTerm << endl;
	GLfloat anisoSpec = calcAnisoSpec(firstTerm, nhPower, fresTerm, halfVec, exNormVec, exViewVec, exLightVec);
	cout << "Aniso Spec: " << anisoSpec << endl;*/

    commandLine(argc, argv);  
    initializeRendering();
    
    GLFWwindow* window = glfwCreateWindow( Width_global, Height_global, "CS184", NULL, NULL );
    if ( !window )
    {
        cerr << "Error on window creating" << endl;
        glfwTerminate();
        return -1;
    }
    
    const GLFWvidmode * mode = glfwGetVideoMode(glfwGetPrimaryMonitor());
    if ( !mode )
    {
        cerr << "Error on getting monitor" << endl;
        glfwTerminate();
        return -1;
    }
    
    glfwMakeContextCurrent( window );
    
    // Get the pixel coordinate of the window
    // it returns the size, in pixels, of the framebuffer of the specified window
    glfwGetFramebufferSize(window, &Width_global, &Height_global);
    
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, Width_global, 0, Height_global, 1, -1);
    
    glfwSetWindowTitle(window, "CS184");
    glfwSetWindowSizeCallback(window, size_callback);
    glfwSetKeyCallback(window, key_callback);
    
    while( !glfwWindowShouldClose( window ) ) // infinite loop to draw object again and again
    {   // because once object is draw then window is terminated
        display( window );

	//cout << argv[i] << endl;

        if (auto_strech){
            glfwSetWindowSize(window, mode->width, mode->height);
            glfwSetWindowPos(window, 0, 0);
        }
        
        glfwPollEvents();
        
    }

    return 0;
}

/*int main(int argc, char *argv[]) {
	cout << "reached main" << endl;
	commandLine(argc, argv);
	GLfloat *pixelRGB = (GLfloat*) malloc(3);
	calcPixelShade(0, 0, 1, pixelRGB);
	cout << "RGB: {" << pixelRGB[0] << ", " << pixelRGB[1] << ", " << pixelRGB[2] << "}" << endl;
	free(pixelRGB);
	return 0;
}*/

package raytracer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ObjParser {
    public ArrayList<Point> vertices;
    public ArrayList<Face> faces;
    public ArrayList<Triangle> triangles;
    String filename;
    
    
    public ObjParser(String filename) throws IOException{
    	this.filename = filename;
    	this.vertices = new ArrayList<Point>();
    	this.triangles = new ArrayList<Triangle>();
    }

    public static void main(String[] args) throws IOException {
        ObjParser objParse = new ObjParser("bin/input/flattriangle.obj");
        objParse.loadTriangles();
        System.out.println("done");
    }

    
    private void loadTriangles() throws IOException{
    	for(String line : Files.readAllLines(Paths.get(this.filename))) {
            String[] words = line.split(" "); 
            if(words[0].equals("v")){
            	double x = Double.parseDouble(words[1]);
                double y = Double.parseDouble(words[2]);
                double z = Double.parseDouble(words[3]);
                vertices.add(new Point(x, y, z));
            }
            if(words[0].equals("f")){
            	ArrayList<Integer> vertexSet = new ArrayList<Integer>();
                ArrayList<Point> faceVertexSet = new ArrayList<Point>();
                for(int i = 1; i < 4; i++){
                    vertexSet.add(Integer.parseInt(words[i]));
                }
                for(int i = 0; i < 3; i++){
                    faceVertexSet.add(vertices.get(vertexSet.get(i)-1));
                }
                triangles.add(new Triangle(faceVertexSet.get(0), faceVertexSet.get(1), faceVertexSet.get(2)));
            }
    	}
    }
}
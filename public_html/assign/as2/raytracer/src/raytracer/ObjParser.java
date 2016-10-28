package raytracer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ObjParser {
    public ArrayList<Point> vertices;
    public ArrayList<Face> faces;
    public ArrayList<Triangle> triangles;
    
    public ObjParser(String filename) throws IOException{
        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        loadFaces(br);
    }

    public void loadFaces(BufferedReader br) throws IOException{
        String newLine = br.readLine();
        while(newLine != null){
            if(newLine.length() > 0){
                newLine = newLine.trim();
                StringTokenizer st = new StringTokenizer(newLine, " ");
                if(st.nextToken().equals("v")){
                    double x = Double.parseDouble(st.nextToken());
                    double y = Double.parseDouble(st.nextToken());
                    double z = Double.parseDouble(st.nextToken());
                    vertices.add(new Point(x, y, z));
                }
      
                if(st.nextToken().equals("f")){
                    ArrayList<Integer> vertexSet = new ArrayList<Integer>();
                    ArrayList<Point> faceVertexSet = new ArrayList<Point>();
                    for(int i = 0; i < st.countTokens(); i++){
                        vertexSet.add(Integer.parseInt(st.nextToken()));
                    }
                    for(int vertex : vertexSet){
                        faceVertexSet.add(vertices.get(vertexSet.get(vertex-1)));
                    }
                    faces.add(new Face(faceVertexSet));
                }
            }
        }
    }
    
    private void loadTriangles(BufferedReader br) throws IOException{
        String newLine = br.readLine();
        while(newLine != null){
            if(newLine.length() > 0){
                newLine = newLine.trim();
                StringTokenizer st = new StringTokenizer(newLine, " ");
                if(st.nextToken().equals("v")){
                    double x = Double.parseDouble(st.nextToken());
                    double y = Double.parseDouble(st.nextToken());
                    double z = Double.parseDouble(st.nextToken());
                    vertices.add(new Point(x, y, z));
                }
      
                if(st.nextToken().equals("f")){
                    ArrayList<Integer> vertexSet = new ArrayList<Integer>();
                    ArrayList<Point> faceVertexSet = new ArrayList<Point>();
                    for(int i = 0; i < st.countTokens(); i++){
                        vertexSet.add(Integer.parseInt(st.nextToken()));
                    }
                    for(int vertex : vertexSet){
                        faceVertexSet.add(vertices.get(vertexSet.get(vertex-1)));
                    }
                    triangles.add(new Triangle(faceVertexSet.get(0), faceVertexSet.get(1), faceVertexSet.get(2)));
                }
            }
        }
    }
}
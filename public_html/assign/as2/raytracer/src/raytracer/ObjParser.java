package raytracer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ObjParser {
    private ArrayList<Point> vertices;
    private ArrayList<Face> faces;
    
    public ObjParser(String filename) throws IOException{
        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        loadFaces(br);
    }

    private void loadFaces(BufferedReader br) throws IOException{
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
}
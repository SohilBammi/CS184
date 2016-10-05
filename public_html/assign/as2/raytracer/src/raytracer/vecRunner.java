package raytracer;

public class vecRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Vector vec1 = new Vector(2.0, 2.0, 3.0);
        Vector vec2 = new Vector(2.0, 2.0, 1.0);
        vec1.printVector();
        vec2.printVector();
        System.out.println("Dot Product: " + vec1.dotProduct(vec2));
        Vector crossProd = vec1.crossProduct(vec2);
        System.out.print("Cross Product: ");
        crossProd.printVector();
        
    }

}

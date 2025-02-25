import java.awt.geom.*; 
import java.util.ArrayList; 
import gpdraw.*; 

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    public IrregularPolygon() {}

    public void add(Point2D.Double aPoint) {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        if (myPolygon.size() < 2) return 0; 

        double perimeter = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size()); 
            perimeter += p1.distance(p2);
        }
        return perimeter;
    }

    public double area() {
        if (myPolygon.size() < 3) return 0; 

        double sum1 = 0, sum2 = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size()); 
            sum1 += p1.x * p2.y;
            sum2 += p1.y * p2.x;
        }
        return Math.abs((sum1 - sum2) / 2);
    }

    
    public void draw() {
        if (myPolygon.size() < 2) return; 

        DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
        Point2D.Double firstPoint = myPolygon.get(0);
        pen.up();
        pen.move(firstPoint.x, firstPoint.y);
        pen.down();

        for (Point2D.Double point : myPolygon) {
            pen.move(point.x, point.y);
        }
        pen.move(firstPoint.x, firstPoint.y); 
    }
}

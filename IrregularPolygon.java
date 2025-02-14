import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // Constructor
    public IrregularPolygon() {}

    // Add a point to the polygon
    public void add(Point2D.Double aPoint) {
        myPolygon.add(aPoint);
    }

    // Calculate the perimeter
    public double perimeter() {
        if (myPolygon.size() < 2) return 0; // A single point or no points has no perimeter

        double perimeter = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size()); // Wraps around to the first point
            perimeter += p1.distance(p2);
        }
        return perimeter;
    }

    // Calculate the area using the Shoelace formula
    public double area() {
        if (myPolygon.size() < 3) return 0; // A polygon must have at least 3 points to have an area

        double sum1 = 0, sum2 = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size()); // Wraps around to the first point
            sum1 += p1.x * p2.y;
            sum2 += p1.y * p2.x;
        }
        return Math.abs((sum1 - sum2) / 2);
    }

    // Draw the polygon using DrawingTool
    public void draw() {
        if (myPolygon.size() < 2) return; // Not enough points to draw anything

        DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
        Point2D.Double firstPoint = myPolygon.get(0);
        pen.up();
        pen.move(firstPoint.x, firstPoint.y);
        pen.down();

        for (Point2D.Double point : myPolygon) {
            pen.move(point.x, point.y);
        }
        pen.move(firstPoint.x, firstPoint.y); // Close the polygon
    }
}

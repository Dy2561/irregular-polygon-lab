import java.awt.geom.*; 
import java.util.ArrayList; 
import gpdraw.*; 

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    public IrregularPolygon() {}

    public void add(Point2D.Double aPoint) {
        myPolygon.add(aPoint);
    }

    
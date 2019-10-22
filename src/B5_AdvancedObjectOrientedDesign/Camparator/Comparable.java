package B5_AdvancedObjectOrientedDesign.Camparator;

import B4_KeThuaVaDaHinh.HeCacHinh.Circle;
import B4_KeThuaVaDaHinh.HeCacHinh.Rectangle;
import B4_KeThuaVaDaHinh.HeCacHinh.Square;

public interface Comparable {
    public abstract int circleComparator(Circle c1, Circle c2);
    public abstract int rectangleComparator(Rectangle c1, Rectangle c2);
    public abstract int squareComparator(Square c1, Square c2);
}

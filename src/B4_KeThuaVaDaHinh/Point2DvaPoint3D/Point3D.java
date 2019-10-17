package B4_KeThuaVaDaHinh.Point2DvaPoint3D;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Point3D extends Point2D{
    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    private float z=0.0f;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y,float z){
        setX(x);
        setY(y);
        this.z=z;
    }
    public float[] getXYZ(){
        float[] arr = {getX(),getY(),getZ()};
        return arr;
    }

    @Override
    public String toString() {
        return super.toString()+ " Z= "+ getZ()+ " array= "+ Arrays.toString(getXYZ());
    }
}

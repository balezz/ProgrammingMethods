package ru.metrolog;

import static java.lang.Math.sqrt;
import static java.lang.System.out;

public class Task3B {

    public void printDistance() {
        Point point1 = new Point(1, 1, 1);
        Point point2 = new Point(2, 2, 2);
        out.println("Distance bw " + point1 + " and " + point2 +
                " is " + PointUtils.getDistance(point1, point2));
    }

    public void printIsCrossing() {
        float t = 5;
        Point point1 = new Point(1, 1, 1);
        Point point2 = new Point(1, 1, 1);
        if(PointUtils.isCrossing(point1, point2, t))
            out.println(point1 + " and " + point2 + " are crossing!");
        else  out.println(point1 + " and " + point2 + " are not crossing!");
    }
}

class Point {

    float x, y, z;
    float velX, velY, velZ;
    float acX, acY, acZ;

    public Point(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setVelZ(float velZ) {
        this.velZ = velZ;
    }

    public void setAcX(float acX) {
        this.acX = acX;
    }

    public void setAcY(float acY) {
        this.acY = acY;
    }

    public void setAcZ(float acZ) {
        this.acZ = acZ;
    }


    public float getVelocity() {
        return (float) sqrt(velX * velX + velY * velY + velZ * velZ);
    }

    public float getAccelerate() {
        return (float) sqrt(acX * acX + acY * acY + acZ * acZ);
    }

    public void move(float t) {
        x = x + velX * t + acX * t * t / 2;
        y = y + velY * t + acY * t * t / 2;
        z = z + velZ * t + acZ * t * t / 2;

        velX = acX * t;
        velY = acY * t;
        velZ = acZ * t;
    }

    @Override
    public String toString() {
        return new String("[" + x + ", " + y + ", " + z + "]");
    }

}

class PointUtils {

    public static float getDistance(Point p1, Point p2) {

        return (float) sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y) +
                (p1.z - p2.z) * (p1.z - p2.z));
    }

    /** Method returns true if traces of two points
     * are crossing  on interval of time t.
     * Trace described by equation  x(t) = x + velX * t + accX *t*t/2
     *
     * For coordinate x condition of crossing two traces is
     * x1 + velX1 * t + accX1 * t*t/2 == x2 + velX2 * t + accX2 * t*t/2
     * tx1 = ( (velX1 - velX2) - sqrt(DescX)) / 2 * (accX2 - accX1)
     * tx2 = ( (velX1 - velX2) + sqrt(DescX)) / 2 * (accX2 - accX1)
     * where DescX = (velX2 - velX1) * (velX2 - velX1) - 4 * (accX2 - accX1) * (x2 - x1)
     *
     * ty1, ty2, tz1, tz2 evaluates respectively
     * crossing condition is (tx1 | tx2) == (ty1 | ty2) == (tz1 | tz2)
     * */
    public static boolean isCrossing(Point p1, Point p2, float t) {

        float DescX = (p2.velX - p1.velX) * (p1.velX - p1.velX)
                 - 4 * (p1.acX - p2.acX) * (p1.x - p2.x);
        if (DescX < 0) return false;

        float DescY = (p2.velY - p1.velY) * (p1.velY - p1.velY)
                - 4 * (p1.acY - p2.acY) * (p1.y - p2.y);
        if (DescY < 0) return false;

        float DescZ = (p2.velZ - p1.velZ) * (p1.velZ - p1.velZ)
                - 4 * (p1.acZ - p2.acZ) * (p1.z - p2.z);
        if (DescZ < 0) return false;


        float tx1 = (( (p1.velX - p2.velX) - (float)sqrt(DescX)) / 2 * (p2.acX - p1.acX));
        float tx2 = (( (p1.velX - p2.velX) + (float)sqrt(DescX)) / 2 * (p2.acX - p1.acX));

        float ty1 = (( (p1.velY - p2.velY) - (float)sqrt(DescY)) / 2 * (p2.acY - p1.acY));
        float ty2 = (( (p1.velY - p2.velY) + (float)sqrt(DescY)) / 2 * (p2.acY - p1.acY));

        float tz1 = (( (p1.velZ - p2.velZ) - (float)sqrt(DescZ)) / 2 * (p2.acZ - p1.acZ));
        float tz2 = (( (p1.velZ - p2.velZ) + (float)sqrt(DescZ)) / 2 * (p2.acZ - p1.acZ));

        if( (tx1 >= 0) && (tx1 <= t) &&
                ((tx1 == ty1) || (tx1 == ty2)) &&
                ((tx1 == tz1) || (tx1 == tz2)) ) return true;

        if( (tx2 > 0) && (tx2 < t) &&
                ((tx2 == ty1) || (tx2 == ty2)) &&
                ((tx2 == tz1) || (tx2 == tz2)) ) return true;

        return false;
    }
}

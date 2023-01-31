package org.example;

import java.util.Scanner;

import java.util.logging.Logger;

interface ShapeInterface
{
    double perimeter();
    double area();
}
class Triangle implements ShapeInterface
{
    private final double side1;
    private final double side2;
    private final double base;
    Triangle(double side1,double side2,double base)
    {
        this.side1=side1;
        this.side2=side2;
        this.base=base;
    }
    public double perimeter()
    {
        return side1+side2+base;

    }

    public double area()throws NullPointerException
    {
        double s=(side1+side2+base)/2;
        double v=(s-side1)*(s-side2)*(s-base);
        double k= Math.sqrt(s*v);
        double h;
        if(base>0){
            h=(2*k)/base;}
        else
        {
            throw new ArithmeticException("Please enter valid base value");
        }
        return (base*h)/2;
    }
}
class ReactAngle implements ShapeInterface
{
    private final double length;
    private final double breadth;
    ReactAngle(double length,double breadth)
    {
        this.length=length;
        this.breadth=breadth;
    }
    public double perimeter()
    {

        return 2 * (length + breadth);
    }

    public double area()
    {
        return length * breadth;
    }

}
class Circle implements ShapeInterface
{
    private final double radius;
    double pi=3.14159;
    Circle(double radius)
    {
        this.radius=radius;
    }
    public double perimeter()
    {
        return 2*(pi *radius);
    }

    public double area()
    {
        return pi*(radius*radius);
    }


}
public class Shape
{
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        while(true) {
            try {
                int key = 0;
                LOGGER.info("\n1.Triangle\n2.Reactangle\n3.Circle\n4.Exit\nEnter the Choice:");
                int value = input.nextInt();
                switch (value) {
                    case 1 -> {
                        LOGGER.info("Enter the side1 value:");
                        double side1 = input.nextInt();
                        LOGGER.info("Enter the side2 value:");
                        double side2 = input.nextInt();
                        LOGGER.info("Enter the base value:");
                        double base = input.nextInt();
                        Triangle triangle = new Triangle(side1, side2, base);
                        if ((side1 == side2) && (base <= side1) && (base <= side2)) {
                            String print = "Area of the Triangle:" + triangle.area() + "\nPerimeter of the Triangle:" + triangle.perimeter();
                            LOGGER.info(print);
                        } else {
                            LOGGER.info("please enter valid values");
                        }
                    }
                    case 2 -> {
                        LOGGER.info("Enter the Length:");
                        double length = input.nextDouble();
                        LOGGER.info("Enter the breadth:");
                        double breadth = input.nextDouble();
                        ReactAngle reactAngle = new ReactAngle(length, breadth);
                        String print = "Area of the ReactAngle:" + reactAngle.area() + "\nPerimeter of the Reactangle:" + reactAngle.perimeter();
                        LOGGER.info(print);
                    }
                    case 3 -> {
                        LOGGER.info("Enter the radius:");
                        double radius = input.nextDouble();
                        Circle circle = new Circle(radius);
                        String print = "Area of the Circle:" + circle.area() + "\nPerimeter of the Circle:" + circle.perimeter();
                        LOGGER.info(print);
                    }
                    default -> {
                        LOGGER.info("----Thank You----");
                        key = 1;
                    }
                }
                if (key == 1) {
                    break;
                }
            } catch (Exception e) {
                String value="Please Enter Valid Numbers:"+e;
                LOGGER.info(value);
                input.nextLine();
            }

        }


    }
}
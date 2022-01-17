package ru.gb.task3;

public class PolymorphismTask {
    public static void main(String[] args) {
        Triangle triangle = new Triangle("Triangle 1");
        Circle circle = new Circle("Circle 1");
        Square square = new Square("Square 1");

        FigureExecutor figureExecutor = new FigureExecutor(circle);
        figureExecutor.printVertex();
    }

    public static class FigureExecutor {
        private GeometricalFigure figure;

        public FigureExecutor(GeometricalFigure figure) {
            this.figure = figure;
        }

        public void printVertex() {
            figure.printVertexCount();
        }
    }

    private abstract static class GeometricalFigure {
        String name;
        int vertexCount;

        public int getVertexCount() {
            return vertexCount;
        }

        public void printVertexCount() {
            System.out.println("This figure have " + getVertexCount() + " vertexes");
        }
    }

    private static class Square extends GeometricalFigure {

        public Square(String name) {
            this.name = name;
            this.vertexCount = 4;
        }
    }

    private static final class Triangle extends GeometricalFigure {
        public Triangle(String name) {
            this.name = name;
            this.vertexCount = 3;
        }
    }

    private static class Circle extends GeometricalFigure {
        public Circle(String name) {
            this.name = name;
            this.vertexCount = 0;
        }
    }


}

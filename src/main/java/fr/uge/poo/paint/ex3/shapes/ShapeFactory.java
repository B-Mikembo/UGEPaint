package fr.uge.poo.paint.ex3.shapes;

import java.util.function.Supplier;

@FunctionalInterface
public interface ShapeFactory {
    Shape create(int x, int y, int thirdElement, int fourthElement);

    default Supplier<Shape> fill(int x, int y, int thirdElement, int fourthElement) {
        return () -> create(x, y, thirdElement, fourthElement);
    }
}
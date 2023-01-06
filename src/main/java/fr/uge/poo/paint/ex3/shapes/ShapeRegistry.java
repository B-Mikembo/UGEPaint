package fr.uge.poo.paint.ex3.shapes;

import java.util.HashMap;
import java.util.function.Supplier;

public class ShapeRegistry {

    private final HashMap<String, ShapeFactory> registry = new HashMap<>();

    public ShapeRegistry() {
        register("line", Line::new);
        register("rectangle", Rectangle::new);
        register("ellipse", Ellipse::new);
    }

    private void register(String name, ShapeFactory shapeFactory) {
        registry.put(name, shapeFactory);
    }

    public ShapeFactory create(String name) {
        return registry.computeIfAbsent(name, n -> {
            throw new IllegalArgumentException("Unknown " + n);
        });
    }
}

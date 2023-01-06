package fr.uge.poo.paint.ex3;


import fr.uge.poo.paint.ex3.shapes.Shape;
import fr.uge.poo.paint.ex3.shapes.ShapeList;
import fr.uge.poo.paint.ex3.shapes.ShapeRegistry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class ParsingFile {

    public static ShapeList parseFile(Path path) throws IOException {
        var list = new ArrayList<Shape>();
        var registry = new ShapeRegistry();
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                var tokens = line.split(" ");
                var x = parseInt(tokens[1]);
                var y = parseInt(tokens[2]);
                var w = parseInt(tokens[3]);
                var h = parseInt(tokens[4]);
                list.add(registry.create(tokens[0]).fill(x, y, w, h).get());
            });
        }
        return new ShapeList(list);
    }
}

package fr.uge.poo.paint.ex3;

import fr.uge.poo.paint.ex3.shapes.Line;
import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Paint {

    public static void main(String[] args) throws IOException {

        var path = Paths.get("draw2.txt");
        var shapes = ParsingFile.parseFile(path);
        var drawer = new DrawShapes();
        drawer.render(shapes);
    }
}

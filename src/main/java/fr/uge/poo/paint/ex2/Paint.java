package fr.uge.poo.paint.ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.awt.Color;
import java.awt.Graphics2D;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import static java.lang.Integer.parseInt;

public class Paint {

    public static void main(String[] args) throws IOException {
        var area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        var list = new ArrayList<Line>();
        var path = Paths.get("draw1.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                var tokens = line.split(" ");
                var x1 = parseInt(tokens[1]);
                var y1 = parseInt(tokens[2]);
                var x2 = parseInt(tokens[3]);
                var y2 = parseInt(tokens[4]);
                list.add(new Line(x1, y1, x2, y2));
            });
        }

        area.render(graphics2D -> {
            graphics2D.setColor(Color.BLACK);
            list.forEach(line -> graphics2D.drawLine(
                    line.x1(),
                    line.y1(),
                    line.x2(),
                    line.y2()
            ));
        });
    }
}

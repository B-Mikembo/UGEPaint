package fr.uge.poo.paint.ex3;

import fr.uge.poo.paint.ex3.shapes.Ellipse;
import fr.uge.poo.paint.ex3.shapes.Line;
import fr.uge.poo.paint.ex3.shapes.ShapeList;
import fr.uge.poo.simplegraphics.SimpleGraphics;
import fr.uge.poo.paint.ex3.shapes.Rectangle;

import java.awt.*;
import java.util.HashMap;
import java.util.function.Consumer;

public class DrawShapes {
    private final HashMap<Class<?>, Consumer<Object>> map = new HashMap<>();

    private <T> DrawShapes when(Class<? extends T> type, Consumer<? super T> consumer) {
        map.put(type, (o -> consumer.accept(type.cast(o))));
        return this;
    }

    private void call(Object receiver) {
        var receiverClass = receiver.getClass();
        map.computeIfAbsent(receiverClass, k -> {
                    throw new IllegalArgumentException("invalid " + k.getName());
                })
                .accept(receiver);
    }

    public void render(ShapeList shapeList) {
        var area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(graphics2D -> {
            graphics2D.setColor(Color.BLACK);
            when(Line.class, line -> graphics2D.drawLine(
                    line.x1(),
                    line.y1(),
                    line.x2(),
                    line.y2()
            )).when(Rectangle.class, rectangle -> graphics2D.drawRect(
                    rectangle.x(),
                    rectangle.y(),
                    rectangle.width(),
                    rectangle.height()
            )).when(Ellipse.class, ellipse -> graphics2D.drawOval(
                    ellipse.x(),
                    ellipse.y(),
                    ellipse.width(),
                    ellipse.height()
            )).when(ShapeList.class, shapeList1 -> shapeList1.shapes().forEach(this::call))
            .call(shapeList);
        });
    }
}

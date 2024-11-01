package app;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;


public class ZoneInterdite extends ElemPanel {
    private List<Dimension> m_dimension;
    private Point point;

    public boolean isPointInZone(Point p) {
        for (Dimension d : m_dimension) {
            if ((p.x >= 0 && p.x <= d.width) &&
                    (p.y >= 0 && p.y <= d.height)) {
                return true;
            }
        }
            return false;
        }
    };




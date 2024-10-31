package app;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    private double zoomFactor = 1.0;  // Default zoom factor
    private double offsetX = 0;       // X translation offset
    private double offsetY = 0;       // Y translation offset

    public DrawingPanel() {
        // Set the preferred size of the panel
        setPreferredSize(new Dimension(800, 600));

        // Set the background color of the panel
        setBackground(Color.LIGHT_GRAY);

        // Add a MouseWheelListener to handle zooming with the scroll wheel
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Get the mouse location relative to the panel
                double mouseX = e.getX();
                double mouseY = e.getY();

                // Old zoom factor (before change)
                double oldZoomFactor = zoomFactor;

                // If scrolling up, zoom in; if scrolling down, zoom out
                if (e.getPreciseWheelRotation() < 0) {
                    zoomFactor *= 1.1;  // Increase zoom by 10%
                } else {
                    zoomFactor /= 1.1;  // Decrease zoom by 10%
                }

                // Calculate the new offsets to ensure the point under the mouse stays fixed
                offsetX = mouseX - (mouseX - offsetX) * (zoomFactor / oldZoomFactor);
                offsetY = mouseY - (mouseY - offsetY) * (zoomFactor / oldZoomFactor);

                // Repaint after zooming
                revalidate();
                repaint();
            }
        });

        // Add a MouseAdapter to capture and print the logical coordinates relative to the zoom and offset
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Convert the screen coordinates to logical coordinates based on zoom and offset
                double logicalX = (e.getX() - offsetX) / zoomFactor;
                double logicalY = (e.getY() - offsetY) / zoomFactor;

                // Print the logical coordinates (which remain the same despite zooming)
                System.out.println("Mouse clicked at (logical): (" + logicalX + ", " + logicalY + ")");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clears the panel and repaints the background color

        Graphics2D g2 = (Graphics2D) g;

        // Apply the zoom and translation transformations
        g2.translate(offsetX, offsetY);
        g2.scale(zoomFactor, zoomFactor);
        drawGrid(g2);


    }

    // Method to draw the grid
    private void drawGrid(Graphics2D g2) {
        int width = getWidth();
        int height = getHeight();

        // Set grid color
        g2.setColor(Color.LIGHT_GRAY);

        // Define the grid spacing (in pixels)
        int gridSpacing = 50;

        // Draw vertical grid lines
        for (int x = 0; x < width; x += gridSpacing) {
            g2.drawLine(x, 0, x, height);
        }

        // Draw horizontal grid lines
        for (int y = 0; y < height; y += gridSpacing) {
            g2.drawLine(0, y, width, y);
        }
    }
}

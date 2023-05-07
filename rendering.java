import javax.swing.*;
import java.awt.*;

class rendering {
    static class Vertex {
        double x;
        double y;
        double z;

        Vertex(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Triangle {
        Vertex v1;
        Vertex v2;
        Vertex v3;

        Color color;

        Triang(Vertex v1, Vertex v2, Vertex v3, Color color) {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                Vertex v1 = new Vertex(100, 100, 100);
                Vertex v2 = new Vertex(-100, -100, 100);
                Vertex v3 = new Vertex(-100, 100, -100);
                Vertex v4 = new Vertex(100, -100, -100);

                List tris = new List();
                tris.add(new Triang(v1, v2, v3, Color.WHITE));
                tris.add(new Triang(v1, v4, v2, Color.RED));
                tris.add(new Triang(v3, v4, v1, Color.GREEN));
                tris.add(new Triang(v2, v4, v3, Color.BLUE));

            }

        };
        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(600, 600);
        frame.setVisible(true);

    }

}
package pl.kozumarc.model;

import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import java.awt.Color;
import javafx.scene.canvas.GraphicsContext;
import java.util.Random;
import java.awt.image.BufferedImage;

public class DrawerTask extends Task {

    private GraphicsContext gc;
    private int n;

    DrawerTask(GraphicsContext g, int p) {
        gc = g;
        n = p;
    }


    @Override
    protected Object call() throws Exception {

        Equation eq = new Equation();
        Random random = new Random();
        BufferedImage bi = new BufferedImage(600, 500, BufferedImage.TYPE_INT_RGB);
        Color midnightBlue = new Color(6, 11, 125);
        int k = 0;
        int l = 0;
        double P = 16 * 16;

        double calka = 0;
        for (int i = 0; i <= n; i++) {
            updateProgress(i, n);
            double x = -8 + (8 + 8) * random.nextDouble();
            double y = -8 + (8 + 8) * random.nextDouble();
            double x1 = ((600) * (x + 8) / (8 + 8));
            double y1 = ((500) * (-y + 8) / (8 + 8));

            if (eq.calc(x, y)) {
                bi.setRGB((int) x1, (int) y1, Color.YELLOW.getRGB());
                if (i % 10000 == 0) {
                    gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0, 0);
                }
                k++;

            } else {
                bi.setRGB((int) x1, (int) y1, midnightBlue.getRGB());
                if (i % 10000 == 0) {
                    gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0, 0);
                }
            }

            if (isCancelled()) {
                break;
            }
        }
        calka = P * k / n;
        return calka;
    }
}
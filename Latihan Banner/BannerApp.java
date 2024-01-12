import javax.swing.*;
import java.awt.*;

public class BannerApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Banner Saya");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BannerPanel bannerPanel = new BannerPanel();
        frame.add(bannerPanel);

        frame.pack();
        frame.setVisible(true);

        bannerPanel.startBannerAnimation();
    }
}

class BannerPanel extends JPanel {
    private String bannerText = "Hallo saya Sherena!";
    private int xCoordinate = 0;
    private int animationSpeed = 15; // bisa kita sesuaikan kecepatan animasinya

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int textWidth = g.getFontMetrics().stringWidth(bannerText);
        g.drawString(bannerText, xCoordinate, getHeight() / 2);

        // Gambar lagi di sebelah kiri jika mencapai batas kanan
        if (xCoordinate + textWidth < getWidth()) {
            g.drawString(bannerText, xCoordinate + textWidth, getHeight() / 2);
        }
    }

    public void startBannerAnimation() {
        while (true) {
            xCoordinate++;
            if (xCoordinate > getWidth()) {
                xCoordinate = 0; //Mengulang posisi ke awal ketika mencapai batas di kanan
            }
            repaint();

            try {
                Thread.sleep(animationSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.github.funthomas424242.jenkinsmonitor.gui;

/*-
 * #%L
 * Jenkins Monitor
 * %%
 * Copyright (C) 2019 - 2020 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Versionsinfofenster extends JFrame {
    public static final Logger LOGGER = LoggerFactory.getLogger(Versionsinfofenster.class);

    protected final ImageIcon goldsteinLogo;

    public Versionsinfofenster() {
        // create Logo
        goldsteinLogo = getImageIcon();
        // create Window Content
        this.add(createGoldsteinPanel());
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setUndecorated(true);
        this.pack();
        this.setAlwaysOnTop(true);
        this.setLocationByPlatform(false);
        this.setLocationRelativeTo(null);
        this.setAutoRequestFocus(false);
        this.setIconImage(goldsteinLogo.getImage());
    }

    protected JPanel createGoldsteinPanel() {

        final JPanel panel = new JPanel();
        panel.add(new JLabel("<html>" +
                "<h1>Jenkins Monitor Version: 0.2.0</h1>" +
                "<p>Wer den Jenkins kontrolliert, kontrolliert die Gegenwart !!!</p>" +
                "</html>"), BorderLayout.PAGE_START);

        final JLabel picLabel = new JLabel(goldsteinLogo);
        panel.add(picLabel, BorderLayout.CENTER);

        panel.add(new JLabel("<html><p>Wer die Vergangenheit kontrolliert, kontrolliert die Zukunft.</p>" +
                "<p>Wer die Gegenwart kontrolliert, kontrolliert die Vergangenheit.</p>" +
                "<p>— Georg Orwell (Author des Buches \"1984\")</p>" +
                "</html>"), BorderLayout.PAGE_END);

        return panel;
    }

    protected ImageIcon getImageIcon() {
        try {
            final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("1984EmmanuelGoldstein.jpg");
            assert inputStream != null;
            final BufferedImage myPicture = ImageIO.read(inputStream);
            inputStream.close();
            return new ImageIcon(myPicture);
        } catch (IOException e) {
            LOGGER.warn(MessageFormat.format("Goldstein Panel nicht erzeugt: {0}", e));
        }
        return null;
    }

}

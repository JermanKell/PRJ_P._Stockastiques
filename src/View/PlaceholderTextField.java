package View;

import java.awt.*;
import java.text.Format;

import javax.swing.*;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class PlaceholderTextField extends JFormattedTextField {

    private String placeholder;

    public PlaceholderTextField() { super(); }

    public PlaceholderTextField(Format format) {
        super(format);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left + 5, pG.getFontMetrics()
                .getMaxAscent() + getInsets().top + 3);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}
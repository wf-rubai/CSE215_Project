package Common;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class IconAdder{

    private static final byte ICON_PADDING = 2;
    private static final HashMap<IconAdder, ImageIcon> CACHED_ICONS = new HashMap<IconAdder, ImageIcon>( 4 );
    private final ImageIcon[] m_icons;

    public IconAdder(final ImageIcon... icons) {
        m_icons = icons;
    }

    public ImageIcon getIcon() {
        if ( !CACHED_ICONS.containsKey( this ) ) {
            CACHED_ICONS.put( this, lcl_combineIcons() );
        }

        return CACHED_ICONS.get( this );
    }

    private ImageIcon lcl_combineIcons() {

        int totalWidth = (m_icons.length - 1) * ICON_PADDING; 
        int minHeight  = 0;
        for ( int i = 0; i < m_icons.length; ++i ) {
            totalWidth += m_icons[i].getIconWidth();
            if ( m_icons[i].getIconHeight() > minHeight ) {
                minHeight = m_icons[i].getIconHeight();
            }
        }

        final BufferedImage compositeImage = new BufferedImage( totalWidth, minHeight, BufferedImage.TYPE_INT_ARGB );
        final Graphics graphics = compositeImage.createGraphics();

        int x = 0;
        for ( int i = 0; i < m_icons.length; ++i ) {
            final ImageIcon icon = m_icons[ i ];
            graphics.drawImage( icon.getImage(), x, 0, null );
            x += icon.getIconWidth() + ICON_PADDING;
        }

        return new ImageIcon( compositeImage );
    }
}
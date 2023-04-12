package markurion.strings.clipboard;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MClipboard {

    // Add string to clipboard.
    public void addToClipboard(String text){
        StringSelection selection = new StringSelection(text);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    // Retrive string from clipboard
    public String readStringClipboard(){
        try {
            String clip = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
            return clip;
        }catch (Exception e){
            return "";
        }
    }
}

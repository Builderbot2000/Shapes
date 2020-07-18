package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A standard rectangle of specified width and height at specified location defined by x, y.
 * Marked by a thickness 1 border to specified character around its borders.
 * Fills the inside of rectangle with lines of injected text that wraps to the next line automatically.
 * Justifies the text inside box to its center.
 */
public class TextBox extends Rectangle {

    private String message;

    public TextBox(int xPos, int yPos, int width, int height, String message) {
        super(xPos, yPos, width, height);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * A modified draw method that inscribes text onto shape using PowerPoint text box rules.
     * @param canvas The canvas upon which all the shapes will be drawn.
     */
    @SuppressWarnings("SuspiciousListRemoveInLoop")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        // Thin text box special case
        if (this.getWidth() - 2 == 1) {
            int messageIterIndex = 0;
            for (int i = getLocationY() + 1; i < getLocationY() + getHeight() - 1; i++) {
                if (messageIterIndex == getMessage().length()) break;
                if (getMessage().charAt(messageIterIndex) != ' ') {
                    canvas.setCellText(getLocationX()+1,i,getMessage().charAt(messageIterIndex));
                }
                else i--;
                messageIterIndex++;
            }
            return;
        }

        // Package message into segmented array of words
        ArrayList<String> messageArray = new ArrayList<>(Arrays.asList(getMessage().split(" ")));
        int lineLength = getWidth() - 1;

        // Break long words into parts
        ArrayList<String> castArray = new ArrayList<>(messageArray);
        for (int i = 0; i<messageArray.size(); i++) {
            String current = messageArray.get(i);
            if (current.length() > lineLength - 1) {
                castArray.remove(i);
                int sizeIter = 0;
                StringBuilder segBuffer = new StringBuilder();
                for (int k = 0; k < current.length(); k++) {
                    if (sizeIter < lineLength - 1) {
                        segBuffer.append(current.charAt(k));
                        sizeIter++;
                    }
                    else {
                        castArray.add(i,segBuffer.toString()+" ");
                        segBuffer.setLength(0);
                        segBuffer.append(current.charAt(k));
                        sizeIter = 0;
                    }
                    if (k == current.length() - 1) {
                        castArray.add(i+1,segBuffer.toString()+" ");
                    }
                }
            }
            else castArray.set(i,current + " ");
        }
        messageArray = castArray;

        int wordIterIndex = 0;
        String word;

        for (int i = getLocationY() + 1; i < getLocationY() + getHeight() - 1; i++) {

            // Fill lineBuffer with formatted message segment
            StringBuilder lineBuffer = new StringBuilder();
            lineBuffer.setLength(lineLength);
            int offset = 0, chunkSize = 0;

            for (int k = wordIterIndex; k < messageArray.size(); k++) {
                word = messageArray.get(k);
                if (word.length() - 1 + offset < lineLength) {
                    lineBuffer.insert(offset,word);
                    wordIterIndex++;
                    offset += word.length();
                    chunkSize += word.length();
                }
                else break;
            }

            // Justify filled line to center
            if (chunkSize != 0) chunkSize--;
            for (int k = 0; k<(lineLength - chunkSize)/2; k++) lineBuffer.insert(0," ");

             // Inject lineBuffer into correspondent line in canvas
            int lineIterIndex = 0;
            for (int j = getLocationX() + 1; j < getLocationX() + getWidth() - 1; j++) {
                if (lineIterIndex >= lineLength) break;
                canvas.setCellText(j,i,lineBuffer.charAt(lineIterIndex));
                lineIterIndex++;
            }
        }
    }
}

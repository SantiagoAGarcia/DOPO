/**
 * Muestra mensajes durante la simulación SilkRoad.
 * 
 * @author Buitrago - Garcia
 * @version 2.0
 */
public class MessageHandler {
    private boolean visible;

    public MessageHandler(boolean visible) {
        this.visible = visible;
    }

    public void showMessage(String msg) {
        if (visible) {
            System.out.println(msg);
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
}
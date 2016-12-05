package client;

/**
 * Created by Anton, Petter, Dragan & Sven on 2016-11-15.
 */
public class ClientMain {

    public static void main(String[] args) {
        Model model = new Model();
        SignalingThread st = new SignalingThread(model);
        st.start();
        GUI gui = new GUI(model);
        ImageProcessingThread IPT = new ImageProcessingThread(model, gui);
        IPT.start();
    }
}

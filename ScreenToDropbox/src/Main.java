import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd_HHmmss");

        String ACCESS_TOKEN = "#######################################";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        Robot screenBot = new Robot();

        for (;;) {
            BufferedImage image = screenBot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            MyThread thread = new MyThread(client, image, formatForDateNow);
            thread.start();
            Thread.sleep(5000);
        }

    }
}

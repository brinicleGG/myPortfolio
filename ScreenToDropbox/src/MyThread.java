import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyThread extends Thread {

    private DbxClientV2 client;
    private BufferedImage image;
    private SimpleDateFormat formatForDateNow;
    private Date date;

    public MyThread(DbxClientV2 client, BufferedImage image, SimpleDateFormat formatForDateNow) {
        this.client = client;
        this.image = image;
        this.formatForDateNow = formatForDateNow;
        date = new Date();
    }

    @Override
    public void run() {

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            client.files().uploadBuilder("/" + formatForDateNow.format(date) + ".png").uploadAndFinish(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

package base;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Listener implements TestWatcher {
    static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("TEST ---> {} <--- FAILED ",context.getTestMethod().get().getName());
        String screenShotName = context.getTestMethod().get().getName()
                + (new SimpleDateFormat("yyyyMMdd_HHmmss").
                format(Calendar.getInstance().getTime()));
        TakesScreenshot ts = (TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).driver;

        File sourseForSkreenShots = ts.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFileToDirectory(sourseForSkreenShots,
                    new File("build/reports/tests/" + screenShotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        attachScreenToAllure(ts);
    }
    @Attachment
    public byte [] attachScreenToAllure(TakesScreenshot takesScreenshot){
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

}

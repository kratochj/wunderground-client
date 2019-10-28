package eu.kratochvil.pwssync;

import org.junit.Test;

public class DownloaderTest {

    @Test
    public void download() {
        Downloader downloader = new Downloader();
        downloader.download();
    }
}
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReadingFilesTest {

    private ClassLoader cl = ReadingFilesTest.class.getClassLoader();

    @Test
    void readingXlsxFilesFromZipArchiveTest() throws Exception {

        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("Downloads.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("sample3.xlsx")) {
                    XLS xls = new XLS(zis);
                    assertThat (xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue())
                            .isEqualTo("January");
                    return;
                }
            }

        }

    }
    @Test
    void readingPdfFilesFromZipArchiveTest() throws Exception {

        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("Downloads.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("Canon.pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat (pdf.text).contains("Guida rapida");
                    return;
                }
            }

        }

    }
    @Test
    void readingCsvFilesFromZipArchiveTest() throws Exception {

        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("Downloads.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("example.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    assertThat (csvReader.readNext()[4]).contains("userAgent");
                    return;
                }
            }

        }

    }
}


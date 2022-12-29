package publicadministration;

import data.DocPath;
import exceptions.BadPathException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PDFDocument {

    private Date creatDate;
    private DocPath path;
    private File file;

    public PDFDocument() {
        this.creatDate = new Date();
        this.path = null;
        this.file = null;
    }

    public String toString () {
        return "PDFDocument{" + "creatDate=" + creatDate + ", path=" + path + ", file=" + file + '}';
    }

    public void moveDoc(DocPath destPath) throws IOException {

    }

    public void openDoc(DocPath path) throws IOException, BadPathException {
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
        } else {
            file = new File(path.getPath());
            Desktop.getDesktop().open(file);
        }
    }

}

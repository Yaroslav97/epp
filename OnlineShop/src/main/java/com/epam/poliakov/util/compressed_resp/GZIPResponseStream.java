package com.epam.poliakov.util.compressed_resp;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;

public class GZIPResponseStream extends ServletOutputStream {

    final AtomicBoolean open = new AtomicBoolean(true);
    private OutputStream output;
    private GZIPOutputStream gzipStream;

    public GZIPResponseStream(OutputStream output) throws IOException {
        this.output = output;
        gzipStream = new GZIPOutputStream(output);
    }

    @Override
    public void close() throws IOException {
        if (open.compareAndSet(true, false)) {
            gzipStream.close();
        }
    }

    @Override
    public void flush() throws IOException {
        gzipStream.flush();
    }

    @Override
    public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        if (!open.get()) {
            throw new IOException("Stream closed!");
        }
        gzipStream.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        if (!open.get()) {
            throw new IOException("Stream closed!");
        }
        gzipStream.write(b);
    }
}

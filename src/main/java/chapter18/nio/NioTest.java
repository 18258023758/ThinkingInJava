package chapter18.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/2
 */
public class NioTest {

    private static final int capacity = 16 * 1024;


    public static StringBuffer nioRead(String path) throws IOException {
        try (FileChannel channel = new FileInputStream(path).getChannel()) {
            StringBuffer stringBuffer = new StringBuffer();
            Charset charset = Charset.forName("UTF-8");
            ByteBuffer buffer = ByteBuffer.allocate(capacity);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                stringBuffer.append(charset.decode(buffer));
                buffer.clear();
            }
            return stringBuffer;
        }
    }

    public static void nioWrite(String path, String content) throws IOException {
        try (FileChannel channel = new FileOutputStream(path, true).getChannel()) {
            byte[] bytes = content.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(capacity);
            for (int i = 0; i < bytes.length; i = i + capacity) {
                buffer = ByteBuffer.wrap(bytes, i, (bytes.length - i) < capacity ? (bytes.length - i) : capacity);
                channel.write(buffer);
                buffer.clear();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        String path = "F:\\DownLoad\\test\\1.txt";
        System.out.println(nioRead(path).toString());
        nioWrite(path, nioRead(path).toString());
    }

}

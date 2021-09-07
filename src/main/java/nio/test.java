package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class test {
    public static void main(String[] args) throws IOException {

        //FileChannel
        FileChannel channel = new FileInputStream("demo.txt").getChannel();
        //缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
       while (true){
        //从channel读取数据写入byteBuffer
        int read = channel.read(byteBuffer);
        System.out.println("读取"+read+"次");
        if (read == -1){
            break;
        }
        //打印 byteBuffer 内容
        byteBuffer.flip();//切换读模式
        while (byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
            System.out.println((char) b);
        }
        byteBuffer.clear();//切换写模式
       }
    }
}

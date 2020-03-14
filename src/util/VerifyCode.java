package util;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


public class VerifyCode{

  private int width = 70; //设置图片缓存区的宽
  private int height = 35; //设置图片缓存区的高
  private Random random = new Random(); //生成随机数字
  private Color bgcolor = new Color(255, 255, 255); //图片的背景颜色
  private String[] fontName = {"宋体", "华文楷体", "黑体", "微软雅黑"};
  private String codes = "123456789asdfghjklzxcvbnmqwertyuiop";
  private String text; // 在图片上生成的文本


  //  创建图片缓存区
  public BufferedImage getImage(){

    BufferedImage bufferedImage = createImage(); // 创建图片缓存区
    Graphics graphics = bufferedImage.getGraphics(); // 得到复制环境
    StringBuffer stringBuffer = new StringBuffer();  // 用于装在生成的验证码

    for(int i = 0; i < 4; i++){
      String string = String.valueOf(randomChar());// 随机生成一个字符
      stringBuffer.append(string); // 将随机生成的字符拼接到一起
      graphics.setFont(randomFont()); // 随机生成字体
      graphics.setColor(randomColo()); //随机生成颜色
      graphics.drawString(string, i * width / 5, height - 5);
    }

    this.text = stringBuffer.toString();
    drawLine(bufferedImage);
    return bufferedImage;

  }

  // 获取图片字符串文本
  public String getText(){
    return text;
  }

  // 保存图片到指定的输出流
  public static void output(BufferedImage bufferedImage, OutputStream outputStream) throws IOException{
    ImageIO.write(bufferedImage, "JPEG", outputStream);
  }

  //  创建图片缓存区方法
  private BufferedImage createImage(){
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
    Graphics graphics = bufferedImage.getGraphics();
    graphics.setColor(bgcolor);
    graphics.fillRect(0, 0, width, height);
    return bufferedImage;
  }

  // 随机生成一个字符
  private char randomChar(){
    int index = random.nextInt(codes.length());
    char y = codes.charAt(index);
    return y;
  }

  // 随机生成颜色
  private Color randomColo(){
    int r = random.nextInt(150);
    int g = random.nextInt(150);
    int b = random.nextInt(150);
    return new Color(r, g, b);
  }

  // 随机生成字体
  private Font randomFont(){
    int index = random.nextInt(fontName.length);
    int style = random.nextInt(4);//设置字体样式，0表示无样式，1表示粗体，2表示斜体，3表示粗体加斜体
    int size = random.nextInt(4) + 19;//设置字体大小，范围在24-27之间
    return new Font(fontName[index], style, size);
  }

  // 添加干扰线
  private void drawLine(BufferedImage bufferedImage){
    //循环三次，画三条干扰线
    //先取到画笔，然后才能画线嘛！
    Graphics graphics = bufferedImage.getGraphics();
    for(int i = 0; i < 3; i++){

      int x1 = random.nextInt(width);
      int y1 = random.nextInt(height);
      int x2 = random.nextInt(width);
      int y2 = random.nextInt(height);
      graphics.setColor(randomColo());
      graphics.drawLine(x1, y1, x2, y2);
    }
  }
}

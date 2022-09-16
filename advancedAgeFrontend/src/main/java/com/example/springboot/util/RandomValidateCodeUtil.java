package com.example.springboot.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomValidateCodeUtil {


    public static final String RANDOMCODEKEY= "RANDOMVALIDATECODEKEY";//放到session中的key
    private String randString = "0123456789";//隨機產生只有數字的字符串 private String
//    private String randString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//隨機產生只有字母的字符串
//    private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//隨機產生數字與字母組合的字符串
    private int width = 95;// 圖片寬
    private int height = 25;// 圖片高
    private int lineSize = 40;// 幹擾線數量
    private int stringNum = 4;// 隨機產生字符數量

//    private static final Logger logger = LoggerFactory.getLogger(RandomValidateCodeUtil.class);

    private Random random = new Random();

    /**
     * 獲得字體
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /**
     * 獲得顏色
     */
    private Color getRandColor(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成隨機圖片
     */
    public void getRandcode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // BufferedImage類是具有緩沖區的Image類,Image類是用於描述圖像信息的類
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();// 產生Image對象的Graphics對象,改對象可以在圖像上進行各種繪制操作
        g.fillRect(0, 0, width, height);//圖片大小
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));//字體大小
        g.setColor(getRandColor(110, 133));//字體顏色
        // 繪制幹擾線
        for (int i = 0; i <= lineSize; i++) {
            drowLine(g);
        }
        // 繪制隨機字符
        String randomString = "";
        for (int i = 1; i <= stringNum; i++) {
            randomString = drowString(g, randomString, i);
        }
//        logger.info(randomString);
        //將生成的隨機字符串保存到session中
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, randomString);
        g.dispose();
        try {
            // 將內存中的圖片通過流動形式輸出到客戶端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
//            logger.error("將內存中的圖片通過流動形式輸出到客戶端失敗>>>>   ", e);
        }

    }

    /**
     * 繪制字符串
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
                .nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString
                .length())));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    /**
     * 繪制幹擾線
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 獲取隨機的字符
     */
    public String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }
}
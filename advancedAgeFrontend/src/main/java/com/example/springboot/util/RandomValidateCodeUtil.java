package com.example.springboot.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomValidateCodeUtil {


	Logger logger = LogManager.getLogger(RandomValidateCodeUtil.class);
    public static final String RANDOMCODEKEY= "RANDOMVALIDATECODEKEY";//���session����key
    private String randString = "0123456789";//�H�����ͥu���Ʀr���r�Ŧ� private String
//    private String randString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//�H�����ͥu���r�����r�Ŧ�
//    private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//�H�����ͼƦr�P�r���զX���r�Ŧ�
    private int width = 95;// �Ϥ��e
    private int height = 25;// �Ϥ���
    private int lineSize = 40;// �F�Z�u�ƶq
    private int stringNum = 4;// �H�����ͦr�żƶq


    private SecureRandom random = new SecureRandom();

    /**
     * ��o�r��
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /**
     * ��o�C��
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
     * �ͦ��H���Ϥ�
     */
    public void getRandcode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // BufferedImage���O�㦳�w�R�Ϫ�Image��,Image���O�Ω�y�z�Ϲ��H������
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();// ����Image��H��Graphics��H,���H�i�H�b�Ϲ��W�i��U��ø��ާ@
        g.fillRect(0, 0, width, height);//�Ϥ��j�p
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));//�r��j�p
        g.setColor(getRandColor(110, 133));//�r���C��
        // ø��F�Z�u
        for (int i = 0; i <= lineSize; i++) {
            drowLine(g);
        }
        // ø���H���r��
        String randomString = "";
        for (int i = 1; i <= stringNum; i++) {
            randomString = drowString(g, randomString, i);
        }
//        logger.info(randomString);
        //�N�ͦ����H���r�Ŧ�O�s��session��
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, randomString);
        g.dispose();
        try {
            // �N���s�����Ϥ��q�L�y�ʧΦ���X��Ȥ��
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }

    }

    /**
     * ø��r�Ŧ�
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
     * ø��F�Z�u
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * ����H�����r��
     */
    public String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }
}
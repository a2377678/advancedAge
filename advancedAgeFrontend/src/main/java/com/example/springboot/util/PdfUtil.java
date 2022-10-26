package com.example.springboot.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfUtil {
	static Logger logger = LogManager.getLogger(PdfUtil.class);
	 // �зǦr��
	 static Font NORMALFONT;
	 // �[�ʦr��
	 static Font BOLDFONT;
	 //�T�w��
	 static float fixedHeight = 27f;
	 //���Z
	 static int spacing = 5;

	 static {
	  try {
	   BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	   NORMALFONT = new Font(bfChinese, 10, Font.NORMAL);
	   BOLDFONT = new Font(bfChinese, 14, Font.BOLD);
	  } catch (IOException e) {
		  logger.warn(e.getMessage());
	  } catch (DocumentException e) {
		  logger.warn(e.getMessage());
	}

	 }

	 public static Document createDocument() {
	  //�ͦ�pdf
	  Document document = new Document();
	  // �����j�p
	  Rectangle rectangle = new Rectangle(PageSize.A4);
	  // �����I���C��
	  rectangle.setBackgroundColor(BaseColor.WHITE);
	  document.setPageSize(rectangle);
	  // ����Z ���A�k�A�W�A�U
	  document.setMargins(20, 20, 20, 20);
	  return document;
	 }


	 /**
	  * @param text �q�����e
	  * @return
	  */
	 public static Paragraph createParagraph(String text, Font font) {
	  Paragraph elements = new Paragraph(text, font);
	  elements.setSpacingBefore(5);
	  elements.setSpacingAfter(5);
	  elements.setSpacingAfter(spacing);
	  return elements;
	 }


	 public static Font createFont(int fontNumber, int fontSize, BaseColor fontColor) {
	  //����r�� ----���M����|�ýX
	  BaseFont bf = null;
	  try {
//	   bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	   bf = BaseFont.createFont("C:/Windows/Fonts/mingliu.ttc,0",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
	   return new Font(bf, fontNumber, fontSize, fontColor);
	  } catch (IOException e) {
		  logger.warn(e.getMessage());
	  } catch (DocumentException e) {
		  logger.warn(e.getMessage());
	}
	  return new Font(bf, Font.DEFAULTSIZE, Font.NORMAL, BaseColor.BLACK);
	 }

	 /**
	  * ���ê����ؽu
	  *
	  * @param cell �椸��
	  */
	 public static void disableBorderSide(PdfPCell cell) {
	  if (cell != null) {
	   cell.disableBorderSide(1);
	   cell.disableBorderSide(2);
	   cell.disableBorderSide(4);
	   cell.disableBorderSide(8);
	  }
	 }


	 /**
	  * �Ыة~���o�椸��
	  *
	  * @return
	  */
	 public static PdfPCell createCenterPdfPCell() {
	  PdfPCell cell = new PdfPCell();
	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	  cell.setFixedHeight(fixedHeight);
	  return cell;
	 }

	 /**
	  * �Ыث��w��r�o�椸��
	  *
	  * @param text
	  * @return
	  */
	 public static PdfPCell createCenterPdfPCell(String text, int rowSpan, int colSpan, Font font) {
	  PdfPCell cell = new PdfPCell(new Paragraph(text, font));
	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	  cell.setFixedHeight(fixedHeight);
	  cell.setRowspan(rowSpan);
	  cell.setColspan(colSpan);
	  return cell;
	 }

	 /**
	  * @param len ���C��
	  * @return
	  */
	 public static PdfPTable createPdfPTable(int len) {
	  PdfPTable pdfPTable = new PdfPTable(len);
	  pdfPTable.setSpacingBefore(5);
	  pdfPTable.setHorizontalAlignment(Element.ALIGN_CENTER);
	  return pdfPTable;
	 }
	}
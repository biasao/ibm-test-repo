package com.blabs.records.utilities.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.blabs.records.utilities.service.PDFReader;

public class AnvisaMedicinePDFReaderBean implements PDFReader {
	
	private static final String INSERT_INTO_MEDICINE_VALUES = "insert into medicine (id, name, producer, commercialAlias, concentration, form, inclusionDate) values (";

	public void readPDF() {
		try {
			final InputStream is = getClass().getClassLoader().getResourceAsStream("META-INF/medicineFiles/Lista A de medicamentos de referencia-17-03-2014.pdf");
			final PDDocument document = PDDocument.load(is);
			
			final PDFTextStripper stripper = new PDFTextStripper();
			final StringWriter outputStream = new StringWriter();
			
			stripper.writeText(document, outputStream);
			
			parseContent(outputStream.getBuffer());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseContent(final StringBuffer pdfContent) {
		String contentWithoutLines = pdfContent.toString().replace("\n", "");
		contentWithoutLines = removeUndesiredTokens(contentWithoutLines);
		
		final Pattern line = Pattern.compile(".*?\\d\\d/\\d\\d/\\d\\d\\d\\d");

	    Matcher m = line.matcher(contentWithoutLines);
	    while (m.find( )) {
	    	final StringTokenizer tokenizer = new StringTokenizer(m.group(), " ");
	    	
	    	StringBuilder builder = new StringBuilder(INSERT_INTO_MEDICINE_VALUES);
	    	while (tokenizer.hasMoreElements()) {
	    		if(builder.length() > INSERT_INTO_MEDICINE_VALUES.length()) {
	    			builder.append(", ");
	    		}
	    		builder.append("'" + tokenizer.nextToken() + "'");
			}
	    	builder.append(");");
	    	
	    	System.out.println(builder);
	    }
	}

	private String removeUndesiredTokens(final String contentWithoutLines) {
		return contentWithoutLines.substring(224);
	}
}

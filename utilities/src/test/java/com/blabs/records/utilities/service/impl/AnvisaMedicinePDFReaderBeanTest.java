package com.blabs.records.utilities.service.impl;

import org.junit.Test;

import com.blabs.records.utilities.service.PDFReader;

public class AnvisaMedicinePDFReaderBeanTest implements PDFReader {
	private AnvisaMedicinePDFReaderBean anvisaMedicinePDFReaderBean = new AnvisaMedicinePDFReaderBean();

	@Test
	public void readPDF_checkIfAnvisaFileIsInResources() {
		anvisaMedicinePDFReaderBean.readPDF();
	}
}

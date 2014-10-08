package com.univocity.articles.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import com.univocity.articles.jmh.params.FileToProcess;

import au.com.bytecode.opencsv.CSVReader;

public class OpenCsvParser {
	
	@Benchmark
	public void parseFile(final FileToProcess fileToProcess, final Blackhole blackhole) throws Exception {
		CSVReader reader = new CSVReader(fileToProcess.getReader());
		try {
			String[] data;
			while((data = reader.readNext())!= null)  {
				blackhole.consume(data);
			}
		} finally {
			reader.close();
		}
	}
}

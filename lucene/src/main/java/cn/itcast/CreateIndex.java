package cn.itcast;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import com.hankcs.lucene.HanLPAnalyzer;

public class CreateIndex {

	@Test
	public void createIndex() {
		//新的加入注释
		try {
			Directory directory = FSDirectory.open(Paths.get("E:\\框架视频\\lucene\\资料\\lucene"));
			Analyzer analyzer = new HanLPAnalyzer();
			IndexWriterConfig conf = new IndexWriterConfig(analyzer);
			IndexWriter writer = new IndexWriter(directory,conf);
			
			File fileDir = new File("E:\\框架视频\\lucene\\资料\\searchsource");
			File[] files = fileDir.listFiles();
			int i = 0;
			for(File file : files) {
				System.out.println("当前的文件名为:====="+file.getName());
				System.out.println("当前的文件路径为:====="+file.getPath());
				System.out.println("当前的文件内容为:====="+FileUtils.readFileToString(file));
				System.out.println("当前的文件大小为:====="+FileUtils.sizeOf(file));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

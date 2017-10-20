package pattern.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StrategyDemo {
	public static void main(String[] args) {
		CompressionContext ctx = new CompressionContext();
		//chose zip
		ctx.setCompressionStrategy(new ZipCompressionStrategy());
		
		
		List<File> fileList = new ArrayList<File>();
		ctx.createArchive(fileList);
	}
}

package ch03.ex15;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.logging.Logger;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class LatentImageTest {

	Image image;
	Viewer viewer = new Viewer();

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		viewer.setDefaultImage();
		image = viewer.getImage();
	}

	@Test
	public void 同じ画像が生成できているか確認() {
		LatentImage imageStream = new LatentImage();

		Color[][] colors = imageStream.form(image).transform(Color::brighter).transform(Color::invert)
				.transform((x, y, color) -> {
					return color.brighter();
				}).parallelTransform();
		
		Image sample1 = imageStream.form(image).transform(Color::brighter).transform(Color::invert)
				.transform(Color::brighter).getImage();

		for (int w = 0; w < (int) sample1.getWidth(); w++) {
			for (int h = 0; h < (int) sample1.getHeight(); h++) {
				Color c1 = sample1.getPixelReader().getColor(w, h);
				Color c2 = colors[w][h];
				assertThat(c1, is(c2));
			}
		}
		
	}
	
	@Test
	public void 並列速度確認() {
		LatentImage imageStream = new LatentImage();

		long start1 = System.currentTimeMillis();
		Color[][] colors = imageStream.form(image).transform((x, y, color) -> {
					return color.brighter();
				}).parallelTransform();
		long end1 = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		Image sample1 = imageStream.form(image).transform(Color::brighter).transform(Color::invert)
				.transform(Color::brighter).getImage();
		long end2 = System.currentTimeMillis();
		Logger.getLogger("RESULT").info("Parallel " + (end1 - start1) + " millsec");
		Logger.getLogger("RESULT").info("Normal   " + (end2 - start2) + " millsec");
		
	}

	public static Image toImage(Color[][] colors, Image image) {
		WritableImage out = new WritableImage((int) image.getWidth(), (int) image.getHeight());
		for (int w = 0; w < colors.length; w++) {
			for (int h = 0; h < colors[0].length; h++) {
				out.getPixelWriter().setColor(h, w, colors[w][h]);
			}
		}
		return out;
	}
}

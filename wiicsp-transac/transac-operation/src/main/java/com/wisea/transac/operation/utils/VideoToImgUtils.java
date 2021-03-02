package com.wisea.transac.operation.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.util.ResourceUtils;

public class VideoToImgUtils {
	/**
	 * 获取视频时长，单位为秒
	 */
	@SuppressWarnings("resource")
	public static long getVideoDuration(File video) {
	    long duration = 0L;
	    try {
	      FFmpegFrameGrabber ff = new FFmpegFrameGrabber(video);
	      ff.start();
	      duration = ff.getLengthInTime() / (1000 * 1000);
	      ff.stop();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return duration;
	  }
	/**
	 * 截取视频获得指定帧的图片
	 *
	 * @param video  源视频文件
	 * @param picPath 截图存放路径
	 */
	@SuppressWarnings("resource")
	public static InputStream getVideoPic(InputStream video) {
	    try {
	      FFmpegFrameGrabber ff = new FFmpegFrameGrabber(video);
	      ff.start();
	      // 截取中间帧图片(具体依实际情况而定)
	      int i = 0;
	      int length = ff.getLengthInFrames();
	      int middleFrame = length / 2;
	      Frame frame = null;
	      while (i < length) {
	        frame = ff.grabFrame();
	        if ((i > middleFrame) && (frame.image != null)) {
	          break;
	        }
	        i++;
	      }
	      // 截取的帧图片
	      Java2DFrameConverter converter = new Java2DFrameConverter();
	      BufferedImage srcImage = converter.getBufferedImage(frame);
	      int srcImageWidth = srcImage.getWidth();
	      int srcImageHeight = srcImage.getHeight();
	      // 对截图进行等比例缩放(缩略图)
	      int width = 480;
	      int height = (int) (((double) width / srcImageWidth) * srcImageHeight);
	      BufferedImage thumbnailImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	      thumbnailImage.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
	      ByteArrayOutputStream os = new ByteArrayOutputStream();
	      ImageIO.write(thumbnailImage, "png", os);
	      InputStream input = new ByteArrayInputStream(os.toByteArray());
	      ff.stop();
	      return input;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return null;
	  }
	/**
	 * 截取视频获得指定帧的图片
	 *
	 * @param video  源视频文件
	 * @param picPath 截图存放路径
	 */
	@SuppressWarnings("resource")
	public static void getVideoPic(File video, String picPath) {
	    try {
	    FFmpegFrameGrabber ff = new FFmpegFrameGrabber(video);
	      ff.start();
	      // 截取中间帧图片(具体依实际情况而定)
	      int i = 0;
	      int length = ff.getLengthInFrames();
	      int middleFrame = length / 2;
	      Frame frame = null;
	      while (i < length) {
	        frame = ff.grabFrame();
	        if ((i > middleFrame) && (frame.image != null)) {
	          break;
	        }
	        i++;
	      }
	      // 截取的帧图片
	      Java2DFrameConverter converter = new Java2DFrameConverter();
	      BufferedImage srcImage = converter.getBufferedImage(frame);
	      int srcImageWidth = srcImage.getWidth();
	      int srcImageHeight = srcImage.getHeight();
	      // 对截图进行等比例缩放(缩略图)
	      int width = 480;
	      int height = (int) (((double) width / srcImageWidth) * srcImageHeight);
	      BufferedImage thumbnailImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	      thumbnailImage.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
	      File picFile = new File(picPath);
	      ImageIO.write(thumbnailImage, "jpg", picFile);
	      ff.stop();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  public static void main(String[] args) {
//		    String videoPath = ResourceUtils.CLASSPATH_URL_PREFIX + "video1.mp4";
		    File video = null;
		    try {
		      video = ResourceUtils.getFile("C:\\Users\\tf\\Desktop\\b111.mp4");
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		    String picPath = "C:\\Users\\tf\\Desktop\\video.jpg";
		    getVideoPic(video, picPath);

		    long duration = getVideoDuration(video);
		    System.out.println("videoDuration = " + duration);
		  }
}


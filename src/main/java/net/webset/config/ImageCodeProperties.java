/**
 * 
 */
package net.webset.config;

/**
 * @author 梁雪峰
 *
 */
public class ImageCodeProperties extends BaseProperties {
	
	public ImageCodeProperties() {
		setLength(4);
	}
	 
	private int width = 67;
	private int height = 23;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
